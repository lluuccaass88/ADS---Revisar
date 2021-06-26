package Lista;

public class TesteLista {

	public static void main(String[] args) {
		
		Lista lista1 = new Lista();
		
		lista1.adicionaFinal(3);
		lista1.adicionaFinal(2);
		lista1.adicionaFinal(4);
		lista1.adicionaFinal(25);
		lista1.adicionaFinal(6);
		lista1.adicionaFinal(4);
		lista1.adicionaFinal(8);
		lista1.adicionaFinal(6);
		
		System.out.println("Pos 0 (3)" + lista1.get(0));
		System.out.println("Pos 0 (3)" + lista1.get(1));
		System.out.println("Pos 0 (3)" + lista1.get(2));
		System.out.println("Pos 0 (3)" + lista1.get(3));
		System.out.println("Pos 0 (3)" + lista1.get(4));
		System.out.println("Pos 0 (3)" + lista1.get(5));
		System.out.println("Pos 0 (3)" + lista1.get(6));
		System.out.println("Pos 0 (3)" + lista1.get(7));
		
		lista1.adicionaPos(7, 3);
		
		System.out.println("\n  \n");
		System.out.println("Pos 0 (3)" + lista1.get(0));
		System.out.println("Pos 0 (3)" + lista1.get(1));
		System.out.println("Pos 0 (3)" + lista1.get(2));
		System.out.println("Pos 0 (3)" + lista1.get(3));
		System.out.println("Pos 0 (3)" + lista1.get(4));
		System.out.println("Pos 0 (3)" + lista1.get(5));
		System.out.println("Pos 0 (3)" + lista1.get(6));
		System.out.println("Pos 0 (3)" + lista1.get(7));
		System.out.println("Pos 0 (3)" + lista1.get(8));
	
		System.out.println("\nTamanho do Vetor: " + lista1.getTamanho());
		
		lista1.remove(3);
	
		System.out.println("Pos 0 (3)" + lista1.get(0));
		System.out.println("Pos 0 (3)" + lista1.get(1));
		System.out.println("Pos 0 (3)" + lista1.get(2));
		System.out.println("Pos 0 (3)" + lista1.get(3));
		System.out.println("Pos 0 (3)" + lista1.get(4));
		System.out.println("Pos 0 (3)" + lista1.get(5));
		System.out.println("Pos 0 (3)" + lista1.get(6));
		System.out.println("Pos 0 (3)" + lista1.get(7));
		System.out.println("Pos 0 (3)" + lista1.get(8));
		
	}

}
