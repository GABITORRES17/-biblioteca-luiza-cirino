package models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Reserva extends Model {
	
	@ManyToOne
	public Cadastro aluno;
	  
	@ManyToOne
	public Livro livro;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date dataRes;
	
	@Enumerated(EnumType.STRING)
	public StatusRes status;
	
	// false = a bibliotecária ainda não viu esta reserva 
		public boolean lida;
		
		public Reserva() {
			this.dataRes = new Date();
			this.status = StatusRes.PENDENTE;
			this.lida = false;
		}
		// Quantidade de reservas novas
		public static long novas() {
			return Reserva.count("status = ?1 and lida = ?2", StatusRes.PENDENTE, false);
		}

}
