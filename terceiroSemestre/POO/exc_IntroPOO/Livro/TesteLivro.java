package Livro;

public class TesteLivro {

	public static void main(String[] args) {
		Livro livro1 = new Livro();
		livro1.paginas = 100;
		livro1.titulo = "A sutil arte de tacar o foda-se";
		livro1.numeroDePagiasLidas = 0;
		
		livro1.ler(10);
		System.out.println("Numero de paginas lidas (10): " + (livro1.numeroDePagiasLidas == 10));
		System.out.println("Livro lido (false): " + (livro1.ler(0) == false));
		
		livro1.ler(90);
		System.out.println("Numero de paginas lidas (100): " + (livro1.numeroDePagiasLidas == 100));
		System.out.println("Livro lido (true): " + (livro1.ler(0) == true));
		
		livro1.recomeca();
		System.out.println("Numero de paginas lidas (0): " + (livro1.numeroDePagiasLidas == 0));
		System.out.println("Livro lido (false): " + (livro1.ler(0) == false));
	
	}

}
