package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cadastro extends Model {

	@Required
	@MinSize(3)
	public String nome;

	@Required
	@MinSize(4)
	public String senha;
	
	@ManyToOne
	public Turma turma;

	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Enumerated(EnumType.STRING)
	public Perfil perfil;

	public Cadastro() {
		this.status = Status.ATIVO;
		this.perfil = Perfil.ALUNO;
	}
	
	public static Cadastro obterUsuario(String login, String senha) {
		if (login == null || senha == null) {
			return null;
		}
		return Cadastro.find("nome = ?1 and senha = ?2 and status = ?3",
				login.toUpperCase(), senha.toLowerCase(), Status.ATIVO).first();
	}

}
