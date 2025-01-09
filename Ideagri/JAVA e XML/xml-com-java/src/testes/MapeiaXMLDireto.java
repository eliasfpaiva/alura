package testes;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Produto;
import model.Venda;

public class MapeiaXMLDireto {
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);	
		
//		xmlParaObjeto(jaxbContext);
		
//		objetoParaXml(jaxbContext);
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		
		System.out.println(venda);
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		
		venda.setFormaDePagamento("Cheque");
		
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("Livro de C", 30.00));
		produtos.add(new Produto("Livro de C#", 30.00));
		produtos.add(new Produto("Livro de C++", 30.00));
		
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(venda, writer);
		
		System.out.println(writer.toString());
	}
}