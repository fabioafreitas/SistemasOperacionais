package algoritmos_escalonamento;

public class Processo implements Runnable{
	private int prioridade;		// prioridades: 3 (+ -), 2(* /), 1 (^)
	private String expressao;	// representará a expressão a ser calculada
	private Thread thread;
	static 	Calculadora calculadora;
	
	public Processo(String expr, int prioridade) {
		this.expressao = expr;
		this.prioridade = prioridade;
		thread = new Thread(this, expr);
	}
	
	@Override
	public void run() {
		calculadora.setExpr(expressao);
		int x = calculadora.calcular();
		System.out.println(expressao+" = "+x);
	}

	public int getPrioridade() {
		return prioridade;
	}

	public String getExpressao() {
		return expressao;
	}

	public Thread getThread() {
		return thread;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}
}
