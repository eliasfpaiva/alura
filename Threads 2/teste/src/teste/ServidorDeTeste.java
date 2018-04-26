package teste;

import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorDeTeste {

    private AtomicBoolean estaRodando = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        ServidorDeTeste servidor = new ServidorDeTeste();
        servidor.rodar();
        servidor.alterandoAtributo();
    }

    private void rodar() {
        new Thread(new Runnable() {

            public void run() {
                System.out.println("Servidor começando, estaRodando = " + estaRodando );

                while(!estaRodando.get()) {}

                System.out.println("Servidor rodando, estaRodando = " + estaRodando );

                while(estaRodando.get()) {}

                System.out.println("Servidor terminando, estaRodando = " + estaRodando );
            }
        }).start();
    }

    private synchronized void ligar() { this.estaRodando.set(true); }
    
    private synchronized void desligar() { this.estaRodando.set(false); }
    
    private void alterandoAtributo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = true");
        this.ligar();

        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = false");
        this.desligar();        
    }
}
