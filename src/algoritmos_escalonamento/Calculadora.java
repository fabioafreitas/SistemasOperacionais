package algoritmos_escalonamento;

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

    // dá um tempo de sleep com base na instrução
    private void tempoEspera(char c) {
        try {
            switch (c) {
                case '-':
                case '+':
                    Thread.sleep(250);
                    break;
                case '*':
                case '/':
                    Thread.sleep(500);
                    break;
                case '^':
                    Thread.sleep(1000);
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            tempoEspera(c[i]);
        }
        int aux = desempilha();
        counter = 0; // resetando a pilha
        return aux;
    }

    public synchronized void setExpr(String expr) {
        this.expr = expr;
    }
}
