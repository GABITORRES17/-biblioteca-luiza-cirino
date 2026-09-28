package security;

import controllers.Logins;
import models.Perfil;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

	@Before
	static void auth() {
		if (!session.contains("usuarioLogado")) {
			flash.error("Restrito para usuários autenticados!");
			Logins.form();
		}
	}

	@Before
	static void verificarBibliotecario() {
		String perfil = session.get("perfilUsuario");
		Bibliotecario possuiAnotacao = getActionAnnotation(Bibliotecario.class);
		if (possuiAnotacao != null && !Perfil.BIBLIOTECARIO.name().equals(perfil)) {
			forbidden("Acesso restrito à bibliotecária");
		}
	}
}