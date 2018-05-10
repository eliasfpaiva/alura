package br.com.elias;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestaValidacao {

	public static List<String> camposNulos(Object o) {
		try {
			List<String> lista = new ArrayList<>();
			Class<?> classe = o.getClass();
			for (Field atributo : classe.getFields()) {
				Object value = atributo.get(o);
				if (value == null)
					lista.add(atributo.getName());
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("null")
	public static List<String> buscaString(Object o, String buscada) {
		try {
			List<String> lista = new ArrayList<>();
			Class<?> classe = o.getClass();

			System.out.println("fora");
			for (Field atributo : classe.getFields()) {
				Object value = atributo.get(o);
				System.out.println("teste");
				if(value==null) {
					//					String palavra = value.toString();
					//					if(palavra.contains(buscada)) {
					//						lista.add(atributo.getName());
					System.out.println("null");
				}
			}

			return lista;
		}catch(

				Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}}
