<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Liste des comptes</title>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
<br><br>
<table>
	<caption><h2>LISTE DES COMPTES</h2></caption>
	<tr>
		<th>ID</th>
		<th>NOM</th>
		<th>ACTIONS</th>
	</tr>
	<c:forEach items ="${comptes }" var="compte">
		<tr>
			<td>${compte.id }</td>
			<td>${compte.username }</td>
			<td><button>Delete</button></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>