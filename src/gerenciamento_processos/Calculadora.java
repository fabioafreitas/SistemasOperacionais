package gerenciamento_processos;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Calculadora {

	
    private String expr;
    private ArrayList<Integer> pilha;
    private int counter;

    public Calculadora() {
        pilha = new ArrayList<>();
        counter = 0;
    }

    private boolean isEmpty() {
        return counter == 0;
    }

    private void empilha(int c) {
        pilha.add(counter++, c);
    }

    private int desempilha() {
        if(!isEmpty())
            return pilha.get(--counter);
        return 0;
    }


    public synchronized int calcular() {
        char[] c = expr.toCharArray();
        int a, b;
        for (int i = 0 ; i < c.length ; i++) {
            switch(c[i]) {
                case '-':
                    b = desempilha();
                    a = desempilha();
                    empilha(a-b);
                    break;
                case '+':
                    b = desempilha();
                    a = desempilha();
                    empilha(a+b);
                    break;
                case '*':
                    b = desempilha();
                    a = desempilha();
                    empilha(a*b);
                    break;
                case '/':
                    b = desempilha();
                    a = desempilha();
                    if(b != 0)  empilha(a/b);
                    break;
                case '^':
                    b = desempilha();
                    a = desempilha();
                    if(a!=0 && b!=0)  empilha((int)pow(a,b));
                    break;
                default:
                    empilha(Character.getNumericValue(c[i]));
            }
        }
        int aux = desempilha();
        counter = 0; // resetando a pilha
        return aux;
    }

    public synchronized void setExpr(String expr) {
        this.expr = expr;
    }
}
