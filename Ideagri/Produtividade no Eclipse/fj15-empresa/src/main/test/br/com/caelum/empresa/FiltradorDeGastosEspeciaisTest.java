package br.com.caelum.empresa;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class FiltradorDeGastosEspeciaisTest {

	@Test
	public void soDevolveGastosComValorMaiorOuIgualAoLimite() throws Exception {
		Funcionario funcionario = new Funcionario("Felipe", 123, new GregorianCalendar(1989, 3, 17));
		Calendar hoje = Calendar.getInstance();

		Gasto g1 = new Gasto(25.0, "almoco", funcionario, hoje);
		Gasto g2 = new Gasto(150.0, "jantar", funcionario, hoje);
		Gasto g3 = new Gasto(22.0, "extras", funcionario, hoje);
		List<Gasto> lista = Arrays.asList(g1, g2, g3);

		FiltradorDeGastosEspeciais filtrador = new FiltradorDeGastosEspeciais(25);
		List<Gasto> gastosGrandes = filtrador.filtraGastosGrandes(lista);

		assertEquals(2, gastosGrandes.size());
		assertEquals(25, gastosGrandes.get(0).getValor(),0);
		assertEquals(150, gastosGrandes.get(1).getValor(),0);
	}
}
