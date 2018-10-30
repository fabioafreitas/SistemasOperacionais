package algoritmos_escalonamento;

public class Processo implements Runnable{
	String nome;
	Thread thread;
	
	public Processo(String nome, int prioridade) {
		this.nome = nome;
		thread = new Thread(this);
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(" ");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
