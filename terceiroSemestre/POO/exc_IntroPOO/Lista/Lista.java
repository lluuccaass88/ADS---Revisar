package Lista;

public class Lista {

	//Atributo 
	int vetor[];
	int vetorAux[];
	int tamVetor = 0;
	
	//métodos
	void verificaTamVetor() {
		if(this.vetor == null) {
			this.vetor = new int [5];
			this.vetorAux = new int[6];
		}else if(this.tamVetor == this.vetor.length ) {
			
			for(int cont = 0; cont < this.tamVetor; cont++) {
				this.vetorAux[cont] = this.vetor[cont]; //Tranfere o conteúdo do vetorAux para o vetor
			}
			
			this.vetor = new int[this.tamVetor + 5];
			
			
			for(int cont = 0; cont < this.tamVetor; cont++) {
				this.vetor[cont] = this.vetorAux[cont]; //Tranfere o conteúdo do vetorAux para o vetor
			}
			
			this.vetorAux = new int[this.tamVetor + 6];
			
		}
	}
	
	void adicionaFinal(int elem) {
		this.verificaTamVetor();
		
		this.vetor[this.tamVetor] = elem;	
		
		this.tamVetor++;
	}
	
	void adicionaPos(int elem, int pos) {
		int contAux = 0;
		
		verificaTamVetor();
		
		for(int cont = 0; cont < this.tamVetor; cont++) { //Tranfere o conteúdo do vetorAux para o vetor
			this.vetorAux[cont] = this.vetor[cont]; 
		}
		
		for(int cont = 0; cont < this.tamVetor +1; cont++) {//Tranfere o conteúdo do vetorAux para o vetor
			if(cont == pos) {
				this.vetor[cont] = elem;
			}else {
				this.vetor[cont] = this.vetorAux[contAux];
				contAux++;
			}
		}
		
		this.tamVetor++;
	}
	
	int get(int pos) {
		return this.vetor[pos];
	}
	
	int getTamanho() {
		return this.vetor.length;
	}
	
	void remove(int pos) {
		
		int contAux = 0;
			
			for(int cont = 0; cont < this.tamVetor; cont++){
				if(cont == pos) {
					contAux++;
				}
				this.vetor[cont] = this.vetor[contAux];
				contAux++;
			}
			this.tamVetor--;
		
		this.tamVetor--;
	}
	
} 