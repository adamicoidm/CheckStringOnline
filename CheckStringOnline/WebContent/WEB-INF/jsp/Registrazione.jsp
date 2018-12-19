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
		<legend>Registrazione</legend>
		<br>
		<form id="formLogin" action="./Registrazione" method="post">
			Nome :<br> <input type="text" name="nome"
				placeholder="Inserire il nome" autofocus><br> <br>
			Cognome:<br> <input type="text" name="cognome"
				placeholder="Inserire il cognome"><br> <br> 
			Numero di Telefono:<br> <input type="number" name="telefono"
				placeholder="Inserire il numero di telefono"><br> <br>
				<br> E-mail:<br> <input type="email" name="email"
				placeholder="Inserire l'indirizzo mail"><br>	
			Password:<br> <input type="password" name="password"
				placeholder="Inserire la password"><br> <br>
			Ripeti password:<br> <input type="password" name="password2"
				placeholder="Inserire la password"><br> <br> <input
				id="Registra" type="submit" value="Registrati"
				onclick="myServlet.java">
		</form>
	</fieldset>
</body>
</html>