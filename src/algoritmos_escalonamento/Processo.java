package algoritmos_escalonamento;

public class Processo implements Runnable{
	private String nome;
	private int prioridade;
	private double tempoExecucao;
	private Thread thread;
	
	public Processo(String nome, int prioridade, int tempoExecucao) {
		this.nome = nome;
		this.prioridade = prioridade;
		this.tempoExecucao = tempoExecucao;
		thread = new Thread(this, nome);
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
