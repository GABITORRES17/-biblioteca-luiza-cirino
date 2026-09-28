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
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import security.Bibliotecario;
import security.Seguranca;


@With(Seguranca.class)
public class Cadastros extends Controller{

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
	
	public static void salvar(Cadastro cadastro) {
		 if (cadastro.senha == null || cadastro.senha.length() < 4) {
		        flash.error("Senha deve ter pelo menos 4 dígitos");
		        formCadastro();
		    }
		    if (cadastro.nome == null || cadastro.nome.isEmpty()) {
		        flash.error("Nome é obrigatório");
		        formCadastro();
		    }
		    Cadastro novo = new Cadastro();// LEMBRA: perfil ALUNO e status ATIVO vêm do construtor
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
}
