package algoritmos_escalonamento;

public class Processo implements Runnable{
	static int count;
	String nome;
	Thread thread;
	
	public Processo(String nome, int prioridade) {
		count =   1;
		thread = new Thread(this);
		//thread.start();
		//thread.setPriority(prioridade);
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
