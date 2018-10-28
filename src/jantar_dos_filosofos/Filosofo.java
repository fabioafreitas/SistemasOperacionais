package jantar_dos_filosofos;

import java.util.List;

class Filosofo implements Runnable {
    final int N = 5; // são cinco filosofos e cinco garfos...
    List <Garfo> garfos; // garfos disponíveis 0, 1, 2, 3 e 4
    int filosofo;
    Filosofo (List <Garfo>gs, int fil){
        garfos = gs;
        filosofo = fil;
    }
    public void run(){
        for (int i=0; i<5; i++){
            // pensa ...
            pensaMuito(filosofo);
            // pega garfo da esquerda
            pegaGarfo(/*posiçao*/filosofo, /*dono*/filosofo);
            // pega garfo da direita
            pegaGarfo(/*posiçao*/(filosofo+1)%N, /*dono*/filosofo);
            // fatura o espaguete
            comeEspaguete(filosofo);
            // larga o garfo da esquerda
            largaGarfo(/*posiçao*/filosofo, /*dono*/filosofo);
            // larga o garfo da direita
            largaGarfo(/*posiçao*/(filosofo+1)%N, /*dono*/filosofo);
        }
    }

    private synchronized void pensaMuito(int fil){
        try{
            System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
            Thread.sleep(500);}
        catch (InterruptedException e){}
    }
    private synchronized void pegaGarfo(int pos, int dono){
        System.out.println("++>"+Thread.currentThread().getName()+" PEGA GARFO "+ pos);
        ((Garfo)garfos.get(pos)).setEstadoGarfo(true); // pega garfo
        ((Garfo)garfos.get(pos)).setDonoGarfo(dono); // pega garfo
    }
    private synchronized void largaGarfo(int pos, int dono){
        System.out.println("-->"+Thread.currentThread().getName()+" LARGA GARFO "+ pos);
        ((Garfo)garfos.get(pos)).setEstadoGarfo(false); // garfo liberado
        ((Garfo)garfos.get(pos)).setDonoGarfo(-1); // garfo sem dono
    }
    private synchronized void comeEspaguete(int fil){
        System.out.println("@@>"+Thread.currentThread().getName()+" COME ESPAGUETE");
        try{ Thread.sleep(5000);}
        catch (InterruptedException e){}
    }
}