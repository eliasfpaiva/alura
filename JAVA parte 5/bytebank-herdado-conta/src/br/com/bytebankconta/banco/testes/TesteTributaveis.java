package br.com.bytebankconta.banco.testes;
import br.com.bytebankconta.banco.modelo.CalculadorDeImposto;
import br.com.bytebankconta.banco.modelo.ContaCorrente;
import br.com.bytebankconta.banco.modelo.SeguroDeVida;

public class TesteTributaveis {

	public static void main(String[] args) {
		ContaCorrente cc= new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorDeImposto calc = new CalculadorDeImposto();
		calc.registra(cc);
		calc.registra(seguro);
		
		System.out.println(calc.getTotalImposto());

	}

}
