<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Ajout de compte</title>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
<br><br><br><br>
	<form method="post" action="Compte" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">AJOUTER UN COMPTE</h2>
	 	<div class="div">
			<input type="text" name="username" placeholder="Entrer le nom">
		</div>
		<div class="div">
			<input type="password" name="password" placeholder="Entrer le nom">
		</div>
		<div class="div">
			<select>
				<option selected disabled>-- Selectionner un droit --</option>
				<c:forEach items ="${droits }" var="droit">
					<option value="${droit.id}">${droit.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="submit" class="btn" value="Ajouter">
		</div>
	 </form>
</div>
</body>
</html>