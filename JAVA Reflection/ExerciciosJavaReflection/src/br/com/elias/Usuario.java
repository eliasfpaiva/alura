package br.com.elias;

public class Usuario {

	String  login;
	String  senha;
	String  email;
	String  papel;
	boolean ativo;

	public Usuario(String login, String senha, String email, String papel, boolean ativo) {
		super();
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.papel = papel;
		this.ativo = ativo;
	}

	public void    setLogin(String login)  { this.login = login; }
	public void    setSenha(String senha)  { this.senha = senha; }
	public void    setEmail(String email)  { this.email = email; }
	public void    setPapel(String papel)  { this.papel = papel; }
	public void    setAtivo(boolean ativo) { this.ativo = ativo; }
	public String  getLogin()              { return login; }
	public String  getSenha()              { return senha; }
	public String  getEmail()              { return email; }
	public String  getPapel()              { return papel; }
	public boolean isAtivo()               { return ativo; }

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", email=" + email + ", papel=" + papel + ", ativo="
				+ ativo + "]";
	}
}
