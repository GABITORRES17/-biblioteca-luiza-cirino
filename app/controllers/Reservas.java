package controllers;

import java.util.List;

import models.Cadastro;
import models.Emprestimo;
import models.Livro;
import models.Perfil;
import models.Reserva;
import models.Status;
import models.StatusRes;
import play.mvc.Controller;
import play.mvc.With;
import security.Bibliotecario;
import security.Seguranca;

@With(Seguranca.class)
public class Reservas extends Controller {


	// Descobre qual aluno está logado (o nome é guardado em maiúsculas no banco)
	private static Cadastro usuarioLogado() {
		String login = session.get("usuarioLogado");
		if (login == null) {
			return null;
		}
		return Cadastro.find("nome = ?1", login.toUpperCase()).first();
	}

	// ================= ALUNO =================

	// Aluno reserva um livro
	public static void reservar(Long id) {
		if (Perfil.BIBLIOTECARIO.name().equals(session.get("perfilUsuario"))) {
			flash.error("A bibliotecária não precisa reservar livros.");
			Livros.listar(null);
		}

		Livro livro = Livro.findById(id);
		if (livro == null) {
			flash.error("Livro não encontrado (id recebido: " + id + ").");
			Livros.listar(null);
		}
		if (livro.status == Status.INATIVO) {
			flash.error("Este livro foi removido e não pode ser reservado.");
			Livros.listar(null);
		}

		Cadastro aluno = usuarioLogado();
		if (aluno == null) {
			flash.error("O usuário \"" + session.get("usuarioLogado")
					+ "\" não foi encontrado no cadastro de alunos. Saia e entre de novo.");
			Livros.listar(null);
		}

		// Não deixa reservar o mesmo livro duas vezes
		long jaReservou = Reserva.count("aluno = ?1 and livro = ?2 and status = ?3",
				aluno, livro, StatusRes.PENDENTE);
		if (jaReservou > 0) {
			flash.error("Você já reservou \"" + livro.titulo + "\". Aguarde a bibliotecária.");
			Livros.listar(null);
		}

		Reserva r = new Reserva();
		r.aluno = aluno;
		r.livro = livro;
		r.save();

		flash.success("Reserva feita! A bibliotecária foi avisada.");
		minhasRes();
	}

	// Lista as reservas do aluno logado
	public static void minhasRes() {
		Cadastro aluno = usuarioLogado();
		List<Reserva> reservas = Reserva.find("aluno = ?1 order by dataRes desc", aluno).fetch();
		render(reservas);
	}

	// Aluno cancela a própria reserva (a bibliotecária também pode cancelar)
	public static void cancelar(Long id) {
		Reserva r = Reserva.findById(id);
		notFoundIfNull(r);

		boolean bibliotecaria = Perfil.BIBLIOTECARIO.name().equals(session.get("perfilUsuario"));
		Cadastro aluno = usuarioLogado();
		if (!bibliotecaria && (aluno == null || !r.aluno.id.equals(aluno.id))) {
			forbidden("Esta reserva não é sua.");
		}

		if (r.status == StatusRes.PENDENTE) {
			r.status = StatusRes.CANCELADA;
			r.lida = true;
			r.save();
			flash.success("Reserva cancelada.");
		}

		if (bibliotecaria) {
			listar();
		}
		minhasRes();
	}

	// ================= BIBLIOTECÁRIA =================

	// Tela de reservas da bibliotecária; ao abrir, as reservas novas são marcadas como vistas
	@Bibliotecario
	public static void listar() {
		List<Reserva> pendentes = Reserva.find("status = ?1 order by dataRes", StatusRes.PENDENTE).fetch();
		List<Reserva> historico = Reserva.find("status != ?1 order by dataRes desc", StatusRes.PENDENTE).fetch(20);

		for (Reserva r : pendentes) {
			if (!r.lida) {
				r.lida = true;
				r.save();
			}
		}
		render(pendentes, historico);
	}

	// Atende a reserva: registra o empréstimo do livro para o aluno
	@Bibliotecario
	public static void atender(Long id) {
		Reserva r = Reserva.findById(id);
		notFoundIfNull(r);

		if (r.status != StatusRes.PENDENTE) {
			listar();
		}

		Livro l = r.livro;
		if (l.emprestados >= l.quantidade) {
			flash.error("Não há exemplar disponível de \"" + l.titulo + "\" no momento.");
			listar();
		}

		Emprestimo emp = new Emprestimo();
		emp.aluno = r.aluno;
		emp.livro = l;
		emp.dataEmprestimo = new java.util.Date();
		emp.save();
		Emprestimo.recalcular(l);

		r.status = StatusRes.ATENDIDA;
		r.lida = true;
		r.save();

		flash.success("Reserva atendida! Livro emprestado a " + r.aluno.nome + ".");
		listar();
	}
}

