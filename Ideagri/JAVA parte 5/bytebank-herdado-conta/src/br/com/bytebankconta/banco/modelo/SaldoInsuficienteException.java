package br.com.bytebankconta.banco.modelo;

public class SaldoInsuficienteException extends Exception{
	
	//n�o fa�o ideia do porque destes atributos
	static final String SERIAL = "serial";
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
