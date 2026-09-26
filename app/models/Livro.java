package models;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Livro extends Model{
	
	public String login;
	public String senha;
	
    public String titulo;
    public String autor;
    public boolean disponivel;
    
    public int quantidade;
    public int emprestados;

    @ManyToOne
    public Genero genero;
    
    @Enumerated(EnumType.STRING)
    public Status status;
    
    public Livro() {
    	this.status = Status.ATIVO;
    }
   
}