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

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String usuario = getUsuario(request);
		System.out.println("Usuário: " + usuario + " acessando URI: " + uri);
		chain.doFilter(req, resp);
	}

	private String getUsuario(HttpServletRequest request) {
		String usuario = "<deslogado>";
		
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null)	
			return usuario;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado"))
				usuario = cookie.getValue();
		}
		return usuario;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
