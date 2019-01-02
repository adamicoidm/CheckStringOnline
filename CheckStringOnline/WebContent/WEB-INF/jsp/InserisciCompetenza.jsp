<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="DAO.Utente"%>
<!DOCTYPE html>

<html>
<head>
<style><%@include file="/style.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
</head>
<body>
	<fieldset id="fieldset2">
		<legend>Amministrazione</legend>
		<br>
		<div id="LogData">
			<%
				Utente user = (Utente) request.getAttribute("utente");
// 				String email = user.getEmail();
			%>
		</div>
		<form action="addCompetenza" method="get">
		Nuova competenza:<br><input type="text" name="nomeCompetenza" placeholder="Inserire il nome" value="" autofocus required>
		<br>
	<input id="buttonSubmit" type="submit" value="Invia Dati">
	</form>
	</fieldset>
	
</body>
</html>