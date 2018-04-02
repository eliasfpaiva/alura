package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String usuario = getUsuario(request);
		
		String uri = request.getRequestURI();
		System.out.println("Usuário " + usuario + " : " + uri);
				
		chain.doFilter(req, response);
	}

	private String getUsuario(HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
		
		if(usuarioLogado == null)
			return "deslogado";
		else
			return usuarioLogado.getEmail();
	}
	
	@Override
	public void destroy() { }

	@Override
	public void init(FilterConfig arg0) throws ServletException { }
}
