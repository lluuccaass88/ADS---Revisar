package Livro;

public class Livro {
	//Atributos:
	String titulo;
	int paginas;
	int numeroDePagiasLidas;
	
	//Metodos:
	
	//Recomeça a leitura
	void recomeca() {
		this.numeroDePagiasLidas = 0;
	}
	
	//Le uma pagina
	boolean ler(int paginasLidas) {
		if(this.numeroDePagiasLidas < this.paginas) {
			this.numeroDePagiasLidas = this.numeroDePagiasLidas + paginasLidas;
			return false;
		}else {
			return true;
		}			
	}
}
  