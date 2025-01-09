package br.com.elias;

import java.util.HashMap;
import java.util.Map;

public class MapaDeClasses {

	public Map<Class<?>, Class<?>> mapa = new HashMap<>();

	//	public Class<?> getClass(String chave) throws Exception{
	//		String valor = mapa.get(chave);
	//		if(valor != null){
	//			return Class.forName(valor);
	//		}else{
	//			throw new RuntimeException(“Chave inválida”);
	//		}
	//	}

}