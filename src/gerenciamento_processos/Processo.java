package gerenciamento_processos;

public class Processo implements Runnable{
	private int prioridade;		// prioridades: 3 (+ -), 2(* /), 1 (^)
	private String nome;
	private String expressao;	// representará a expressão a ser calculada
	private Thread thread;
	private static Calculadora calculadora;
	
	public Processo(String expr, String nome, Calculadora calculadora) {
		this.nome = nome;
		this.expressao = expr;
		this.prioridade = prioridade;
		this.calculadora = calculadora;
		thread = new Thread(this, expr);
	}
	
	@Override
	public void run() {
		int count = 1;
		for (int i = 0 ;  i < 5 ; i++) {
			calculadora.setExpr(expressao);
			int x = calculadora.calcular();
			System.out.println(nome+": "+expressao+" = "+x);
		}
	}

	public void calcularPrioridade(String expr) {
		if(expr != null) {
			for(int i = 0; i < expr.length() ; i++) {
				if(expr.charAt(i) == '^') this.prioridade = 1;
				else if(expr.charAt(i) == '*' || expr.charAt(i) == '/') this.prioridade = 2;
				else if(expr.charAt(i) == '+' || expr.charAt(i) == '-') this.prioridade = 3;
			}
		}
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
