package br.com.bytebankconta.banco.testes;

public class TesteString {

	public static void main(String[] args) {
		String nome = "Mario"; //object literal
	    //String outro = new String("Alura"); //m� pr�tica, sempre prefere a sintaxe literal
	    
	    String novo = nome.replace("A", "a");

	    System.out.println(novo);

	    String nova = nome.toLowerCase(); //tamb�m teste toUpperCase()

	    System.out.println(nova);
	    
	    char c = nome.charAt(3); //char i
	    System.out.println(c);

	    int pos = nome.indexOf("rio");
	    System.out.println(pos);

	    String sub = nome.substring(1);
	    System.out.println(sub);
	    
	    for(int i = 0; i < nome.length(); i++) {
	        System.out.println(nome.charAt(i));
	    }
	}
}
