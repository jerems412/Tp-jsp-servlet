<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Ajout de droit</title>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
<br><br><br><br>
	<form method="post" action="ajoutDroit" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">AJOUTER UN DROIT</h2>
		<div class="div">
			<input type="text" name="name" placeholder="Entrer le nom">
		</div>
		<div>
			<input type="submit" class="btn" value="Ajouter">
		</div>
	 </form>
</div>
</body>
</html>