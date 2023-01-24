<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Liste des droits</title>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
<br><br>
<table>
	<caption><h2>LISTE DES DROITS</h2></caption>
	<tr>
		<th>ID</th>
		<th>NOM</th>
		<th>ACTIONS</th>
	</tr>
	<tr>
		<td>1</td>
		<td>droit 1</td>
		<td><button>Delete</button></td>
	</tr>
	<tr>
		<td>2</td>
		<td>droit 2</td>
		<td><button>Delete</button></td>
	</tr>
	<!--  <c:forEach items ="${droits }" var="droit">
		<tr>
			<td>${droit.id }</td>
			<td>${droit.name }</td>
			<td><button>Delete</button></td>
		</tr>
	</c:forEach>-->
</table>
</div>
</body>
</html>