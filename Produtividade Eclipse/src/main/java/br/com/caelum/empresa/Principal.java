package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class Principal {

	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1991, 12, 15);
		Funcionario funcionario = new Funcionario("José", 25, dataNascimento);
		System.out.println(funcionario);
		System.err.println();
		System.out.println("Principal.main()");
		
		Calendar data=new GregorianCalendar(2018, 01, 31);
		Gasto gasto1 = new Gasto(3, "teste", funcionario, data);
		Gasto gasto2 = new Gasto(3, "teste", funcionario, data);
		Gasto gasto3 = new Gasto(3, "teste", funcionario, data);
		Gasto gasto4 = new Gasto(3, "teste", funcionario, data);
		
		System.out.println(gasto1);
		System.out.println(gasto2);
		System.out.println(gasto3);
		System.out.println(gasto4);
	}
}
