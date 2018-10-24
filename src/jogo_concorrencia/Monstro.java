package jogo_concorrencia;

public class Monstro {
	int vida;

	public Monstro(int vida) {
		super();
		this.vida = vida;
	}
	
	synchronized void receberDano(int dano) {
		if(vida <= 0) {
			vida = 0;
			System.out.println("HP Monstro: "+vida);
		}
		else  {
			vida -= dano;
			System.out.println("HP Monstro: "+vida);
		}
	}
}
