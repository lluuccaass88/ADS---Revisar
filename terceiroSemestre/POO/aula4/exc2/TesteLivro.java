package exc3;

import java.util.ArrayList;
import java.util.Collections;

public class TesteLivro {

	public static void main(String[] args) {
		var livros = new ArrayList<Livro>();
		livros.add(new Livro("Harry Potter", 700));
		livros.add(new Livro("Harry Potter", 500));
		livros.add(new Livro("Percy Jackson", 300));
		livros.add(new Livro("Percy Jackson", 200));
	
		System.out.println("Lista desordenada");
		System.out.println(livros);
		
		Collections.sort(livros);
		
		System.out.println("Lista Ordenada");
		System.out.println(livros);
		
	}

	

}
