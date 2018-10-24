package exemplo_concorrencia;

public class Teste {

	public static void main(String[] args) {
		
		TiqueTaque tt = new TiqueTaque();
		ThreadTiqueTaque tique = new ThreadTiqueTaque("Tique", tt); // thread 1
		ThreadTiqueTaque taque = new ThreadTiqueTaque("Taque", tt); // thread 2
		
		try {
			tique.t.join();
			taque.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
