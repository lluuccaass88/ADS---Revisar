package Estudante;

public class TesteEstudante {

	public static void main(String[] args) {
		Estudante estudante1 = new Estudante("Lucas", 21);
		
		
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		
		System.out.println("Teste idade (25): " + (estudante1.getIdade() == 25));
		
		estudante1.insereNota(3.8F, 5.3F, 9.9F);
		System.out.println("Teste nota 1 (3.8)" + (estudante1.getNotas(0) == 3.8F));
		System.out.println("Teste nota 2 (5.3)" + (estudante1.getNotas(1) == 5.3F));
		System.out.println("Teste nota 3 (9.9)" + (estudante1.getNotas(2) == 9.9F));

		System.out.println("Media: " + estudante1.calculaMedia());

	}

}
