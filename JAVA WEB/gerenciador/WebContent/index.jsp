<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>GERENCIADOR</title>
	</head>
	<body>
		Bem vindo ao nosso gerenciador de empresas!
		<br/>
		<c:if test="${usuarioLogado!=null}">
			Você está logado como ${usuarioLogado.email}<br/>
		</c:if>		
		<c:if test="${usuarioLogado==null}">
			Você não está logado<br/>
		</c:if>
		
		<br/>
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="BuscaEmpresa" />
			<input type="submit" value="Mostrar lista"/>
		</form>
		<br/>
		Cadastro de nova empresa
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="NovaEmpresa" />
			Nome: <input type="text" name="nome"/>
			<input type="submit" value="Enviar"/>
		</form>
		<br/>
		Login de usuário
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="Login" />
			email: <input type="email" name="email"/>
			senha: <input type="password" name="senha"/>
				   <input type="submit" value="Entrar"/>
		</form>
		<br/>
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="Logout"/>
			<input type="submit" value="Deslogar"/>
		</form>
		<br/>
	</body>
</html>