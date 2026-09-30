package models;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Livro extends Model{
	
	public String login;
	public String senha;
	
	@Required
	@MinSize(2)
	public String titulo;

	@Required
	@MinSize(3)
	public String autor;

	@Min(1)
	public int quantidade;
    
    public boolean disponivel;
    public int emprestados;

    @ManyToOne
    public Genero genero;
    
    @Enumerated(EnumType.STRING)
    public Status status;
    
    public Livro() {
    	this.status = Status.ATIVO;
    }
   
}