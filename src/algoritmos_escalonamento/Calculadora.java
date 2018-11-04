package algoritmos_escalonamento;

import static java.lang.Math.pow;

public class Calculadora {
    String expr;
    private int[] pilha;
    private int counter;

    public Calculadora(String expr) {
        this.expr = expr;
        pilha = new int[expr.length()];
        counter = 0;
    }

    public boolean isFull() {
        return counter == pilha.length;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void empilha(int c) {
        if(!isFull()) pilha[counter++] = c;
    }

    public int desempilha() {
        if(!isEmpty())
            return pilha[--counter];
        return 0;
    }

    public int calcular() {
        char[] c = expr.toCharArray();
        int a, b;
        for (int i = 0 ; i < c.length ; i++) {
            switch(c[i]) {
                case '-':
                    a = desempilha();
                    b = desempilha();
                    empilha(a-b);
                    break;
                case '+':
                    a = desempilha();
                    b = desempilha();
                    empilha(a+b);
                    break;
                case '*':
                    a = desempilha();
                    b = desempilha();
                    empilha(a*b);
                    break;
                case '/':
                    a = desempilha();
                    b = desempilha();
                    if(b != 0)  empilha(a/b);
                    break;
                case '^':
                    a = desempilha();
                    b = desempilha();
                    if(a!=0 && b!=0)  empilha((int)pow(b,a));
                    break;
                default:
                    empilha(Character.getNumericValue(c[i]));
            }
        }
        return desempilha();
    }
}
