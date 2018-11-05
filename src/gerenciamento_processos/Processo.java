package gerenciamento_processos;

public class Processo implements Runnable{
	private int prioridade;		// prioridades: 10 (+ -), 5(* /), 1 (^)
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
	
	// dá um tempo de sleep com base na instrução
    private synchronized void tempoEspera() {
    	char[] s = expressao.toCharArray();
    	int timer = 0;
    	for (int i = 0; i < s.length; i++) {
    		switch (s[i]) {
            case '-':
            case '+':
            	timer += 125;
                break;
            case '*':
            case '/':
            	timer += 250;
                break;
            case '^':
            	timer += 500;
                break;
    		}
		}
    	
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void run() {
		//for (int i = 0 ;  i < 5 ; i++) {
			//tempoEspera();
			calculadora.setExpr(expressao);
			int x = calculadora.calcular();
			System.out.println(nome+": "+expressao+" = "+x);
		//}
	}
	
	public void calcularPrioridade(String expr) {
		if(expr != null) {
			for(int i = 0; i < expr.length() ; i++) {
				if(expr.charAt(i) == '^') thread.setPriority(1);
				else if(expr.charAt(i) == '*' || expr.charAt(i) == '/') thread.setPriority(5);
				else if(expr.charAt(i) == '+' || expr.charAt(i) == '-') thread.setPriority(10);
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
