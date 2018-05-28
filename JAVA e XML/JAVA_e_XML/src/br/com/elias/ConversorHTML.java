package br.com.elias;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorHTML {
	public static void main(String[] args) throws Exception {

		InputStream xsl = new FileInputStream("src/ModeloHTML.xsl");
		StreamSource xslSource = new StreamSource(xsl);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		
		InputStream xml = new FileInputStream("src/Arquivo.xml");
		StreamSource xmlSource = new StreamSource(xml);
		
		StreamResult saida = new StreamResult("src/VendasSaida.html");
		transformer.transform(xmlSource, saida);
		
		System.out.println("Teste");
	}
}
