<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="DAO.Utente"%>

<!DOCTYPE html>
<html>
<head>
<style><%@include file="/style.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
</head>
<body>

	<fieldset id="fieldset">
		<legend>Pannello di controllo</legend>
		<br>
		<div id="LogData">
			<%
				Utente user = (Utente) request.getAttribute("utente");
// 				String email = user.getEmail();
			%>
		</div>
		<form action="InserisciCompetenza" method="get">
				Inserisci Competenza: <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
		<form action="VediCompetenze" method="get">
				Vedi Competenze: <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
		<form action="VediCandidature" method="get">
				Visualizza tutte le candidature: <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
		<form action="VediNuoveCandidature" method="get">
				Visualizza le nuove candidature: <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
	</fieldset>
</body>
</html>