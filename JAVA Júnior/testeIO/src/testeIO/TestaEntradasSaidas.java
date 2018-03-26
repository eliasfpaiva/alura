package testeIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestaEntradasSaidas {
	
	public static void main(String[] args) throws IOException {
        
		Scanner entrada = new Scanner(System.in);
		PrintStream saida = new PrintStream(new FileOutputStream("saida.txt"));

		System.out.println("Digite");
		String linha = entrada.nextLine();
		saida.println(linha);
		while(linha != null) {
			linha = entrada.nextLine();
			saida.println(linha);
		}
		
        entrada.close();
        saida.close();
    }

}
