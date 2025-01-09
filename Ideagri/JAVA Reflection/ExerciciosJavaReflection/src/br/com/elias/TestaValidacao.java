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

	public static List<String> buscaString(Object o, String buscada) {
		try {
			List<String> lista = new ArrayList<>();
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object value = f.get(o);
				if (value != null) {
					String strValue = value.toString();
					if (strValue.contains(buscada)) {
						lista.add(f.getName());
					}
				}
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
