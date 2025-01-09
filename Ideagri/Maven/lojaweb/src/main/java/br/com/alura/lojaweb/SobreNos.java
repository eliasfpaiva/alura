package br.com.alura.lojaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.maven.Produto;

@WebServlet(urlPatterns= {"/sobreNos"})
public class SobreNos extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		Produto produto = new Produto("teste", 23);
		writer.println("<!DOCTYPE html><html><head><title>Sobre nós</title></head><body><h1>Nois é nois</br>"
				+ produto.toString() +"</h1></body></html>");
		writer.close();		
	}
}
