package spotfy;

public class testaSpotfy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intervalo i1 = new Intervalo(1, 32, 24);
		Intervalo i2 = new Intervalo(1, 32, 24);
		Intervalo i3 = i1.soma(i2);
	
		Musica m1 = new Musica("N.A.D.A.B.O.M", "Costa Gold", i3, 0);
		
		m1.reproduz();
		
		m1.reproduz();
		
		System.out.println(m1.toString());
		
		
	}

}
