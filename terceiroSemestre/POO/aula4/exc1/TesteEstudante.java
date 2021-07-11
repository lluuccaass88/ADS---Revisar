package questao1;

public class TesteEstudante {

	public static void main(String[] args) {
		Estudante estudante1 = new Estudante("Lucas", 21);
		Estudante estudante2 = new Estudante("Lucas", 21);
		
		
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		estudante1.fazAniversario();
		
		estudante1.insereNota(3.8F, 5.3F, 9.9F);

		estudante2.fazAniversario();
		estudante2.fazAniversario();
		estudante2.fazAniversario();
		estudante2.fazAniversario();
		
		estudante2.insereNota(3.8F, 5.3F, 9.9F);

		
		
		System.out.println("Media: " + estudante1.calculaMedia());

		//System.out.println(estudante1.toString());
	
		System.out.println(estudante1.equals(estudante2));
		
		
		
	}

}