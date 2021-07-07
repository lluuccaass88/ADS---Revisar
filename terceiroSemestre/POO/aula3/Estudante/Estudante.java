package Estudante;

public class Estudante {
	//Atributos:
		private String nome;
		private int idade; 
		private float notas[] = new float[3];
		
		 //Construtor
		public Estudante(String n, int i) {
			this.nome = n;
			this.idade = i;
		}
		
		
		
		//Métodos:
		public int getIdade() {
			return this.idade;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public float getNotas(int index) {
			return this.notas[index];
		}
		
		//Aumenta a idade
		public void fazAniversario() {
			this.idade++;
		}
		
		//inserir nota no array;
		public void insereNota(float n1, float n2, float n3) {
			this.notas[0] = n1;
			this.notas[1] = n2;
			this.notas[2] = n3;
		}
		
		public float calculaMedia() {
			return (this.notas[0] + this.notas[1] + this.notas[2]) / 3;
		}
}
