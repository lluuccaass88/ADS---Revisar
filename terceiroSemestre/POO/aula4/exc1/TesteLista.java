package questao1;

public class TesteLista {

	public static void main(String[] args) {
		
		Lista lista1 = new Lista();
		
		lista1.adiciona(2);
		lista1.adiciona(3);
		lista1.adiciona(8);
		

		Lista lista2 = new Lista();
		
		lista2.adiciona(2);
		lista2.adiciona(3);
		lista2.adiciona(8);
		
		System.out.println(lista1.equals(lista2));
		
	}
}

