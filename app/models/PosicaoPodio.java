package models;

import play.db.jpa.Model;

public class PosicaoPodio implements Comparable<PosicaoPodio>{
	
	public String nome;
	public String turma;
	public int livros;   // quantos livros devolveu
	public int lugar;
	public int percentual;
	
	// Mais livros vem primeiro; se empatar, ordem alfabética
	public int compareTo(PosicaoPodio outro) {
		if (this.livros != outro.livros) {
			return outro.livros - this.livros;
		}
		return  this.nome.compareTo(outro.nome);
	}

}
