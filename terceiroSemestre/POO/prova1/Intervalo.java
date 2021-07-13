package spotfy;


public class Intervalo {
	private final int segundos;
	
	public Intervalo(int horas, int minutos, int segundos) {
		this.segundos = horas * 60 * 60 + minutos * 60 + segundos;
	}
	
	public Intervalo(int minutos, int segundos) {
		this.segundos = minutos * 60 + segundos;
	}
	
	//get
	private int getHoras(){
		return this.segundos/60/60;
	}
	
	private int getMinutos() {
		return (this.segundos/60) % 60;
	}
	
	private int getSegundos() {
		return this.segundos % 60;
	}
	
	//Metodos
	public Intervalo soma(Intervalo o) {
		return new Intervalo(this.getHoras() + o.getHoras(), this.getMinutos() + o.getMinutos(), this.getSegundos() + o.getSegundos());
	}
	
	@Override
	public String toString() {
		return this.getHoras() + ":" + this.getMinutos() + ":" + this.getSegundos();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(!(o.getClass().isInstance(this))) return false;
		Intervalo param = (Intervalo) o;
		return (this.getHoras() == param.getHoras() && this.getMinutos() == param.getMinutos() && this.getSegundos() == param.getSegundos()); 
	}
	
}
