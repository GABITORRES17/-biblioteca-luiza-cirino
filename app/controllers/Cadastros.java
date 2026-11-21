package controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.Normalizer;
import java.util.List;

import models.Cadastro;
import models.Perfil;
import models.Status;
import models.Turma;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import security.Bibliotecario;
import security.Publico;
import security.Seguranca;


@With(Seguranca.class)
public class Cadastros extends Controller{

	@Publico
	public static void formCadastro() {
		Cadastro c = new Cadastro();
		List<Turma> turmas = Turma.findAll();
		render(c, turmas);
	}
	
	//para igunora os caracteres defrrentes
	private static String normalizar(String texto) {
	    String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
	            .replaceAll("\\p{M}", "");
	    return semAcentos.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().trim();
	}
	

	@Bibliotecario
	public static void listar(String t) {
	    List<Cadastro> todos = Cadastro.find("status != ?1", Status.INATIVO).fetch();
	    List<Cadastro> cadastros = todos;
	    
	    //buscar
	    if (t != null && !t.trim().isEmpty()) {
	        String termo = normalizar(t);
	        cadastros = new java.util.ArrayList<Cadastro>();
	        for (Cadastro c : todos) {
	            boolean nomeCombina = c.nome != null && normalizar(c.nome).contains(termo);
	            boolean turmaCombina = c.turma != null && c.turma.turma != null && normalizar(c.turma.turma).contains(termo);
	            if (nomeCombina || turmaCombina) {
	                cadastros.add(c);
	            }
	        }
	    }
	    
	    render(cadastros, t);
	}
	
	@Publico
	public static void salvar(@Valid Cadastro cadastro) {
	    if (cadastro.nome != null
	            && Cadastro.count("nome = ?1", cadastro.nome.toUpperCase()) > 0) {
	        validation.addError("cadastro.nome", "Este nome de usuário já existe");
	    }

	    if (validation.hasErrors()) {
	        Cadastro c = cadastro;
	        List<Turma> turmas = Turma.findAll();
	        renderTemplate("Cadastros/formCadastro.html", c, turmas);
	    }

	    Cadastro novo = new Cadastro();
	    novo.nome = cadastro.nome.toUpperCase();
	    novo.senha = cadastro.senha.toLowerCase();
	    novo.turma = cadastro.turma;
	    novo.save();

			flash.success("Cadastro realizado com sucesso! Faça login.");
			Logins.form();
		}
	
	@Bibliotecario
	public static void remover(Long id) {
		Cadastro r = Cadastro.findById(id);
		r.status = Status.INATIVO;
		r.save();
		
		flash.success("Aluno(a) removido com sucesso!");
		listar(null);
	}
	
	// Perfil do aluno: dados, empréstimos (abertos e devolvidos) e reservas
	public static void detalhar(Long id) {
		Cadastro aluno = Cadastro.findById(id);
		notFoundIfNull(aluno);

		// Aluno só pode ver o próprio histórico; a bibliotecária vê o de qualquer um
		boolean bibliotecaria = Perfil.BIBLIOTECARIO.name().equals(session.get("perfilUsuario"));
		if (!bibliotecaria && !aluno.nome.equals(session.get("usuarioLogado").toUpperCase())) {
			forbidden("Você só pode ver o seu próprio histórico.");
		}

		List<models.Emprestimo> emprestimos = models.Emprestimo
				.find("aluno = ?1 order by dataEmprestimo desc, id desc", aluno).fetch();
		List<models.Reserva> reservas = models.Reserva
				.find("aluno = ?1 order by dataRes desc", aluno).fetch();
		render(aluno, emprestimos, reservas);
	}

	// Atalho para o aluno abrir o próprio histórico
	public static void meuHistorico() {
		Cadastro aluno = Cadastro.find("nome = ?1", session.get("usuarioLogado").toUpperCase()).first();
		notFoundIfNull(aluno);
		detalhar(aluno.id);
	}
}
