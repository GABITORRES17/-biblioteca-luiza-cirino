package controllers;

import models.Cadastro;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void logar(String login, String senha) {
		if (!Cadastro.existeUsuario(login, senha)) {
			flash.error("Usuário ou senha inválido. Tente novamente!");
			form();	
			session.put("usuarioLogado", login);
			flash.success("Login realizado com sucesso!!");
			Livros.listar(null);
		}
		
		session.put("usuarioLogado", login);
		flash.success("Login realizado com sucesso!!");
		Livros.listar(login);
		
	}
	
	public static void sair() {
		session.clear();
		form();
	}

}
