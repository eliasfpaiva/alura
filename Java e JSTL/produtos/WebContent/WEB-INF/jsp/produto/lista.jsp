<%@page import="br.com.caelum.produtos.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<head>
		<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>PRODUTOS - Lista</title>
	</head>
	<body>
		<script type="text/javascript">
			function removeProduto(id){
				$("#mensagem").load('<c:url value="/produto/remove"/>' + '?produto.id=' + id);
				$("#produto" + id).remove();
			}
		</script>
	
		<h1>Produtos</h1>
		<h3><div id="mensagem"><fmt:message key="mensagem.bemvindo" /></div></h3>
		
		<table width="100%">
			<tr>
				<td width="20%">Nome</td>
				<td>Preco</td>
				<td>Descricao</td>
				<td>Data de Inicio da Venda</td>
				<td>Usado?</td>
				<!--td width="20%">Remover?</td> -->
			</tr>
			
			<% List<Produto> produtoList = (List<Produto>) request.getAttribute("produtoList");%>
				
				<c:forEach var="produto" items="${produtoList}" varStatus="st">
					<tr id="produto: ${produto.id}">
						<td>${produto.nome.toUpperCase()}</td>
						<td>
							<fmt:formatNumber value="${produto.preco}" type="currency"/>
						</td>
						<td>${produto.descricao}</td>
						<td>
							<fmt:formatDate value="${produto.dataInicioVenda.time}" pattern="EEEE, dd 'de' MMMM 'de' yyyy"/>
						</td>
						<c:choose>
							<c:when test="${produto.usado}"><td>sim</td></c:when>
							<c:otherwise><td>não</td></c:otherwise>					
						</c:choose>
					</tr>
				</c:forEach>
		</table>	
		
		<a href="<c:url value="/produto/formulario" />"><fmt:message key="mensagem.novoProduto" /></a>
	</body>
	<footer><c:import url="../comum/rodape.jsp"/></footer>
</html>