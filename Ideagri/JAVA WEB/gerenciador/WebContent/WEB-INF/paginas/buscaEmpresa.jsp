<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>GERENCIADOR - Busca Empresa</title>
	</head>
	<body>
		Resultado da busca
		<ul>
			<c:forEach var="empresa" items="${empresas}">
				<li>${empresa.id}: ${empresa.nome}</li>
			</c:forEach>
		</ul>
	</body>
</html>