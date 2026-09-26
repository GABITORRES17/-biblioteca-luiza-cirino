package Job;

import models.Cadastro;
import models.Genero;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception{
		if (Genero.count() == 0){	
			
			Genero ta1 = new Genero();
			ta1.genero = "Romance";
			ta1.save();
			
			Genero ta2 = new Genero();
			ta2.genero = "Fantasia";
			ta2.save();
			
			Genero ta3 = new Genero();
			ta3.genero = "Ficção Científica";
			ta3.save();
			
			Genero ta4 = new Genero();
			ta4.genero = "Suspense";
			ta4.save();
			
			Genero ta5 = new Genero();
			ta5.genero = "Terror";
			ta5.save();
			
		}
		
            if (Turma.count() == 0){	
			
			Turma t1 = new Turma();
			t1.turma = "1º Ano A";
			t1.save();
			
			Turma t2 = new Turma();
			t2.turma = "2º Ano A";
			t2.save();
			
			Turma t3 = new Turma();
			t3.turma = "3º Ano A";
			t3.save();
			
			Turma t4 = new Turma();
			t4.turma = "4º Ano A";
			t4.save();
			
			Turma t5 = new Turma();
			t5.turma = "5º Ano A";
			t5.save();
			
			Turma t6 = new Turma();
			t6.turma = "6º Ano A";
			t6.save();
			
			Turma t7 = new Turma();
			t7.turma = "7º Ano A";
			t7.save();
			
			Turma t8 = new Turma();
			t8.turma = "8º Ano A";
			t8.save();
			
			Turma t9 = new Turma();
			t9.turma = "9º Ano A";
			t9.save();
			
		}
            
            if (Cadastro.count() == 0) {
                Cadastro c = new Cadastro();
                c.nome = "gabi";
                c.senha = "1234";
                c.save();
            }
	}

}
