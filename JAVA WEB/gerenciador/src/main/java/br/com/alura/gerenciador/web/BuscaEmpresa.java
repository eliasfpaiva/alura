package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filtro = req.getParameter("filtro");
		EmpresaDAO empresa = new EmpresaDAO();
		Collection<Empresa> empresas =  empresa.buscaPorSimilaridade(filtro);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Resultado da busca:<br/><ul>");
		for (Empresa empresa2 : empresas) {
			writer.println("<li>" + empresa2.getId() + ": " + empresa2.getNome() + "</li>");
		}
		writer.println("</ul></body></html>");
	}
}
