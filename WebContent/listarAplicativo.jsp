<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
	
	
	
	<%@ page import="java.util.List" %>
<%@ page import="entidades.Aplicativo" %>
<%@ page import="dao.AplicativoDao" %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border='1' style='width: 100%;'>
		<tr>
			<td> ID </td>
			<td> tituloApp </td>
			<td> descricao </td>
			<td> autor </td>
			<td> quantidadeDownloads </td>
			<td> valor </td>
			<td> dataLiberacao </td>
			
		</tr>

	<jsp:useBean id="dao" class="dao.AplicativoDao"/>
	
	<c:forEach var="aplicativos" items="${dao.listar()}" varStatus="i">

		<tr>
			<td> ${aplicativos.id} </td>
			<td> ${aplicativos.tituloApp} </td>
			<td> ${aplicativos.descricao} </td>
			<td> ${aplicativos.autor} </td>
			<td> ${aplicativos.quantidadeDownloads} </td>
			<td> ${aplicativos.valor} </td>
			<td> ${aplicativos.dataLiberacao} </td>
			<td>
			
			<td>
							<c:choose>
								<c:when test="${aplicativos.quantidadeDownloads >= 1000}">
									Popular
								</c:when>
								<c:otherwise>
									 Nao Popular!!!!
								</c:otherwise>
							</c:choose>
							</td>
							
							
				<fmt:formatDate value="${aplicativos.dataLiberacao}" pattern="dd/MM/yyyy" /> 
		
			
			<td>
				
				<a href='removerAplicativos?id=${aplicativos.id}'>Remover</a>
			</td>
		</tr>
		
		</c:forEach>
		</table>
	





</body>
</html>