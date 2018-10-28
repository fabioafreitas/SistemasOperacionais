package jantar_dos_filosofos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // cria os grafos (coleção de 5 garfos)
        List<Garfo>garfos = new ArrayList<Garfo>();
        for (int i = 0; i<=4; i++){
            Garfo garfo = new Garfo(i);
            garfos.add(i,garfo);
        }
        // cria a thread do filosofo 0
        Filosofo r0 = new Filosofo(garfos, 0);
        Thread f0 = new Thread(r0);
        // cria a thread do filosofo 1
        Filosofo r1 = new Filosofo(garfos, 1);
        Thread f1 = new Thread(r1);
        // cria a thread do filosofo 2
        Filosofo r2 = new Filosofo(garfos, 2);
        Thread f2 = new Thread(r2);
        // cria a thread do filosofo 3
        Filosofo r3 = new Filosofo(garfos, 3);
        Thread f3 = new Thread(r3);
        // cria a thread do filosofo 4
        Filosofo r4 = new Filosofo(garfos, 4);
        Thread f4 = new Thread(r4);
        // nomeia as threads
        f0.setName("F0");
        f1.setName("F1");
        f2.setName("F2");
        f3.setName("F3");
        f4.setName("F4");
        // manda as threads pra fila de pronto
        f0.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}