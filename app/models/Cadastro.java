package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Cadastro extends Model {

	public String nome;
	public String senha;
	
	@ManyToOne
	public Turma turma;
	
	 @Enumerated(EnumType.STRING)
	    public Status status;
	    
	    public Cadastro() {
	    	this.status = Status.ATIVO;
	    }
	    
	    public static boolean existeUsuario(String login, String senha) {
	        if (login == null || senha == null) {
	            return false;
	        }
	        Cadastro c = Cadastro.find("nome = ?1 and senha = ?2 and status = ?3",
	                login.toUpperCase(), senha.toLowerCase(), Status.ATIVO).first();
	        return c != null;
	    }
	
}
