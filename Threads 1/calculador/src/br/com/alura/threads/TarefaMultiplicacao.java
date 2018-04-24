package br.com.alura.threads;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaMultiplicacao extends Thread {

	JTextField primeiro;
	JTextField segundo;
	JLabel resultado;
	
	public TarefaMultiplicacao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
		this.setName("Multiplicação");
	}
	
	@Override
	public void run() {
		long valor1 = Long.parseLong(primeiro.getText());
		long valor2 = Long.parseLong(segundo.getText());
		Long produto = valor1 * valor2;
		resultado.setText(produto.toString());
	}
}
