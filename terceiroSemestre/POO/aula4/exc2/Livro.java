package exc3;

public class Livro implements Comparable<Livro>{
	//Atributos:
	private final String titulo;
	private final int paginas;
	private int numeroDePagiasLidas;
		
	public Livro(String t, int p) {
		this.titulo = t;
		this.paginas = p;
		this.numeroDePagiasLidas = 0;
	}
	
	public int getPaginasLidas(){
		return this.numeroDePagiasLidas;
	}
	
	//Metodos:
		
	//Recomeça a leitura
	public void recomeca() {
		this.numeroDePagiasLidas = 0;
	}
		
	//Le uma pagina
	public boolean ler(int paginasLidas) {
		if(this.numeroDePagiasLidas < this.paginas) {
			this.numeroDePagiasLidas = this.numeroDePagiasLidas + paginasLidas;
			return false;
		}else {
			return true;
		}			
	}
	
	@Override
	public String toString() {
		return "Titulo: "+ this.titulo +" - "+ this.paginas+" paginas \n";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(!(o.getClass().isInstance(this))) return false;
		if(this==o)return true;
		
		Livro param = (Livro)o;
		return (this.paginas==param.paginas && this.titulo.equals(param.titulo));
	}
	
	public int compareTo(Livro o) {
		int ret = 9;
		
		if(this.equals(o)) {
			ret = 0;
		}
		
		if(ret == 0) {
			return this.titulo.compareTo(o.titulo);
		}else {
			if(this.paginas > o.paginas){
				return +1;
			}else {
				return -1;
			}
		}	
	}
}
