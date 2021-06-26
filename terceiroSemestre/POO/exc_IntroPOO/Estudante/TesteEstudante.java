package Estudante;

public class TesteEstudante {

	public static void main(String[] args) {
		Estudante estudante1 = new Estudante();
		
		estudante1.idade = 15;
		estudante1.nome = "Luan";
		
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		
		System.out.println("Teste idade (19): " + (estudante1.idade == 19));
		
		estudante1.insereNota(3.8F, 5.3F, 9.9F);
		System.out.println("Teste nota 1 (3.8)" + (estudante1.notas[0] == 3.8F));
		System.out.println("Teste nota 2 (5.3)" + (estudante1.notas[1] == 5.3F));
		System.out.println("Teste nota 3 (9.9)" + (estudante1.notas[2] == 9.9F));

		System.out.println("Media: " + estudante1.calculaMedia());
		
		
	}

}
