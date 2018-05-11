package br.com.elias;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.elias.models.Produto;

public class Principal {

	public static void main(String[] args) throws Exception {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/Arquivo.xml");

		NodeList list = document.getElementsByTagName("produto");

		for (int i = 0; i < list.getLength() - 1; i++) {
			Element item = (Element) list.item(i);

			String nome = item.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(item.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod.toString());

			//			System.out.println("Nome: " + item.getElementsByTagName("nome").item(0).getTextContent() + "\nPreco: R$"
			//					+ item.getElementsByTagName("preco").item(0).getTextContent());
		}
	}
}