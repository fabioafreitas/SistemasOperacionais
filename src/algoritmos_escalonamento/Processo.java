package algoritmos_escalonamento;

public class Processo implements Runnable{
	int 	prioridade;		// prioridades: 3 (+ -), 2(* /), 1 (^)
	String 	expressao;	// representará a expressão a ser calculada
	Thread 	thread;
	static 	Calculadora calculadora;
	
	public Processo(String nome, int prioridade) {
		this.expressao = nome;
		this.prioridade = prioridade;
		thread = new Thread(this, nome);
	}
	
	@Override
	public void run() {

	}
}
