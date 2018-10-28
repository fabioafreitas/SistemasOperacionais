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
    private void pensaMuito(int fil){
        switch (fil) {
            case 0: // filosofo 0 pensa por 1000 ms...
                try{
                    System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
                    Thread.sleep(500);}
                catch (InterruptedException e){}
            case 1: // filosofo 1 pensa por 2000 ms...
                try{
                    System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
                    Thread.sleep(1000);}
                catch (InterruptedException e){}
            case 2: // filosofo 1 pensa por 3000 ms...
                try{
                    System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
                    Thread.sleep(1500);}
                catch (InterruptedException e){}
            case 3: // filosofo 1 pensa por 4000 ms...
                try{
                    System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
                    Thread.sleep(2000);}
                catch (InterruptedException e){}
            case 4: // filosofo 1 pensa por 5000 ms...
                try{
                    System.out.println("!!>"+Thread.currentThread().getName()+" PENSA");
                    Thread.sleep(2500);}
                catch (InterruptedException e){}
        }
    }
    private void pegaGarfo(int pos, int dono){
        if (((Garfo)garfos.get(pos)).getEstadoGarfo()==false){ // desocupado
            System.out.println("++>"+Thread.currentThread().getName()+" PEGA GARFO "+ pos);
            ((Garfo)garfos.get(pos)).setEstadoGarfo(true); // pega garfo
            ((Garfo)garfos.get(pos)).setDonoGarfo(dono); // pega garfo
        }
    }
    private void largaGarfo(int pos, int dono){
        if (((Garfo)garfos.get(pos)).getEstadoGarfo()==true &&
                ((Garfo)garfos.get(pos)).getDonoGarfo() == dono){ // desocupado
            System.out.println("-->"+Thread.currentThread().getName()+" LARGA GARFO "+ pos);
            ((Garfo)garfos.get(pos)).setEstadoGarfo(false); // garfo liberado
            ((Garfo)garfos.get(pos)).setDonoGarfo(-1); // garfo sem dono
        }
    }
    private void comeEspaguete(int fil){
        // se ambos os garfos estiverem reservados pelo
        // filosofo "fil", então ele come espaguete...
        // Testar a sua solução de proteção, comente o if, deixando apenas o
        // seu conteúdo liberado
        if (((Garfo)garfos.get(fil)).getEstadoGarfo() &&
                ((Garfo)garfos.get((fil+1)%N)).getEstadoGarfo() &&
                ((Garfo)garfos.get(fil)).getDonoGarfo()==fil &&
                ((Garfo)garfos.get((fil+1)%N)).getDonoGarfo()==fil){
            System.out.println("@@>"+Thread.currentThread().getName()+" COME ESPAGUETE");
            try{ Thread.sleep(5000);}
            catch (InterruptedException e){}
        }
    }
}