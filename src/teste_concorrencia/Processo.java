package teste_concorrencia;

public class Processo implements Runnable{
	
	String nome;
	Thread t;
	
	public Processo(String nome, int prioridade) {
		this.nome = nome;
		t = new Thread(this, nome);
		t.start();
		t.setPriority(prioridade);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("thread "+nome);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	synchronized void a() {
		
	}
}
