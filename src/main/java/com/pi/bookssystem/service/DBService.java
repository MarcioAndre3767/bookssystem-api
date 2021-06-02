package com.pi.bookssystem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.bookssystem.domain.Categoria;
import com.pi.bookssystem.domain.Livro;
import com.pi.bookssystem.repositories.CategoriaRepository;
import com.pi.bookssystem.repositories.LivroRepository;

@Service
public class DBService {	
	//para salvar no banco de dados, é preciso do repository injetado 
	//camada de acesso aos dados
	@Autowired
	private CategoriaRepository categoriaRespository;
	
	//camada de acesso aos dados
	@Autowired
	private LivroRepository livroRespository;
	
	
	public void instaciaBaseDeDados() {		
//		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
//		Categoria cat2 = new Categoria(null, "Ficção Científica", "O mistério do além");
//		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografias");
		
		String loremIpsum = "O que é Lorem Ipsum?\r\n"
				+ "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.\r\n"
				+ "\r\n"
				+ "Porque nós o usamos?\r\n"
				+ "É um fato conhecido de todos que um leitor se distrairá com o conteúdo de texto legível de uma página quando estiver examinando sua diagramação. A vantagem de usar Lorem Ipsum é que ele tem uma distribuição normal de letras, ao contrário de \"Conteúdo aqui, conteúdo aqui\", fazendo com que ele tenha uma aparência similar a de um texto legível. Muitos softwares de publicação e editores de páginas na internet agora usam Lorem Ipsum como texto-modelo padrão, e uma rápida busca por 'lorem ipsum' mostra vários websites ainda em sua fase de construção. Várias versões novas surgiram ao longo dos anos, eventualmente por acidente, e às vezes de propósito (injetando humor, e coisas do gênero).\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "De onde ele vem?\r\n"
				+ "Ao contrário do que se acredita, Lorem Ipsum não é simplesmente um texto randômico. Com mais de 2000 anos, suas raízes podem ser encontradas em uma obra de literatura latina clássica datada de 45 AC. Richard McClintock, um professor de latim do Hampden-Sydney College na Virginia, pesquisou uma das mais obscuras palavras em latim, consectetur, oriunda de uma passagem de Lorem Ipsum, e, procurando por entre citações da palavra na literatura clássica, descobriu a sua indubitável origem. Lorem Ipsum vem das seções 1.10.32 e 1.10.33 do \"de Finibus Bonorum et Malorum\" (Os Extremos do Bem e do Mal), de Cícero, escrito em 45 AC. Este livro é um tratado de teoria da ética muito popular na época da Renascença. A primeira linha de Lorem Ipsum, \"Lorem Ipsum dolor sit amet...\" vem de uma linha na seção 1.10.32.\r\n"
				+ "\r\n"
				+ "O trecho padrão original de Lorem Ipsum, usado desde o século XVI, está reproduzido abaixo para os interessados. Seções 1.10.32 e 1.10.33 de \"de Finibus Bonorum et Malorum\" de Cicero também foram reproduzidas abaixo em sua forma exata original, acompanhada das versões para o inglês da tradução feita por H. Rackham em 1914.\r\n"
				+ "\r\n"
				+ "Onde posso conseguí-lo?\r\n"
				+ "Existem muitas variações disponíveis de passagens de Lorem Ipsum, mas a maioria sofreu algum tipo de alteração, seja por inserção de passagens com humor, ou palavras aleatórias que não parecem nem um pouco convincentes. Se você pretende usar uma passagem de Lorem Ipsum, precisa ter certeza de que não há algo embaraçoso escrito escondido no meio do texto. Todos os geradores de Lorem Ipsum na internet tendem a repetir pedaços predefinidos conforme necessário, fazendo deste o primeiro gerador de Lorem Ipsum autêntico da internet. Ele usa um dicionário com mais de 200 palavras em Latim combinado com um punhado de modelos de estrutura de frases para gerar um Lorem Ipsum com aparência razoável, livre de repetições, inserções de humor, palavras não características, etc.";
		
		Categoria cat1 = new Categoria(null, "Microeletrônica", "Ramo da eletrônica");
		Categoria cat2 = new Categoria(null, "Programação", "Linguagem de programação");
		Categoria cat3 = new Categoria(null, "Cálculo", "Livros de cálculo I, II, III e IV");
		
		
		
		
		Livro l1 = new Livro(null, "Difusión en estado sólido", "Edgardo Garcia", loremIpsum, cat1);
		Livro l2 = new Livro(null, "Implantação iônica em silício", "Adnei Melges de Andradae", loremIpsum, cat1);
		Livro l3 = new Livro(null, "Java: como programar", "Paule Deitel & Harvey Deitel", loremIpsum, cat2);
		Livro l4 = new Livro(null, "Java e orientação a objetos", "Paule Deitel & Harvey Deitel", loremIpsum, cat2);
		Livro l5 = new Livro(null, "Java para web: Desenvolvimento de aplicações", "William Pereira Alves", loremIpsum, cat2);
		Livro l6 = new Livro(null, "Um curso de Cálculo - Volume 4", "Hamilton Luiz Guidorizzi", loremIpsum, cat3);
			
		//o livro conhece a sua categoria, mas a categoria não conhece o livro
		//adicionando o livro na categoria
		cat1.getLivros().addAll( Arrays.asList(l1, l2) );
		cat2.getLivros().addAll( Arrays.asList(l3, l4, l5) );
		cat3.getLivros().addAll( Arrays.asList(l6) );
		
		
		//salvando
		categoriaRespository.saveAll( Arrays.asList(cat1, cat2, cat3) );
		livroRespository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
		
		
	}

}
