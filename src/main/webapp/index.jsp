<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Login</title>
</head>
<body>
<div class="container">
<br><br><br><br>
	<form method="post" action="Login" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">CONNEXION</h2>
	    <div class="div">
			<input type="text" name="login" class="input" placeholder="Entrer le login">
		</div>
		<div class="div">
			<input type="password" name="password"placeholder="Entrer le mot de passe">
		</div>
		<div>
			<input type="submit" class="btn" value="connexion">
		</div>
		<c:if test = "${msg_error}">
		<span style="color:red;">
			<c:out>${ msg_error }</c:out>
		</span>
	</c:if>
	 </form>
</div>
</body>
</html>