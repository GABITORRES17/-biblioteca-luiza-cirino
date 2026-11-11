package Job;

import models.Cadastro;
import models.Genero;
import models.Livro;
import models.Perfil;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import java.io.File;
import java.io.FileInputStream;
import play.Play;
import play.db.jpa.Blob;
import play.libs.MimeTypes;

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
			ta3.genero = "Cultura";
			ta3.save();

			Genero ta4 = new Genero();
			ta4.genero = "Clássico";
			ta4.save();

			Genero ta5 = new Genero();
			ta5.genero = "Quadrinhos";
			ta5.save();

			Genero ta6 = new Genero();
			ta6.genero = "Mangá";
			ta6.save();

			Genero ta7 = new Genero();
			ta7.genero = "Infantil";
			ta7.save();

			Genero ta8 = new Genero();
			ta8.genero = "Educação";
			ta8.save();

			Genero ta9 = new Genero();
			ta9.genero = "História";
			ta9.save();

			Genero ta10 = new Genero();
			ta10.genero = "Ciências";
			ta10.save();

			Genero ta11 = new Genero();
			ta11.genero = "Religioso";
			ta11.save();
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
                Cadastro gabi = new Cadastro();
                gabi.nome = "gabi";
                gabi.senha = "1234";
                gabi.save();

                Cadastro bibliotecaria = new Cadastro();
                bibliotecaria.nome = "BIBLIO";
                bibliotecaria.senha = "1234";
                bibliotecaria.perfil = Perfil.BIBLIOTECARIO;
                bibliotecaria.save();
            }
            

         // ===== ROMANCE =====
            criarLivro("Aída", "Giuseppe Verdi e Antonio Ghislanzoni", 1, "Romance", "Aida.jpg");
            criarLivro("Grandes amores da mitologia grega", "Dad Squarisi e Linda Goulart", 3, "Romance", "Grandes-amores-da-mitologia-grega.jpg");
            criarLivro("13 dos melhores contos de amor da literatura brasileira", "Rosa Amanda Strausz", 1, "Romance", "13-dos-melhores-contos-de-amor-da-literatura-brasileira.jpeg");
            criarLivro("A ladeira da saudade", "Ganymédes José", 1, "Romance", "A-ladeira-da-saudade.jpg");
            criarLivro("A descoberta do amor em versos", "Coletânea Literatura em minha casa", 1, "Romance", "A-descoberta-do-amor-em-versos.jpg");
            criarLivro("Eros e Psique", "Luís Dill", 1, "Romance", "Eros-e-Psique.jpg");
            criarLivro("O dia em que minha vida mudou por causa de um chocolate comprado nas Ilhas Maldivas", "Keka Reis", 1, "Romance", "O-dia-em-que-minha-vida-mudou.jpg");
            criarLivro("Apesar do amor", "Marli Walker", 1, "Romance", "Apesar-do-amor.jpg");
            criarLivro("#Cuidado garoto apaixonado", "Toni Brandão", 1, "Romance", "Cuidado-garoto-apaixonado.jpg");
            criarLivro("Fedegunda", "Karen Acioly", 1, "Romance", "Fedegunda.jpg");
            criarLivro("Anita Garibaldi a estrela da tempestade", "Heloisa Prieto", 1, "Romance", "Anita-Garibaldi-a-estrela-da-tempestade.jpg");
            criarLivro("Os amores de Perseu, Dânae e Andrômeda", "Carlos Alberto de Carvalho", 1, "Romance", "Os-amores-de-Perseu.jpg");
            criarLivro("Diário de um apaixonado: sintomas de um bem incurável", "Fabrício Carpinejar", 1, "Romance", "Diario-de-um-apaixonado.jpg");
            criarLivro("O príncipe atrasado: uma paródia teatral de contos de fadas", "Cássia Leslie e Ricardo Dalai", 1, "Romance", "O-principe-atrasado.jpg");
            criarLivro("Lucíola em graphic novel", "José de Alencar", 1, "Romance", "Luciola-em-graphic-novel.jpg");
            criarLivro("A culpa é das estrelas", "John Green", 1, "Romance", "A-culpa-e-das-estrelas.jpg");
            criarLivro("É assim que começa", "Colleen Hoover", 1, "Romance", "E-assim-que-comeca.jpg");
            criarLivro("A hipótese de Eros", "Emmanuelle Arsan", 1, "Romance", "A-hipotese-de-Eros.jpg");
            criarLivro("A felicidade conjugal", "Dr. Haroldo Shryock", 1, "Romance", "A-felicidade-conjugal.jpg");

            // ===== FANTASIA / MITOLOGIA =====
            criarLivro("O calcanhar do Aquiles e outras histórias curiosas da Grécia Antiga", "Duda Teixeira", 1, "Fantasia", "O-calcanhar-do-Aquiles.jpg");
            criarLivro("Helena de Troia: o destino de um povo", "Carlos Alberto de Carvalho", 1, "Fantasia", "Helena-de-Troia.jpg");
            criarLivro("As mulheres da casa de Troia", "Lia Neiva", 2, "Fantasia", "As-mulheres-da-casa-de-Troia.jpg");
            criarLivro("Doze reis e a moça no labirinto do vento", "Marina Colasanti", 5, "Fantasia", "Doze-reis-e-a-moca-no-labirinto-do-vento.jpg");
            criarLivro("O garoto verde", "Toni Brandão", 2, "Fantasia", "O-garoto-verde.jpg");
            criarLivro("A Grécia: mitos e lendas", "Alain Quesnel / Jean Torton", 2, "Fantasia", "A-Grecia-mitos-e-lendas.jpg");
            criarLivro("Entre deuses e monstros", "Lia Neiva", 75, "Fantasia", "Entre-deuses-e-monstros.jpg");
            
            // ===== CULTURA=====
            criarLivro("Contos e lendas do Peru", "Antonieta Dias de Moraes", 1, "Cultura", "Contos-e-lendas-do-Peru.jpg");
            criarLivro("Contos árabes para jovens de todos os lugares", "Maria Luísa Soriano Martins", 1, "Cultura", "Contos-arabes-para-jovens.jpg");
            criarLivro("Você é livre", "Dominique Torres", 1, "Cultura", "Voce-e-livre.jpg");
            criarLivro("Os nove pentes da África", "Cidinha da Silva", 1, "Cultura", "Os-nove-pentes-da-Africa.jpg");
            criarLivro("O papagaio que não gostava de mentiras e outras fábulas africanas", "Adilson Martins", 1, "Cultura", "O-papagaio-que-nao-gostava-de-mentiras.jpg");
            criarLivro("História e cultura afro-brasileira", "Regiane Augusto de Mattos", 1, "Cultura", "Historia-e-cultura-afro-brasileira.jpg");
            criarLivro("O tesouro do quilombo", "Angelo Machado", 1, "Cultura", "O-tesouro-do-quilombo.jpg");
            criarLivro("Tumbu", "Marconi Leal", 1, "Cultura", "Tumbu.jpg");
            criarLivro("Nina África: contos de uma África menina para ninar gente de todas as idades", "Lenice Gomes, Arlene Holanda e Clayson Gomes", 1, "Cultura", "Nina-Africa.jpg");
            criarLivro("As fabulosas fábulas de Iauaretê", "Kaká Wera Jecupé", 1, "Cultura", "As-fabulosas-fabulas-de-Iauarete.jpg");
            criarLivro("Joãozinho e Maria", "Cristina Agostinho e Ronaldo Simões Coelho", 1, "Cultura", "Joãozinho-e-Maria.jpg");
            criarLivro("Mzungu", "Meja Mwangi", 1, "Cultura", "Mzungu.jpg");
            criarLivro("Jongo", "Sonia Rosa", 1, "Cultura", "Jongo.jpg");
            criarLivro("Agbalá: um lugar-continente", "Marilda Castanha", 1, "Cultura", "Agbala-um-lugar-continente.jpg");
            criarLivro("As narrativas preferidas de um contador de histórias", "Ilan Brenman", 1, "Cultura", "As-narrativas-preferidas-de-um-contador-de-historias.jpg");
            criarLivro("Lendas da África moderna", "Heloisa Pires Lima e Rosa Maria Tavares Andrade", 1, "Cultura", "Lendas-da-Africa-moderna.jpg");
            criarLivro("Contos ao redor da fogueira", "Rogério Andrade Barbosa", 1, "Cultura", "Contos-ao-redor-da-fogueira.jpg");
            criarLivro("Pigmeus: os defensores da floresta", "Rogério Andrade Barbosa", 1, "Cultura", "Pigmeus-os-defensores-da-floresta.jpg");
            criarLivro("Olhar e ver o mundo do trabalho: olhar a África e ver o Brasil", "Pierre Verger", 1, "Cultura", "Olhar-e-ver-o-mundo-do-trabalho.jpg");
            criarLivro("Olhar e ver a vida em sociedade: olhar a África e ver o Brasil", "Pierre Verger", 1, "Cultura", "Olhar-e-ver-a-vida-em-sociedade.jpg");
            criarLivro("A história de Íqbal", "Francesco D'Adamo", 1, "Cultura", "A-historia-de-Iqbal.jpg");
            criarLivro("Histórias dos Sugpiaq, um povo do Alasca", "Claire Merleau-Ponty / Caroline Nardi Gilletta", 1, "Cultura", "Historias-dos-Sugpiaq.jpg");
            criarLivro("Contos africanos", "Ernesto Rodríguez Abad", 1, "Cultura", "Contos-africanos.jpg");
            criarLivro("A flor de Lirolay e outros contos da América Latina", "Celina Bodenmüller / Fabiana Prando", 1, "Cultura", "A-flor-de-Lirolay.jpg");
            criarLivro("O livro da selva: as histórias de Mowgli", "Rudyard Kipling", 1, "Cultura", "O-livro-da-selva.jpg");
            criarLivro("África e Brasil africano", "Marina de Mello e Souza", 1, "Cultura", "Africa-e-Brasil-africano.jpg");
            criarLivro("Culturas africanas e afro-brasileiras em sala de aula", "Renata Felinto", 1, "Cultura", "Culturas-africanas-e-afro-brasileiras-em-sala-de-aula.jpg");
            criarLivro("Histórias Africanas", "Ana Maria Machado", 1, "Cultura", "Historias-Africanas.jpg");
            criarLivro("Histórias encantadas africanas", "Ingrid Biesemeyer", 1, "Cultura", "Historias-encantadas-africanas.jpg");
            criarLivro("Histórias de ouvir da África fabulosa", "Carlos Alberto de Carvalho", 1, "Cultura", "Historias-de-ouvir-da-Africa-fabulosa.jpg");
            criarLivro("Canção dos povos africanos", "Fernando Paixão", 1, "Cultura", "Cancao-dos-povos-africanos.jpg");
            criarLivro("Bruna e a galinha d'Angola", "Gercilga de Almeida", 1, "Cultura", "Bruna-e-a-galinha-dAngola.jpg");
            criarLivro("O fio d'água do Quilombo", "Heloisa Pires Lima", 1, "Cultura", "O-fio-dagua-do-Quilombo.jpg");
            criarLivro("Quilombolas", "Matheus Henrique de Faria Pereira, Gisella de Amorim Serrano e Amélia Pereira Batista Porto", 1, "Cultura", "Quilombolas.jpg");
            criarLivro("Aqualtune e as histórias da África", "Ana Cristina Massa", 1, "Cultura", "Aqualtune-e-as-historias-da-Africa.jpg");
            criarLivro("O nome do filme é Amazônia", "Paulinho Assunção", 1, "Cultura", "O-nome-do-filme-e-Amazonia.jpg");
            criarLivro("Da floresta amazônica para quem ainda não aprendeu a soletrar as sílabas do amor à floresta", "Thiago de Mello e Pollyanna Furtado", 1, "Cultura", "Da-floresta-amazonica.jpg");
            criarLivro("A Amazônia: mitos e lendas", "Danièle Küss / Jean Torton", 2, "Cultura", "A-Amazonia-mitos-e-lendas.jpg");
            criarLivro("Histórias da nossa gente", "Sandra Lane", 1, "Cultura", "Historias-da-nossa-gente.jpg");
            criarLivro("Rio Liberdade: uma aventura no Pantanal", "Werner Zotz", 1, "Cultura", "Rio-Liberdade.jpg");
            criarLivro("Confissões de uma vira-lata", "Orígenes Lessa", 1, "Cultura", "Confissoes-de-uma-vira-lata.jpg");
            criarLivro("É difícil de entender, vô!", "Nelson Albissú", 1, "Cultura", "E-dificil-de-entender-vo.jpg");
            criarLivro("O curumim pintor e outras histórias", "Sânzio de Azevedo", 2, "Cultura", "O-curumim-pintor.jpg");
            criarLivro("3 X Amazônia", "Tiago de Melo Andrade", 1, "Cultura", "3-X-Amazonia.jpg");
            criarLivro("O caçador de histórias: Sehay Ka'at Haría", "Yaguarê Yamã", 1, "Cultura", "O-cacador-de-historias.jpg");
            criarLivro("Voltando pra casa", "Suana Dias Beck", 1, "Cultura", "Voltando-pra-casa.jpg");
            criarLivro("Murugawa: Mitos, contos e fábulas do povo Maraguá", "Yaguarê Yamã", 1, "Cultura", "Murugawa.jpg");
            criarLivro("Diz a Lenda...", "Sandra Aymone", 1, "Cultura", "Diz-a-Lenda.jpg");
            criarLivro("A Lenda da Paxiúba", "Terezinha Eboli", 1, "Cultura", "A-Lenda-da-Paxiuba.jpg");
            criarLivro("Ururau, Praga e Pica-pau", "Celso Sísto", 1, "Cultura", "Ururau-Praga-e-Pica-pau.jpg");
            criarLivro("Teiniaguá: a Princesa Moura Encantada", "Caio Riter", 1, "Cultura", "Teiniagua.jpg");
            criarLivro("Irakisu: o menino criador", "Renê Kithãulu", 1, "Cultura", "Irakisu-o-menino-criador.jpg");
            criarLivro("Estórias de Jabuti", "Marion Villas Boas", 1, "Cultura", "Estorias-de-Jabuti.jpg");
            criarLivro("Uma Aldeia Cheia de Monstros", "Francisco Hinojosa", 1, "Cultura", "Uma-Aldeia-Cheia-de-Monstros.jpg");
            criarLivro("A mulher que virou Urutau", "Olívio Jekupe e Maria Kerexu", 1, "Cultura", "A-mulher-que-virou-Urutau.jpg");
            criarLivro("Cobra Grande: histórias da Amazônia", "Sean Taylor", 1, "Cultura", "Cobra-Grande.jpg");
            criarLivro("A Menina que fez a América", "Ilka Brunhilde Laurito", 1, "Cultura", "A-Menina-que-fez-a-America.jpg");
            criarLivro("Boi da Cara Preta", "Sérgio Caparelli", 1, "Cultura", "Boi-da-Cara-Preta.jpg");

            // ====== MANGA =======
            criarLivro("Domo Mangá", "Tsuneo Goda", 1, "Mangá", "Domo-Manga.jpg");
            criarLivro("Delicious in Dungeon", "Ryoko Kui", 1, "Mangá", "Delicious-in-Dungeon.jpg");
            criarLivro("Yuyu Hakusho", "Yoshihiro Togashi", 1, "Mangá", "Yuyu-Hakusho.jpg");
            criarLivro("Star Wars Rebeldes", "Mitsuru Aoki", 1, "Mangá", "Star-Wars-Rebeldes.jpg");
            criarLivro("Santuário dos dinossauros 1", "Itaru Kinoshita", 1, "Mangá", "Santuário-dos-dinossauros-1.jpg");
            criarLivro("Hunter x Hunter", "Yoshihiro Togashi", 1, "Mangá", "Hunter-x-Hunter.jpg");
            criarLivro("Como conheci a minha alma gêmea", "Anashin", 1, "Mangá", "Como-conheci-a-minha-alma-gemea.jpg");
            criarLivro("Naruto", "Masashi Kishimoto", 1, "Mangá", "Naruto.jpg");
            criarLivro("Sakura", "Clamp", 1, "Mangá", "Sakura-Clamp.jpg");
            
            // =======QUADRINHOS =========
            criarLivro("Lucíola em graphic novel", "José de Alencar", 1, "Quadrinhos", "Luciola-em-graphic-novel.jpg");
            criarLivro("Dragon Age", "Nunzio DeFillipis", 1, "Quadrinhos", "Dragon-Age.jpg");
            criarLivro("Mutts: os Vira-latas", "Patrick McDonnell", 1, "Quadrinhos", "Mutts-os-Vira-latas.jpg");
            criarLivro("10 pãezinhos: meu coração, não sei por quê", "Fábio Moon e Gabriel Bá", 1, "Quadrinhos", "10-paezinhos.jpg");
            criarLivro("Jane, a raposa e eu", "Isabelle Arsenault e Fanny Britt", 2, "Quadrinhos", "Jane-a-raposa-e-eu.jpg");
            criarLivro("Contos de Fadas em Quadrinhos", "Chris Duffy", 70, "Quadrinhos", "Contos-de-Fadas-em-Quadrinhos.jpg");
            criarLivro("Dom Quixote em quadrinhos", "Caco Galhardo", 1, "Quadrinhos", "Dom-Quixote-em-quadrinhos.jpg");
            criarLivro("Epitássio Pessoa, em quadrinhos", "Neide Medeiros", 1, "Quadrinhos", "Epitassio-Pessoa-em-quadrinhos.jpg");
            criarLivro("Não era você que eu esperava", "Fabien Toulmé", 2, "Quadrinhos", "Nao-era-voce-que-eu-esperava.jpg");
            criarLivro("Turma da Mônica, vamos proteger...", "Ciranda cultural", 1, "Quadrinhos", "Turma-da-Monica-vamos-proteger.jpg");
            criarLivro("Turma da Mônica, diversão na praia", "Ciranda cultural", 1, "Quadrinhos", "Turma-da-Monica-diversao-na-praia.jpg");
            criarLivro("Gibi, aventureiros em ação", "Ana Cristina", 1, "Quadrinhos", "Gibi-aventureiros-em-acao.jpg");
            
            // ===== Religioso =====
            criarLivro("Bíblia sagrada", "Edição contemporânea de Almeida", 1, "Religioso", "Biblia-sagrada.jpg");
            criarLivro("A ressurreição de Jesus", "Ciranda Cultural", 1, "Religioso", "A-ressurreicao-de-Jesus-2.jpg");
            criarLivro("Rute", "Ciranda Cultural", 1, "Religioso", "Rute.jpg");
            criarLivro("Davi e Golias", "Ciranda Cultural", 2, "Religioso", "Davi-e-Golias-Ciranda-Cultural.jpg");
            criarLivro("O filho perdido", "Ciranda Cultural", 1, "Religioso", "O-filho-perdido.jpg");
            criarLivro("Adão e Eva", "Ciranda Cultural", 1, "Religioso", "Adao-e-Eva.jpg");
            criarLivro("José", "Ciranda Cultural", 1, "Religioso", "Jose-Ciranda-Cultural.jpg");
            criarLivro("Abraão", "Ciranda Cultural", 1, "Religioso", "Abraao.jpg");
            criarLivro("O nascimento de Jesus", "Ciranda Cultural", 2, "Religioso", "O-nascimento-de-Jesus.jpg");
            criarLivro("Sansão e Dalila", "Ciranda Cultural", 1, "Religioso", "Sansao-e-Dalila.jpg");
            criarLivro("Jesus acalma a tempestade", "Ciranda Cultural", 1, "Religioso", "Jesus-acalma-a-tempestade.jpg");
            criarLivro("A arca de Noé", "Ciranda Cultural", 1, "Religioso", "A-arca-de-Noe-Ciranda-Cultural.jpg");
            criarLivro("A criação", "Ciranda Cultural", 1, "Religioso", "A-criacao-Ciranda-Cultural.jpg");
            criarLivro("A pesca maravilhosa", "Ciranda Cultural", 1, "Religioso", "A-pesca-maravilhosa.jpg");
            criarLivro("A multiplicação", "Ciranda Cultural", 1, "Religioso", "A-multiplicacao-Ciranda-Cultural.jpg");
            criarLivro("Os amigos de Jesus", "Ciranda Cultural", 1, "Religioso", "Os-amigos-de-Jesus.jpg");
            criarLivro("José e Moisés", "Clássicos da Bíblia", 1, "Religioso", "Jose-e-Moises.jpg");
            criarLivro("A multiplicação", "Clássicos da Bíblia", 1, "Religioso", "A-multiplicacao-Classicos-da-Biblia.jpg");
            criarLivro("Davi e Golias", "Clássicos da Bíblia", 1, "Religioso", "Davi-e-Golias-Classicos-da-Biblia.jpg");
            criarLivro("A criação", "Clássicos da Bíblia", 1, "Religioso", "A-criacao-Classicos-da-Biblia.jpg");

            // ===== CLÁSSICOS =====
            criarLivro("Dom Quixote", "Miguel de Cervantes", 2, "Clássico", "Dom-Quixote.jpg");
            criarLivro("Mutts: os Vira-latas", "Patrick McDonnell", 1, "Clássico", "Mutts-os-Vira-latas.jpg");
            criarLivro("Desista! E outras histórias de Franz Kafka", "Franz Kafka", 1, "Clássico", "Desista-e-outras-historias.jpg");
            criarLivro("Oliver Twist", "Charles Dickens", 1, "Clássico", "Oliver-Twist.jpg");
            criarLivro("10 pãezinhos: meu coração, não sei por quê", "Fábio Moon e Gabriel Bá", 1, "Clássico", "10-paezinhos.jpg");
            criarLivro("Jane, a raposa e eu", "Isabelle Arsenault e Fanny Britt", 2, "Clássico", "Jane-a-raposa-e-eu.jpg");
            criarLivro("Contos, Machado de Assis", "Tiago Sottilli", 1, "Clássico", "Contos-Machado-de-Assis.jpg");
            criarLivro("Tudo bem quando termina bem", "William Shakespeare", 1, "Clássico", "Tudo-bem-quando-termina-bem.jpg");
            criarLivro("Romeu e Julieta", "William Shakespeare", 1, "Clássico", "Romeu-e-Julieta-Shakespeare.jpg");
            criarLivro("Sonho de uma noite de verão", "William Shakespeare", 1, "Clássico", "Sonho-de-uma-noite-de-verao.jpg");
            criarLivro("A tempestade", "William Shakespeare", 1, "Clássico", "A-tempestade.jpg");
            criarLivro("Muito barulho por nada", "William Shakespeare", 1, "Clássico", "Muito-barulho-por-nada.jpg");
            criarLivro("Antônio e Cleópatra", "William Shakespeare", 1, "Clássico", "Antonio-e-Cleopatra.jpg");
            criarLivro("Trabalhos de Amor perdido", "William Shakespeare", 1, "Clássico", "Trabalhos-de-Amor-perdido.jpg");
            criarLivro("Hamlet", "William Shakespeare", 1, "Clássico", "Hamlet.jpg");
            criarLivro("Macbeth", "William Shakespeare", 1, "Clássico", "Macbeth.jpg");
            criarLivro("A comédia dos erros", "William Shakespeare", 1, "Clássico", "A-comedia-dos-erros.jpg");
            criarLivro("Do jeito que você gosta", "William Shakespeare", 1, "Clássico", "Do-jeito-que-voce-gosta.jpg");
            criarLivro("O conto de inverno", "William Shakespeare", 1, "Clássico", "O-conto-de-inverno.jpg");
            criarLivro("Otelo", "William Shakespeare", 1, "Clássico", "Otelo.jpg");
            criarLivro("Rei Lear", "William Shakespeare", 1, "Clássico", "Rei-Lear.jpg");
            criarLivro("O mercador de Veneza", "William Shakespeare", 1, "Clássico", "O-mercador-de-Veneza.jpg");
            criarLivro("Noite de Reis", "William Shakespeare", 1, "Clássico", "Noite-de-Reis.jpg");
            criarLivro("Anne de Green Gables 1", "Lucy Maud", 1, "Clássico", "Anne-de-Green-Gables-1.jpg");
            criarLivro("Anne de Green Gables 2", "Lucy Maud", 1, "Clássico", "Anne-de-Green-Gables-2.jpg");
            criarLivro("Anne de Green Gables 3", "Lucy Maud", 1, "Clássico", "Anne-de-Green-Gables-3.jpg");
            criarLivro("O signo dos quatro - Sherlock Holmes", "Conan Doyle", 1, "Clássico", "O-signo-dos-quatro-Sherlock-Holmes.jpg");
            criarLivro("Um escândalo na boêmia", "Conan Doyle", 1, "Clássico", "Um-escandalo-na-boemia.jpg");
            criarLivro("O cão dos Baskervilles", "Conan Doyle", 1, "Clássico", "O-cao-dos-Baskervilles.jpg");
            criarLivro("Um tesouro em vermelho", "Conan Doyle", 1, "Clássico", "Um-tesouro-em-vermelho.jpg");
            criarLivro("O roubo da coroa de Berilos", "Conan Doyle", 1, "Clássico", "O-roubo-da-coroa-de-Berilos.jpg");
            criarLivro("A Liga dos cabeças vermelhas", "Conan Doyle", 1, "Clássico", "A-Liga-dos-cabecas-vermelhas.jpg");
            criarLivro("O corcunda de Notre-Dame", "Victor Hugo", 1, "Clássico", "O-corcunda-de-Notre-Dame.jpg");
            criarLivro("Os miseráveis", "Victor Hugo", 4, "Clássico", "Os-miseraveis.jpg");
            criarLivro("A volta ao mundo em oitenta dias", "Júlio Verne", 1, "Clássico", "A-volta-ao-mundo-em-oitenta-dias.jpg");
            criarLivro("Viagem ao centro da terra", "Júlio Verne", 1, "Clássico", "Viagem-ao-centro-da-terra.jpg");
            criarLivro("Frritt-Flacc", "Júlio Verne", 1, "Clássico", "Frritt-Flacc.jpg");
            criarLivro("As aventuras extraordinárias de Júlio Verne", "Júlio Verne", 1, "Clássico", "As-aventuras-extraordinarias-de-Julio-Verne.jpg");
            criarLivro("Moby Dick", "Herman Melville", 1, "Clássico", "Moby-Dick.jpg");
            criarLivro("Os três mosqueteiros", "Alexandre Dumas", 2, "Clássico", "Os-tres-mosqueteiros.jpg");
            criarLivro("O máscara de ferro", "Alexandre Dumas", 1, "Clássico", "O-mascara-de-ferro.jpg");
            criarLivro("A ilha do tesouro", "Robert Louis Stevenson", 2, "Clássico", "A-ilha-do-tesouro.jpg");
            criarLivro("Raptado", "Robert Louis Stevenson", 1, "Clássico", "Raptado.jpg");
            criarLivro("Tom Sawyer detetive", "Mark Twain", 1, "Clássico", "Tom-Sawyer-detetive.jpg");
            criarLivro("As aventuras de Tom Sawyer", "Mark Twain", 1, "Clássico", "As-aventuras-de-Tom-Sawyer.jpg");
            criarLivro("O esbulho do príncipe margarina", "Mark Twain", 2, "Clássico", "O-esbulho-do-principe-margarina.jpg");
            criarLivro("O pequeno príncipe", "Antoine de Saint-Exupéry", 1, "Clássico", "O-pequeno-principe.jpg");
            criarLivro("Heidi", "Johanna Spyri", 1, "Clássico", "Heidi.jpg");
            criarLivro("O príncipe feliz e outros contos", "Oscar Wilde", 1, "Clássico", "O-principe-feliz-e-outros-contos.jpg");
            criarLivro("Fausto", "Goethe", 2, "Clássico", "Fausto.jpg");
            criarLivro("A megera domada", "William Shakespeare", 2, "Clássico", "A-megera-domada.jpg");
            criarLivro("Odisseia", "Ruth Rocha", 1, "Clássico", "Odisseia.jpg");
            criarLivro("Mil e uma noites", "Carlos Heitor Cony", 1, "Clássico", "Mil-e-uma-noites.jpg");
            criarLivro("Aladim e a lâmpada maravilhosa", "Carlos Heitor Cony", 1, "Clássico", "Aladim-e-a-lampada-maravilhosa.jpg");
            criarLivro("As aventuras de Pinóquio", "Carlos Collodi", 1, "Clássico", "As-aventuras-de-Pinoquio.jpg");
            criarLivro("Pinóquio", "Carlo Collodi", 2, "Clássico", "Pinoquio.jpg");
            criarLivro("Peter Pan", "Monteiro Lobato", 1, "Clássico", "Peter-Pan-Monteiro-Lobato.jpg");
            criarLivro("O príncipe e outras fábulas modernas", "Rabindranath Tagore", 1, "Clássico", "O-principe-e-outras-fabulas-modernas.jpg");
            criarLivro("O velho e o mar", "Ernest Hemingway", 2, "Clássico", "O-velho-e-o-mar.jpg");
            criarLivro("A metamorfose do Lívio", "Taline Schubach", 1, "Clássico", "A-metamorfose-do-Livio.jpg");
            criarLivro("Contos de Shakespeare", "Paulo Mendes Campos", 1, "Clássico", "Contos-de-Shakespeare.jpg");
            criarLivro("William Shakespeare e seus atos dramáticos", "Andrew Donkin", 1, "Clássico", "William-Shakespeare-e-seus-atos-dramaticos.jpg");
            criarLivro("Os cavaleiros da Távola Redonda", "Thomas Malory", 1, "Clássico", "Os-cavaleiros-da-Tavola-Redonda.jpg");
            criarLivro("Robin Hood", "Mauri Kunnas", 1, "Clássico", "Robin-Hood-Mauri-Kunnas.jpg");
            criarLivro("O corcel negro", "Walter Farley", 1, "Clássico", "O-corcel-negro.jpg");
            criarLivro("As melhores histórias de Andersen", "Laura Sandroni", 1, "Clássico", "As-melhores-historias-de-Anderson.jpg");
            criarLivro("O príncipe pastor", "Hans Christian Andersen", 1, "Clássico", "O-principe-pastor.jpg");
            criarLivro("Os pequenos verdes e outras histórias", "Hans Christian Andersen", 1, "Clássico", "Os-pequenos-verdes-e-outras-historias.jpg");
            criarLivro("A pequena sereia", "Hans Christian Andersen", 1, "Clássico", "A-pequena-sereia.jpg");
            criarLivro("O soldadinho de chumbo", "Cordélia Dias", 1, "Clássico", "O-soldadinho-de-chumbo.jpg");
            criarLivro("A Bela e a Fera", "Rui de Oliveira", 1, "Clássico", "A-Bela-e-a-Fera.jpg");
            criarLivro("O lago dos cisnes", "Pyotr Ilyich", 1, "Clássico", "O-lago-dos-cisnes.jpg");
            criarLivro("As doze princesas dançarinas", "Irmãos Grimm", 1, "Clássico", "As-doze-princesas-dancarinas.jpg");
            criarLivro("João e Maria", "Jacob e Wilhelm Grimm", 1, "Clássico", "Joao-e-Maria-Grimm.jpg");
            criarLivro("Cachinhos dourados e os três ursos", "Richard Northcott", 1, "Clássico", "Cachinhos-dourados-e-os-tres-ursos.jpg");
            criarLivro("Os três porquinhos", "Patrick Jackson", 1, "Clássico", "Os-tres-porquinhos-Patrick-Jackson.jpg");
            criarLivro("Os três porquinhos", "Mariana Massarani", 1, "Clássico", "Os-tres-porquinhos-Mariana-Massarani.jpg");
            criarLivro("Chapeuzinho Vermelho", "Camila Werner", 2, "Clássico", "A-Chapeuzinho-vermelho.jpg");
            criarLivro("Chapeuzinhos coloridos", "José Roberto Torero", 1, "Clássico", "Chapeuzinhos-coloridos.jpg");
            criarLivro("Chapeuzinho Vermelho, uma aventura borbulhante", "Lynn Roberts", 1, "Clássico", "Chapeuzinho-Vermelho-uma-aventura-borbulhante.jpg");
            criarLivro("Chapeuzinho Vermelho e o Lobo Mau", "Rosângela Lima", 8, "Clássico", "Chapeuzinho-Vermelho-e-o-Lobo-Mau.jpg");
            criarLivro("A Bela e a Fera", "Rui de Oliveira", 1, "Clássico", "A-Bela-e-a-Fera-2.jpg");
            criarLivro("A pequena sereia", "Hans Christian Anderson", 1, "Clássico", "A-pequena-sereia-2.jpg");
            criarLivro("O príncipe pastor", "Hans Christian Anderson", 1, "Clássico", "O-principe-pastor-2.jpg");
            criarLivro("Os pequenos verdes e outras histórias", "Hans Christian Andersen", 1, "Clássico", "Os-pequenos-verdes-e-outras-historias-2.jpg");
            criarLivro("Contos de Fadas em Quadrinhos", "Chris Duffy", 70, "Clássico", "Contos-de-Fadas-em-Quadrinhos.jpg");
            criarLivro("Meus contos de Fadas Preferidos", "Eni Rodrigues", 1, "Clássico", "Meus-contos-de-Fadas-Preferidos.jpg");
            criarLivro("Contos de Andersen", "Mary França", 1, "Clássico", "Contos-de-Andersen.jpg");
            criarLivro("Contos de Anderson", "Mary França", 1, "Clássico", "Contos-de-Anderson.jpg");
            criarLivro("O pato, a morte e a tulipa", "José Marques Macedo", 1, "Clássico", "O-pato-a-morte-e-a-tulipa.jpg");
            criarLivro("A raposa e o galo", "Eduardo Stark", 1, "Clássico", "A-raposa-e-o-galo.jpg");
            criarLivro("Fábulas de La Fontaine", "La Fontaine", 1, "Clássico", "Fabulas-de-La-Fontaine.jpg");
            criarLivro("Fábulas de La Fontaine", "René Ferri", 7, "Clássico", "Fabulas-de-La-Fontaine-Rene-Ferri.jpg");
            criarLivro("Fábulas de Esopo", "Ruth Rocha", 1, "Clássico", "Fabulas-de-Esopo.jpg");
            criarLivro("Fábulas de Esopo", "Jorge Sallum", 2, "Clássico", "Fabulas-de-Esopo-Jorge-Sallum.jpg");
            criarLivro("Três fábulas de Esopo", "Paulo Garfunkel", 1, "Clássico", "Tres-fabulas-de-Esopo.jpg");
            criarLivro("Fábulas, a lebre e a tartaruga", "Eduardo Starke", 1, "Clássico", "Fabulas-a-lebre-e-a-tartaruga.jpg");
            criarLivro("O lobo não morde!", "Emily Gravett", 1, "Clássico", "O-lobo-nao-morde.jpg");
            
            //====== Infantil =====
            
            criarLivro("Coleção boas maneiras", "Brasileitura", 1, "Infantil", "Colecao-boas-maneiras.jpg");
            criarLivro("A família bode", "Patrick Jackson", 1, "Infantil", "A-familia-bode.jpg");
            criarLivro("Quem é o curupira", "Brasileitura", 1, "Infantil", "Quem-e-o-curupira.jpg");
            criarLivro("O homem biscoito", "Lauri Cericato", 1, "Infantil", "O-homem-biscoito.jpg");
            criarLivro("A floresta encantada: a excursão da vovó", "Sistema Maxi de Ensino", 2, "Infantil", "A-floresta-encantada-a-excursao-da-vovo.jpg");
            criarLivro("Histórias com valores", "Diego Quiroga / Javier Castro", 1, "Infantil", "Historias-com-valores.jpg");
            criarLivro("Piadinhas", "Brasileitura", 2, "Infantil", "Piadinhas.jpg");
            criarLivro("O jogo da Parlenda", "Heloiza Prieto", 1, "Infantil", "O-jogo-da-Parlenda.jpg");
            criarLivro("O que aconteceu?", "Adalci Melo", 1, "Infantil", "O-que-aconteceu.jpg");
            criarLivro("Filhote amigos", "Brasileitura", 1, "Infantil", "Filhote-amigos.jpg");
            criarLivro("Barbie Butterfly e a princesa Fairy", "Ciranda cultural", 1, "Infantil", "Barbie-Butterfly-e-a-princesa-Fairy.jpg");
            criarLivro("É ISSO ALI", "José Paulo Paes", 1, "Infantil", "E-ISSO-ALI.jpg");
            criarLivro("Entre uma história e outra: dos encontros, dois amigos", "Adriana Rosa / J. Batista", 1, "Infantil", "Entre-uma-historia-e-outra-dos-encontros-dois-amigos.jpg");
            criarLivro("Aventuras na Amazônia", "Editora avenida", 1, "Infantil", "Aventuras-na-Amazonia.jpg");
            criarLivro("Contagem regressiva", "Kay Woodward", 1, "Infantil", "Contagem-regressiva.jpg");
            criarLivro("O nabo gigante", "Camila Werner", 1, "Infantil", "O-nabo-gigante.jpg");
            criarLivro("A câmera de Catarina", "Richard Northcott", 1, "Infantil", "A-camera-de-Catarina-2.jpg");
            criarLivro("A galinha Gabriela", "Helena Pacca", 1, "Infantil", "A-galinha-Gabriela.jpg");
            criarLivro("Gatos e peixes", "Patrick Jackson", 1, "Infantil", "Gatos-e-peixes-2.jpg");
            criarLivro("O menino pêssego", "Fábio Bonillo", 1, "Infantil", "O-menino-pessego.jpg");
            criarLivro("O homem biscoito", "Helena Pacca", 1, "Infantil", "O-homem-biscoito-2.jpg");
            criarLivro("A pecinha que fazia", "Heldene Santos", 1, "Infantil", "A-pecinha-que-fazia.jpg");
            criarLivro("Vamos falar de forró", "Neilson Gomes", 3, "Infantil", "Vamos-falar-de-forro.jpg");
            criarLivro("A predileta do poeta", "Glauco Mattoso", 1, "Infantil", "A-predileta-do-poeta.jpg");
            criarLivro("Nossa rua tem um problema", "Ricardo Azevedo", 1, "Infantil", "Nossa-rua-tem-um-problema.jpg");
            criarLivro("Super carros, Jango, mania de grandeza", "Luciano Corrêa", 1, "Infantil", "Super-carros-Jango-mania-de-grandeza.jpg");
            criarLivro("Sofia e o dente de leite", "Henrique Rodrigues", 1, "Infantil", "Sofia-e-o-dente-de-leite.jpg");
            criarLivro("Trocas e Truques", "Aline Pinto", 1, "Infantil", "Trocas-e-Truques.jpg");
            criarLivro("Vento ventania", "Aline Pinto", 1, "Infantil", "Vento-ventania.jpg");
            criarLivro("Turma da Mônica, vamos proteger...", "Ciranda cultural", 1, "Infantil", "Turma-da-Monica-vamos-proteger.jpg");
            criarLivro("Turma da Mônica, diversão na praia", "Ciranda cultural", 1, "Infantil", "Turma-da-Monica-diversao-na-praia.jpg");
            criarLivro("Fábulas, a lebre e a tartaruga", "Eduardo Starke", 1, "Infantil", "Fabulas-a-lebre-e-a-tartaruga-2.jpg");
            criarLivro("Diário de um bárbaro covarde", "Two Little Cowboy", 1, "Infantil", "Diario-de-um-barbaro-covarde.jpg");
            criarLivro("O diário de Dan-se dane-se", "Dan Kivchnev", 1, "Infantil", "O-diario-de-Dan-se-dane-se.jpg");
            criarLivro("Sakura", "Edição brasileira", 1, "Infantil", "Sakura-Edicao-brasileira.jpg");
            criarLivro("Há poder em suas palavras", "Dom Gosset", 1, "Infantil", "Ha-poder-em-suas-palavras.jpg");
            criarLivro("Quem cochicha o rabo espicha", "José de Castro", 1, "Infantil", "Quem-cochicha-o-rabo-espicha.jpg");
            criarLivro("De quando tudo era azul", "Pedro Simões", 1, "Infantil", "De-quando-tudo-era-azul.jpg");
            criarLivro("Cecília, dente de leão", "Leandro Guttemberg", 8, "Infantil", "Cecilia-dente-de-leao.jpg");
            criarLivro("Kiko e Abelardo", "Elisa Maria Rands", 10, "Infantil", "Kiko-e-Abelardo.jpg");
            criarLivro("Meu amigo especial", "Ana Paula Brito", 10, "Infantil", "Meu-amigo-especial.jpg");
            criarLivro("Cheiro de mãe", "Nazaré Fonseca", 10, "Infantil", "Cheiro-de-mae.jpg");
            criarLivro("Aldo chupa chupeta", "Flávia C. Rocha Dutra", 8, "Infantil", "Aldo-chupa-chupeta.jpg");
            criarLivro("Bigode na gaiola", "Isabelle Meunier", 10, "Infantil", "Bigode-na-gaiola.jpg");
            criarLivro("As estrelas dos olhos de Maria", "Nazaré Fonseca", 8, "Infantil", "As-estrelas-dos-olhos-de-Maria.jpg");
            criarLivro("O aniversário de Iara", "Elita Ferreira", 10, "Infantil", "O-aniversario-de-Iara.jpg");
            criarLivro("Cigarras e formigas, amigas?", "Lúcia Costa Carvalho", 10, "Infantil", "Cigarras-e-formigas-amigas.jpg");
            criarLivro("Flora e o rio", "Sabelle Meunier", 8, "Infantil", "Flora-e-o-rio.jpg");
            criarLivro("Água qual será o seu destino?", "Elita Ferreira", 10, "Infantil", "Agua-qual-sera-o-seu-destino.jpg");
            criarLivro("Amando o inimigo 2ª edição", "José Teles", 8, "Infantil", "Amando-o-inimigo-2a-edicao.jpg");
            criarLivro("A revolta do Cascudo", "Maurício Melo Júnior", 8, "Infantil", "A-revolta-do-Cascudo.jpg");
            criarLivro("Caminho só de ida, volta à seca", "Maurício Melo Júnior", 8, "Infantil", "Caminho-so-de-ida-volta-a-seca.jpg");
            criarLivro("Era uma vez um quintal", "Paulo Caldas", 8, "Infantil", "Era-uma-vez-um-quintal.jpg");
            criarLivro("Um menino do engenho e do mundo: Joaquim Nabuco", "José Teles", 8, "Infantil", "Um-menino-do-engenho-e-do-mundo-Joaquim-Nabuco.jpg");
            criarLivro("República dos bichos", "Paulo Caldas", 8, "Infantil", "Republica-dos-bichos.jpg");
            criarLivro("Duas formas de amar", "José Teles", 8, "Infantil", "Duas-formas-de-amar.jpg");
            criarLivro("Anjos navegam na internet", "José Teles", 8, "Infantil", "Anjos-navegam-na-internet.jpg");
            criarLivro("Aventura no Vale do Catimbau", "Josédio Gusmão", 8, "Infantil", "Aventura-no-Vale-do-Catimbau.jpg");
            criarLivro("Mnemônico, o carneiro que conta", "Rosangela Lima", 8, "Infantil", "Mnemônico-o-carneiro-que-conta.jpg");
            criarLivro("O flautista e a princesa", "Elita Ferreira", 10, "Infantil", "O-flautista-e-a-princesa.jpg");
            criarLivro("Atirei o pau no gato", "Elita Ferreira", 8, "Infantil", "Atirei-o-pau-no-gato.jpg");
            criarLivro("Um livro, um castelo", "José de Castro", 8, "Infantil", "Um-livro-um-castelo.jpg");
            criarLivro("A latinha de lixo", "Socorro Miranda", 10, "Infantil", "A-latinha-de-lixo.jpg");
            criarLivro("Entre números e bichos", "Maria Soares", 8, "Infantil", "Entre-numeros-e-bichos.jpg");
            criarLivro("Bichinhos do vizinho", "Marlene de Fatima Gonçalves", 8, "Infantil", "Bichinhos-do-vizinho.jpg");
            
            
            //==== EDUCAÇÃO =====
            
            criarLivro("Material de apoio para o aprendizado de libras", "Alexandre dos Santos Figueira", 1, "Educação", "Material-de-apoio-para-o-aprendizado-de-libras.jpg");
            criarLivro("Educação musical: da teoria a prática na sala de aula", "Marta Deckert", 1, "Educação", "Educacao-musical-da-teoria-a-pratica-na-sala-de-aula.jpg");
            criarLivro("Pedagogia da música", "Esther Beyer e Patrícia Kebach", 1, "Educação", "Pedagogia-da-musica.jpg");
            criarLivro("Arte na educação escolar", "Maria Heloísa C. de T. Ferraz / Maria F. de Rezende e Fusari", 1, "Educação", "Arte-na-educacao-escolar.jpg");
            criarLivro("Educação de jovens e adultos", "MEC", 1, "Educação", "Educacao-de-jovens-e-adultos-MEC.jpg");
            criarLivro("Conversa com educadores", "Ligia Cademartori", 1, "Educação", "Conversa-com-educadores-Ligia-Cademartori.jpg");
            criarLivro("Atividades lúdicas para a aula de língua estrangeira - espanhol", "Gretel Eres Fernàndes", 1, "Educação", "Atividades-ludicas-para-a-aula-de-lingua-estrangeira-espanhol.jpg");
            criarLivro("Geografia no ensino fundamental I", "Janine Lesann", 1, "Educação", "Geografia-no-ensino-fundamental-I.jpg");
            criarLivro("Coleção explorando o ensino geografia", "Carlos Frederico Simões Serafim", 2, "Educação", "Colecao-explorando-o-ensino-geografia.jpg");
            criarLivro("Cartografia escolar", "Rosângela Doin de Almeida", 1, "Educação", "Cartografia-escolar.jpg");
            criarLivro("A reflexão e a prática no ensino geografia", "Márcio Rogério de Oliveira Cano", 1, "Educação", "A-reflexao-e-a-pratica-no-ensino-geografia.jpg");
            criarLivro("Didática da geografia: proposições metodológicas e conteúdos entrelaçados com a avaliação", "Roberto Filizola", 1, "Educação", "Didatica-da-geografia-proposicoes-metodologicas-e-conteudos-entrelacados-com-a-avaliacao.jpg");
            criarLivro("Para ensinar e aprender geografia", "Nídia Nacib Pontuschka / Tomoko Lyda Paganelli e Núria Hanglei Cacete", 1, "Educação", "Para-ensinar-e-aprender-geografia.jpg");
            criarLivro("Como redigir com estilo", "Francisco José da Silva", 1, "Educação", "Como-redigir-com-estilo.jpg");
            criarLivro("Escola em ação", "Marisa Barreto", 1, "Educação", "Escola-em-acao.jpg");
            criarLivro("Custos da implantação PCMAT na ponta do lápis", "Nelma Mirian Chagas de Araújo", 1, "Educação", "Custos-da-implantacao-PCMAT-na-ponta-do-lapis.jpg");
            criarLivro("Ensino de Geografia", "Antonio Carlos Castrogiovanni", 1, "Educação", "Ensino-de-Geografia.jpg");
            criarLivro("A geografia escolar e a cidade", "Lana de Souza Cavalcanti", 1, "Educação", "A-geografia-escolar-e-a-cidade.jpg");
            criarLivro("O espaço geográfico", "Rosângela D. de Almeida e Elza Y. Passini", 1, "Educação", "O-espaco-geografico.jpg");
            criarLivro("Diretrizes Curriculares nacionais para a educação das relações éticos-raciais e para o ensino de história e cultura afro-brasileira e africana", "MEC", 2, "Educação", "Diretrizes-Curriculares-nacionais-para-a-educacao-das-relacoes-eticos-raciais-e-para-o-ensino-de-historia-e-cultura-afro-brasileira-e-africana.jpg");
            criarLivro("Escolativa", "Meca", 1, "Educação", "Escolativa.jpg");
            criarLivro("Manual do Estudante", "Edic", 1, "Educação", "Manual-do-Estudante.jpg");
            criarLivro("Nova Redação", "DCL", 1, "Educação", "Nova-Redacao.jpg");
            criarLivro("Reaprendendo o português", "edic", 1, "Educação", "Reaprendendo-o-portugues.jpg");
            criarLivro("Ampliando o desenvolvimento infantil", "Bagaço/suporte pedagógico", 1, "Educação", "Ampliando-o-desenvolvimento-infantil.jpg");
            
            
            //==== HISTÓRIA =====
            
            criarLivro("Aprendendo história: reflexão e ensino", "Marieta de Moraes Ferreira / Renato Franco", 1, "História", "Aprendendo-historia-reflexao-e-ensino.jpg");
            criarLivro("Ensinar história", "Maria Auxiliadora Schmidt / Marlene Cainelli", 1, "História", "Ensinar-historia.jpg");
            criarLivro("Ensinar e aprender história: histórias em quadrinhos e canções", "Vários autores", 1, "História", "Ensinar-e-aprender-historia-historias-em-quadrinhos-e-cancoes.jpg");
            criarLivro("A história e a formação para a cidadania", "Helena Guimarães Campos", 1, "História", "A-historia-e-a-formacao-para-a-cidadania.jpg");
            criarLivro("Vivenciando a história - metodologia de ensino da história", "Marta de Souza Lima Brodbeck", 1, "História", "Vivenciando-a-historia-metodologia-de-ensino-da-historia.jpg");
            criarLivro("Novos tempos, novas engrenagens: as transformações no campo e suas dinâmicas urbanas", "Debora de Carvalho / Bruno de Souza", 1, "História", "Novos-tempos-novas-engrenagens-as-transformacoes-no-campo-e-suas-dinamicas-urbanas.jpg");
            criarLivro("Fazer e ensinar História", "Selva Guimarães Fonseca", 1, "História", "Fazer-e-ensinar-Historia.jpg");
            criarLivro("História na sala de aula", "Leandro Karnal", 1, "História", "Historia-na-sala-de-aula.jpg");
            criarLivro("Curso de estudos sociais", "Douglas Michalany / Ciro de Moura Ramos", 1, "História", "Curso-de-estudos-sociais.jpg");
            criarLivro("Organização Social e política do Brasil", "Natanael Sarmento", 1, "História", "Organizacao-Social-e-politica-do-Brasil.jpg");
            criarLivro("Arquitetura brasileira", "Carlos A. C. Lemos", 1, "História", "Arquitetura-brasileira-2.jpg");
            criarLivro("Os porquês da desordem mundial", "Emir Sader", 1, "História", "Os-porques-da-desordem-mundial.jpg");
            criarLivro("Cidadania, um projeto em construção", "André Botelho / Lilia Moritz Schwarcz", 1, "História", "Cidadania-um-projeto-em-construcao.jpg");
            criarLivro("Preconceito contra a origem geográfica e de lugar: as fronteiras da discórdia", "Durval Muniz de Albuquerque Júnior", 1, "História", "Preconceito-contra-a-origem-geografica-e-de-lugar-as-fronteiras-da-discordia.jpg");
            criarLivro("Presidentes da república: símbolos, hinos e canções", "Américo J. Lacombe / Pedro Calmon", 1, "História", "Presidentes-da-republica-simbolos-hinos-e-cancoes.jpg");
            criarLivro("Lei orgânica de Touros", "Prefeitura municipal de Touros", 1, "História", "Lei-organica-de-Touros.jpg");
            criarLivro("Constituição República Federativa do Brasil", "Ministério da educação", 1, "História", "Constituicao-Republica-Federativa-do-Brasil.jpg");
            criarLivro("O negro no Brasil", "Carolina Vianna Dantas", 1, "História", "O-negro-no-Brasil.jpg");
            criarLivro("Cem anos para recordar (Touros)", "Maria Antônia", 1, "História", "Cem-anos-para-recordar-Touros.jpg");
            
            //==== CIÊNCIAS =====
            
            criarLivro("Ensinar Ciência da Natureza por meio de projetos de projetos", "Lízia Porto / Amélia Porto", 1, "Ciências", "Ensinar-Ciencia-da-Natureza-por-meio-de-projetos-de-projetos.jpg");
            criarLivro("Astronáutica", "MEC", 1, "Ciências", "Astronautica-MEC.jpg");
            criarLivro("Poluição do ar", "Samuel Murgel Branco", 1, "Ciências", "Poluicao-do-ar.jpg");
            criarLivro("Manual do defensor do planeta", "João Alegria / Rodrigo Medeiros", 1, "Ciências", "Manual-do-defensor-do-planeta.jpg");
            criarLivro("Meio ambiente", "Caroline Rauch", 1, "Ciências", "Meio-ambiente.jpg");
            criarLivro("Ciências: fácil ou difícil?", "Nelio Bizzo", 1, "Ciências", "Ciencias-facil-ou-dificil.jpg");
            criarLivro("Teoria e prática em ciências na escola", "Maria Cristina da Cunha Campos / Rogério Gonçalves Nigro", 1, "Ciências", "Teoria-e-pratica-em-ciencias-na-escola.jpg");
            criarLivro("Astronomia", "Salvador Nogueira", 1, "Ciências", "Astronomia.jpg");
            criarLivro("Mudanças climáticas", "Gilvan Sampaio de Oliveira", 1, "Ciências", "Mudancas-climaticas-2.jpg");
            criarLivro("Antártica", "Maria Cordélia S. Machado", 1, "Ciências", "Antartica.jpg");
            criarLivro("Um olhar comprometido com o ensino de ciências", "Amélia Porto / Lízia Ramos e Sheila Goulart", 1, "Ciências", "Um-olhar-comprometido-com-o-ensino-de-ciencias.jpg");
	}
	
	// Só cria o livro se ainda não existir um com o mesmo título
	private void criarLivro(String titulo, String autor, int quantidade, String nomeGenero, String arquivoCapa) throws Exception {
		if (Livro.count("titulo = ?1", titulo) > 0) {
			return;
		}
		Livro l = new Livro();
		l.titulo = titulo;
		l.autor = autor;
		l.quantidade = quantidade;
		l.emprestados = 0;
		l.disponivel = true;
		l.genero = Genero.find("genero = ?1", nomeGenero).first();
		if (arquivoCapa != null) {
			File f = Play.getFile("public/images/capas/" + arquivoCapa);
			if (f.exists()) {
				l.capa = new Blob();
				l.capa.set(new FileInputStream(f), MimeTypes.getMimeType(f.getName()));
			}
		}
		l.save();
	}
}
