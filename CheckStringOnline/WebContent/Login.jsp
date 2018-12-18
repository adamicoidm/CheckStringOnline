<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<fieldset id="fieldset">
		<legend>Login</legend>
		<br>
		<form id="formLogin" method="post" action="./Login">
			Email:<br> <input type="text" name="email"
				placeholder="Inserire email" autofocus><br>
			<br> Password:<br> <input type="password" name="password"
				placeholder="Inserire la password"><br>
			<br> <input id="buttonSubmit" type="submit" value="Login"> 
			<input id="buttonRegister" type="button" value="Registrati"
				onclick="location.href='Registrazione.jsp'">
		</form>
	</fieldset>
</body>
</html>