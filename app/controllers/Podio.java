package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Emprestimo;
import models.PosicaoPodio;
import models.Status;
import play.mvc.Controller;
import play.mvc.With;
import security.Seguranca;

@With(Seguranca.class)
public class Podio extends Controller {
	
	public static void listar() {
	// Só conta livros já devolvidos (o aluno terminou de ler)
	 List<Emprestimo> devolvidos = Emprestimo.find("dataDevolucao is not null").fetch();
	 
	// Soma quantos livros cada aluno devolveu
	 Map<Long, PosicaoPodio>porAluno = new HashMap<Long, PosicaoPodio>();
	 for (Emprestimo e : devolvidos) {
		 if(e.aluno == null || e.aluno.status == Status.INATIVO) {
			 continue;
		 }
		 PosicaoPodio p = porAluno.get(e.aluno.id);
		 if (p == null) {
			 p = new PosicaoPodio();
			 p.nome = e.aluno.nome;
			 p.turma = (e.aluno.turma != null) ? e.aluno.turma.turma : "";
			 porAluno.put(e.aluno.id, p); 
		 }
		 p.livros++;
	 }
	// Ordena: quem leu mais fica em cima
	 List<PosicaoPodio> ranking = new ArrayList<PosicaoPodio>(porAluno.values());
	 Collections.sort(ranking);
	 
	// Define o lugar de cada um (empate = mesmo lugar) e o tamanho da barra
		int maximo = ranking.isEmpty() ? 1 : ranking.get(0).livros;
		for (int i = 0; i < ranking.size(); i++) {
			PosicaoPodio p = ranking.get(i);
			if (i == 0) {
				p.lugar = 1;
			} else if (ranking.get(i - 1).livros == p.livros) {
				p.lugar = ranking.get(i - 1).lugar;      // empatou: mesmo lugar do de cima
			} else {
				p.lugar = ranking.get(i - 1).lugar + 1;  // próximo lugar, sem pular números
			}
			p.percentual = p.livros * 100 / maximo;
		}
		
		render(ranking);
	}
	

}
