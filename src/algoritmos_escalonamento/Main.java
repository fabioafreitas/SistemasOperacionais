package algoritmos_escalonamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> lerArquivo() {
        ArrayList<String> expr = new ArrayList<>();
        try {
            FileReader fileArq = new FileReader("equations.txt");
            BufferedReader arq = new BufferedReader(fileArq);
            String aux;
            while( (aux = arq.readLine()) != null ) {
                expr.add(aux);
            }
            fileArq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expr;
    }

    public static int calcularPrioridade(String expr) {
        if(expr != null) {
            for(int i = 0; i < expr.length() ; i++) {
                if(expr.charAt(i) == '^') return 1;
                else if(expr.charAt(i) == '*' || expr.charAt(i) == '/') return 2;
                else if(expr.charAt(i) == '+' || expr.charAt(i) == '-') return 3;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        ArrayList<String> expr = lerArquivo();
        Processo[] prc = new Processo[expr.size()];
        Calculadora calculadora = new Calculadora();
        String aux;

        for( int i = 0 ; i < expr.size() ; i++) {
            aux = expr.get(i);
            prc[i] = new Processo(aux, calcularPrioridade(aux));
            prc[i].getThread().start();
        }

    }
}
