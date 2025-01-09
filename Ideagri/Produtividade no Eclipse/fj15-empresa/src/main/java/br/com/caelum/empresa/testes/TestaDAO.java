package br.com.caelum.empresa.testes;

import java.util.List;

import br.com.caelum.empresa.dao.GastoDAO;
import br.com.caelum.empresa.modelo.Gasto;

public class TestaDAO {
	
	public static void main(String[] args) {
		GastoDAO dao = new GastoDAO();
		List<Gasto> gastos = dao.buscaTodos();

		
		for (Gasto gasto : gastos) {
			System.out.println(gasto);
		}
	}
}