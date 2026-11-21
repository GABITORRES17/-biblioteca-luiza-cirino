package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Emprestimo extends Model{
	
	@ManyToOne
	public Cadastro aluno;
	
	@ManyToOne
	public Livro livro;
	
	@Temporal(TemporalType.DATE)
	public Date dataEmprestimo;
	
	@Temporal(TemporalType.DATE)
	public Date dataDevolucao;
	
	public static void recalcular(Livro l) {
		if (l == null) {
			return;
		}
		l.emprestados = (int) Emprestimo.count("livro = ?1 and dataDevolucao is null", l);
		l.disponivel = l.emprestados < l.quantidade;
		l.save();
	}

}
