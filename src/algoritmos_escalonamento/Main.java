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

    public static void main(String args[]) {
        ArrayList<String> expr = lerArquivo();       // todas as equações a serem passadas para os processos

        Processo[] prc = new Processo[expr.size()];  // array de processos

        Calculadora calculadora = new Calculadora(); // recurso compartilhado

        for( int i = 0 ; i < expr.size() ; i++) {
            prc[i] = new Processo(expr.get(i), "Thread "+(i+1), calculadora);
            prc[i].getThread().start();
        }

    }
}
