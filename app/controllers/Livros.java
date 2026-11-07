package controllers;

import models.Genero;
import models.Livro;
import models.Status;
import play.data.validation.Valid;
import play.mvc.*;
import security.Bibliotecario;
import security.Seguranca;

import java.util.*;

@With(Seguranca.class)
public class Livros extends Controller {
 

	@Bibliotecario
	// Mostra formulário
    public static void form() {
    	Livro l = new Livro();
    	List<Genero> generos = Genero.findAll();
        render(l, generos);
    }
    

	@Bibliotecario
    //Editar
    public static void editar(Long id) {
    	Livro l = Livro.findById(id);
    	List<Genero> generos = Genero.findAll();
    	renderTemplate("Livros/form.html", l, generos);
    }
    
    // Mostra lista
    public static void listar(String termo) {
        List<Livro> livros = null;
        if (termo == null) {
        	livros = Livro.find("status !=?1", Status.INATIVO).fetch();
        } else {
        	livros = Livro.find("lower(titulo) like ?1 or lower(autor) like ?1", "%"+termo.toLowerCase()+"%").fetch();
        }
        List<Genero> generos = Genero.findAll();
        Genero generoSel = null;  
        render(livros, termo, generos, generoSel);
    }
    
     //Seleção de Genero
    public static void GeneroS(Long id) {
    	Genero generoSel = Genero.findById(id);
    	List<Genero> generos = Genero.findAll();
    	List<Livro> livros = Livro.find("genero.id = ?1 and status !=?2", id, Status.INATIVO).fetch();
    	String termo = null;
    	renderTemplate("Livros/listar.html", livros, termo, generos, generoSel);
    	}

    // Mostra detalhar
    public static void detalhar(Long id) {
        Livro livro = Livro.findById(id);
        render(livro);
    }
  
    @Bibliotecario
    // Salva novo livro
    public static void salvar(@Valid Livro livro) {
        if (validation.hasErrors()) {
            Livro l = livro;
            List<Genero> generos = Genero.findAll();
            renderTemplate("Livros/form.html", l, generos);
        }

        livro.titulo = livro.titulo.toUpperCase();
        livro.autor = livro.autor.toLowerCase();
    	
    	if(livro.id == null) {
    		livro.emprestados = 0;
    	}
    	livro.disponivel = livro.emprestados < livro.quantidade;
    	livro.save();
    	flash.success("Livro cadastrado!");
    	listar(null); 
    }

	@Bibliotecario
    //Remover
    public static void remover(Long id) {
    	Livro r = Livro.findById(id);
    	r.status = Status.INATIVO;
    	r.save();
    	flash.success("Livro removido!");
    	listar(null);
    } 

	@Bibliotecario
    //Emprestar
    public static void emprestar(Long id) {
    	Livro l = Livro.findById(id);
    	if(l.emprestados >= l.quantidade) {
    		flash.error("No momento este título não está dispoível");
    		listar(null);
    	}
    	l.emprestados++;
    	l.disponivel =l.emprestados < l.quantidade;
    	l.save();
    	flash.success("Livro emprestado!");
    	listar(null);
    }

	@Bibliotecario
    //Devolver
    public static void devolver(Long id, int q) {
    	Livro l = Livro.findById(id);
    	if(q > l.emprestados) {
    		flash.error("Quantidade inválida! Só há " + l.emprestados + " exemplar(es) emprestado(s).");
    		listar(null);
    	}
    	l.emprestados -= q;
    	l.disponivel = l.emprestados < l.quantidade;
    	l.save();
    	flash.success("Livro devolvido!");
    	listar(null);
    }
	
	//Capa do livro
	public static void capa(Long id) {
		Livro l = Livro.findById(id);
		notFoundIfNull(1);
		if (l.capa == null || !l.capa.exists()) {
			notFound();
		}
		
		response.setContentTypeIfNotSet(l.capa.type());
		renderBinary(l.capa.get());
	}
}