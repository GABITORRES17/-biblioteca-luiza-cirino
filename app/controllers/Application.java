package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	// Página inicial: cada perfil vê a sua
	public static void index() {
		if (!session.contains("usuarioLogado")) {
			Logins.form();
		}
		if (Perfil.BIBLIOTECARIO.name().equals(session.get("perfilUsuario"))) {
			montarPainel();
		}
		montarInicioAluno();
	}

	// ================= PAINEL DA BIBLIOTECÁRIA =================
	private static void montarPainel() {
		// Os quatro números do topo
		long totalLivros = Livro.count("status = ?1", Status.ATIVO);
		long totalAlunos = Cadastro.count("perfil = ?1 and status = ?2", Perfil.ALUNO, Status.ATIVO);
		long emAberto = Emprestimo.count("dataDevolucao is null");
		long reservasPendentes = Reserva.count("status = ?1", StatusRes.PENDENTE);

		// Listas
		List<Emprestimo> recentes = Emprestimo.find("order by dataEmprestimo desc, id desc").fetch(5);
		List<Reserva> reservas = Reserva.find("status = ?1 order by dataRes desc", StatusRes.PENDENTE).fetch(5);

		// Acervo por gênero: cada item é {nome, quantidade, tamanho da barra}
		List<Genero> generos = Genero.find("order by genero").fetch();
		List<Object[]> acervo = new ArrayList<Object[]>();
		long maior = 1;
		for (Genero g : generos) {
			long total = Livro.count("genero = ?1 and status = ?2", g, Status.ATIVO);
			if (total > maior) {
				maior = total;
			}
			acervo.add(new Object[] { g.genero, total, 0 });
		}
		for (Object[] item : acervo) {
			long total = (Long) item[1];
			item[2] = (int) (total * 100 / maior);
		}

		Date hoje = new Date();
		renderTemplate("Application/painel.html", totalLivros, totalAlunos, emAberto,
				reservasPendentes, recentes, reservas, acervo, hoje);
	}

	// ================= INÍCIO DO ALUNO =================
	private static void montarInicioAluno() {
		Cadastro aluno = Cadastro.find("nome = ?1", session.get("usuarioLogado").toUpperCase()).first();
		if (aluno == null) {
			session.clear();
			Logins.form();
		}

		// Primeiro nome, só com a primeira letra maiúscula (GABI -> Gabi)
		String primeiroNome = aluno.nome.trim().split(" ")[0];
		primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(1).toLowerCase();

		List<Emprestimo> abertos = Emprestimo
				.find("aluno = ?1 and dataDevolucao is null order by dataEmprestimo desc", aluno).fetch();
		long lidos = Emprestimo.count("aluno = ?1 and dataDevolucao is not null", aluno);
		List<Reserva> reservas = Reserva
				.find("aluno = ?1 and status = ?2 order by dataRes desc", aluno, StatusRes.PENDENTE).fetch();
		List<Livro> novidades = Livro.find("status = ?1 order by id desc", Status.ATIVO).fetch(5);

		renderTemplate("Application/inicio.html", primeiroNome, abertos, lidos, reservas, novidades);
	}
}