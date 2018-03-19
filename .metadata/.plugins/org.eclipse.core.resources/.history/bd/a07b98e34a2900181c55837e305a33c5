package br.com.alura.empresa;

import java.util.Comparator;

public class OrdenaPorIdade implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario f1, Funcionario f2) {
		if (f1 == f2)
			return 0;
		else if(f1.getIdade()>f2.getIdade())
			return 1;
		else if(f1.getIdade()<f2.getIdade())
			return -1;
		else 
			return 0;
	}

}
