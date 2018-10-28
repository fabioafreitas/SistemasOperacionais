package jogo_concorrencia;

public class Guerreiro implements Runnable{
	int sorte;
	int ataque;
	Thread thread;
	
	public Guerreiro(int sorte, int ataque, String nome) {
		super();
		this.sorte = sorte;
		this.ataque = ataque;
		//thread = new Thread(this, nome);
	}

	@Override
	public void run() {
		
	}


}
