package br.com.elias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscaEmTexto implements Runnable {

	private String arquivo;
	private String nome;

	public BuscaEmTexto(String arquivo, String nome) {
		this.arquivo = arquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		Scanner leitor;
		try {
			leitor = new Scanner(new File(arquivo));

			int nlinha = 1;
			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine().toLowerCase(); 
				if (linha.contains(nome.toLowerCase()))
					System.out.println(this.arquivo + " linha: " + nlinha);
				nlinha++;
			}		
			leitor.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
