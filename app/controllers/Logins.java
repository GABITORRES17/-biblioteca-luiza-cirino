package controllers;

import models.Cadastro;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void logar(String login, String senha) {
		Cadastro cadastroBanco = Cadastro.obterUsuario(login, senha);
		if (cadastroBanco == null) {
			flash.error("Usuário ou senha inválido. Tente novamente!");
			form();
		}
		
		session.put("usuarioLogado", login);
		session.put("perfilUsuario", cadastroBanco.perfil.name());
		flash.success("Login realizado com sucesso!!");
		Livros.listar(null);
		
	}
	
	public static void sair() {
		session.clear();
		form();
	}

}
