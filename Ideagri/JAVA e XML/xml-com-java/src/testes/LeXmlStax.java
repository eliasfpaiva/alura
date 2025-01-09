package testes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import model.Produto;

public class LeXmlStax {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
		List<Produto> produtos = new ArrayList<>();

		while (eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();

			if (evento.isStartElement()) {
				String nomeEvento = evento.asStartElement().getName().getLocalPart();
				if (nomeEvento.equals("produto")) {
					Produto produto = criaProduto(eventos);
					produtos.add(produto);
				}
			}
		}

		System.out.println(produtos);
	}

	private static Produto criaProduto(XMLEventReader eventos) throws Exception {
		Produto produto = new Produto();
		while (eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();
			if (evento.isStartElement()) {
				String nomeEvento = evento.asStartElement().getName().getLocalPart();
				if (nomeEvento.equals("nome")) {
					evento = eventos.nextEvent();
					String conteudo = evento.asCharacters().getData();
					produto.setNome(conteudo);
				} else if (nomeEvento.equals("preco")) {
					evento = eventos.nextEvent();
					String conteudo = evento.asCharacters().getData();
					produto.setPreco(Double.parseDouble(conteudo));
				}
			} else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}
		return produto;
	}
}