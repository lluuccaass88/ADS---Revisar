package spotfy;

public class Musica {
	private final String titulo;
	private final String interprete;
	private final Intervalo duracao;
	private int reproducoes;
	
	public Musica(String t, String i, Intervalo d, int r) {
		this.titulo = t;
		this.interprete = i;
		this.duracao = d;
		this.reproducoes = r;
	}
	
	//get 
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getInterprete() {
		return this.interprete;
	}
	
	public String getDuracao() {
		return this.duracao.toString();
	}
	
	public int getReproducoes() {
		return this.reproducoes;
	}
	
	//Métodos
	public void reproduz() {
		this.reproducoes++;
	}
	
	@Override
	public String toString() {
		return "Musica: " + this.getTitulo() + " " + this.duracao.toString() + " - " + this.getInterprete() + " [" + this.getReproducoes() + " tocadas]";
	}
}
