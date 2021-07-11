package questao1;

public class Lista {
	//Atributo 
		private int vetor[];
		private int vetorAux[];
		private int tamVetor = 0;
		
		//Getters 
			public int getTamanho() {
				return this.tamVetor;
			}
			
			public int getVetor(int index) {
				return this.vetor[index];
			}
			
		//Metodos
			
		private void verificaTamVetor() {
			if(this.vetor == null) {
				this.vetor = new int [5];
				this.vetorAux = new int[6];
			}else if(this.tamVetor == this.vetor.length ) {
					
				for(int cont = 0; cont < this.tamVetor; cont++) {
					this.vetorAux[cont] = this.vetor[cont]; //Tranfere o conteúdo do vetorAux para o vetor
				}
					
				this.vetor = new int[this.tamVetor + 5]; //Declara um vetor novo com mais 5 de espaço
					
				for(int cont = 0; cont < this.tamVetor; cont++) {
					this.vetor[cont] = this.vetorAux[cont]; //Tranfere o conteúdo do vetorAux para o vetor
				}
					
				this.vetorAux = new int[this.tamVetor + 6];
					
			}
		}
			
			
		public void adiciona(int elem) {
			this.verificaTamVetor();
			
			this.vetor[this.tamVetor] = elem;
			
			this.tamVetor++;
		}
		
		public void adiciona(int elem, int index) {
			int contAux = this.tamVetor;
			
			this.verificaTamVetor();
			
			for(int cont = this.tamVetor + 1; cont > 0; cont--){
				
				if(cont == index) {
					this.vetor[cont] = elem;
					cont--;
				}
				this.vetor[cont] = this.vetor[contAux];
				contAux--;
			}
			
			this.tamVetor++;
		}
		
		public void remove(int index) {
			int contAux = 0;
			
			for(int cont = 0; cont < this.tamVetor; cont++){
				if(cont == index) {
					contAux++;
				}
				this.vetor[cont] = this.vetor[contAux];
				contAux++;
			}
			this.tamVetor--;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o==null) return false;
			if(!(o.getClass().isInstance(this))) return false;
			if(this==o)return true;
		
			Lista param = (Lista)o;
		
			for(int cont = 0; cont < this.tamVetor; cont++){
				if(this.vetor[cont] != param.vetor[cont]) {
					return false;
				}
			}
			
			return this.tamVetor == param.tamVetor;
		
		}
}