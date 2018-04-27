package br.com.elias;

import java.io.FileReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

public class Principal implements UncaughtExceptionHandler{

    public static void main(String[] args) {
        Properties properties = new Properties();
        Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo1.txt"));
        thread.setUncaughtExceptionHandler(new Principal());
        thread.start();
    }

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(e.getMessage() + "\nConsegui /o/");
	}
}

class LeitorPropriedades implements Runnable {

    private Properties propriedades;
    private String nomeArquivo;

    public LeitorPropriedades(Properties propriedades, String nomeArquivo) {
        this.propriedades = propriedades;
        this.nomeArquivo = nomeArquivo;
    }

    public void run() {
        try {
            this.propriedades.load(new FileReader(nomeArquivo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}