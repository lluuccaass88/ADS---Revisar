package Lista;

public class TesteLista {

	public static void main(String[] args) {
		
		Lista lista1 = new Lista();
		
		lista1.adiciona(2);
		lista1.adiciona(3);
		lista1.adiciona(8);
		
		
		
		System.out.println("Elemento 0: " + lista1.getVetor(0));
		System.out.println("Elemento 1: " + lista1.getVetor(1));
		System.out.println("Elemento 2: " + lista1.getVetor(2));
		
		System.out.println("Tamanho do vetor: (3): " + (lista1.getTamanho() == 3));
		
		lista1.adiciona(7, 1);
		
		System.out.println("\nVetor cm o 7 na pos. 1");
		
		System.out.println("Elemento 0: " + lista1.getVetor(0));
		System.out.println("Elemento 1: " + lista1.getVetor(1));
		System.out.println("Elemento 2: " + lista1.getVetor(2));
		System.out.println("Elemento 3: " + lista1.getVetor(3));
		
		System.out.println("Tamanho do vetor: (4): " + (lista1.getTamanho() == 4));
		
		lista1.remove(1);
		
		System.out.println("\nVetor sem o 7");
		
		System.out.println("Elemento 0: " + lista1.getVetor(0));
		System.out.println("Elemento 1: " + lista1.getVetor(1));
		System.out.println("Elemento 2: " + lista1.getVetor(2));
		
		System.out.println("Tamanho do vetor: (3): " + (lista1.getTamanho() == 3));
	
	}

}