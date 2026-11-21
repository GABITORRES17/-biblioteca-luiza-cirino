package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import models.Cadastro;
import models.Emprestimo;
import models.Livro;
import models.Perfil;
import models.Status;
import play.mvc.Controller;
import play.mvc.With;
import security.Bibliotecario;
import security.Seguranca;


@With(Seguranca.class)
public class Emprestimos extends Controller{
	// Bibliotecária vê todos; aluno vê só os dele
	@Bibliotecario
	public static void listar() {
		List<Emprestimo> emprestimos;
		if (Perfil.BIBLIOTECARIO.name().equals(session.get("perfilUsuario"))) {
			emprestimos = Emprestimo.find("dataDevolucao is null order by dataEmprestimo desc").fetch();		
		} else {
			String login = session.get("usuarioLogado".toUpperCase());
			Cadastro aluno = Cadastro.find("nome = ?1",login).first();
			emprestimos = Emprestimo.find("aluno = ?1 and dataDevolucao is null order by dataEmprestimo desc", aluno).fetch();
		}
		render(emprestimos);
	}
	@Bibliotecario
	public static void form(Long id) {
		Emprestimo e = new Emprestimo();
		if (id != null) {
			e = Emprestimo.findById(id);
		} else {
			e.dataEmprestimo = new Date();
		}
		List<Cadastro> alunos = Cadastro.find("perfil = ?1 and status = ?2 order by nome",
				Perfil.ALUNO, Status.ATIVO).fetch();
		List<Livro> livros = Livro.find("status = ?1 order by titulo", Status.ATIVO).fetch();
		render(e, alunos, livros);
	}
	// Converte texto em número (se vier vazio ou inválido, devolve null)
	private static Long paraLong(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return null;
		}
		try {
			return Long.valueOf(texto.trim());
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	// Converte texto no formato 2026-11-18 em data (se vier vazio ou inválido, devolve null)
	private static Date paraData(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return null;
		}
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(texto.trim());
		} catch (ParseException ex) {
			return null;
		}
	}

	// Salva empréstimo novo ou editado
	@Bibliotecario
	public static void salvar() {
		Long id = paraLong(params.get("id"));
		Long alunoId = paraLong(params.get("alunoId"));
		Long livroId = paraLong(params.get("livroId"));
		Date dataEmprestimo = paraData(params.get("dataEmprestimo"));
		Date dataDevolucao = paraData(params.get("dataDevolucao"));

		if (alunoId == null || livroId == null || dataEmprestimo == null) {
			flash.error("Escolha o aluno, o livro e a data em que pegou.");
			form(id);
		}
		if (dataDevolucao != null && dataDevolucao.before(dataEmprestimo)) {
			flash.error("A devolução não pode ser antes do empréstimo.");
			form(id);
		}

		Emprestimo e = new Emprestimo();
		if (id != null) {
			e = Emprestimo.findById(id);
		}
		Livro livroAntigo = e.livro;

		e.aluno = Cadastro.findById(alunoId);
		e.livro = Livro.findById(livroId);
		e.dataEmprestimo = dataEmprestimo;
		e.dataDevolucao = dataDevolucao;
		e.save();

		Emprestimo.recalcular(e.livro);
		Emprestimo.recalcular(livroAntigo);

		flash.success("Empréstimo salvo!");
		listar();
	}
	// Registra a devolução com a data de hoje
	@Bibliotecario
	public static void devolver(Long id) {
		Emprestimo e = Emprestimo.findById(id);
		if (e.dataDevolucao == null) {
			e.dataDevolucao = new Date();
			e.save();
			Emprestimo.recalcular(e.livro);
		}
		listar();
	}
	

}
