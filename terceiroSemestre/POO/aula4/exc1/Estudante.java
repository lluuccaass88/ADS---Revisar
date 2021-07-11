package questao1;

public class Estudante{
	//Atributos:
	private final String nome;
	private int idade; 
	private float notas[] = new float[3];
			
	//Construtor
	public Estudante(String n, int i) {
	this.nome = n;
	this.idade = i;
	}
			
	//Getters
	public int getIdade() {
	return this.idade;
	}
			
	public String getNome() {
		return this.nome;
	}
			
	public float getNotas(int index) {
		return this.notas[index];
	}
	
	//Métodos:		
	
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
			
	//Calcula a média
	public float calculaMedia() {
		return (this.notas[0] + this.notas[1] + this.notas[2]) / 3;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " - " + this.idade + " anos \n" + "Nota1: " + this.notas[0] +  "\nNota2: " + this.notas[1] + "\nNota3: " +this.notas[2] + "\nMedia: " + (this.notas[0] + this.notas[1] + this.notas[2]) / 3;
	}
	

	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(!(o.getClass().isInstance(this))) return false;
		Estudante parametro = (Estudante) o;
		return (this.nome.equals(parametro.nome) && this.notas[0]==parametro.notas[0] && this.notas[1]==parametro.notas[1] && this.notas[2]==parametro.notas[2]);
	}
	
}
