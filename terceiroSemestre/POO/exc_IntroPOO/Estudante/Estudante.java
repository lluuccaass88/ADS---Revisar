package Estudante;

public class Estudante {
	//Atributos:
	String nome;
	int idade; 
	float notas[] = new float[3];
	
	//Métodos:
	
	//Aumenta a idade
	void fazAniversario() {
		this.idade++;
	}
	
	//inserir nota no array;
	void insereNota(float n1, float n2, float n3) {
		this.notas[0] = n1;
		this.notas[1] = n2;
		this.notas[2] = n3;
	}
	
	float calculaMedia() {
		return (this.notas[0] + this.notas[1] + this.notas[2]) / 3;
	}
	
}
