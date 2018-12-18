<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="DAO.Utente"%>

<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
</head>
<body>

	<fieldset id="fieldset">
		<legend>Candidatura</legend>
		<br>
		<div id="LogData">
			<%
				Utente user = (Utente) request.getAttribute("utente");
				String email = user.getEmail();
			%>
		</div>
		<form action="./candidaturaCompletata" method="post">
			Nome:<br> <input type="text" name="nome"
				placeholder="Inserire il nome" autofocus><br>
			<br> Cognome:<br> <input type="text" name="cognome"
				placeholder="Inserire il cognome"><br>
			<br> Data di nascita: <br> <input type="date"
				name="dataNascita"><br>
			<br> <label for="campo_studio">Titolo di studio </label><br>
			<select id="campo_studio" name="titoloStudio">
				<option disabled selected>-- Seleziona titolo di studio --
				</option>
				<option value="Nessuno">Nessuno</option>
				<option value="Elementare">Elementare</option>
				<option value="Media Inferiore">Media Inferiore</option>
				<option value="Media Superiore">Media Superiore</option>
				<option value="Laurea Triennale">Laurea Triennale</option>
				<option value="laurea Successiva">Laurea Successiva</option>
			</select><br>
			<br> <label for="campo_lavoro">Livello esperienze:</label> <br>
			<select id="campo_studio" name="livelloEsperienza">
				<option disabled selected>-- Seleziona livello esperienza
					--</option>
				<option value="Junior">Junior</option>
				<option value="Middle">Middle</option>
				<option value="Senior">Senior</option>
			</select><br>
			<br> Competenze Tecniche:<br>
			<textarea id="textArea" name="competenze" rows="5" cols="50"
				placeholder="Inserire le competenze"></textarea>
			<br>
			<br> Ultima esperienza Lavorativa<br>
			<textarea id="textArea" name="ultimaEsperienza" rows="5" cols="50"
				placeholder="Inserire l'ultima esperienza lavorativa"></textarea>
			<br>
			<br> Allega Curriculum Vitae: <br> <input type="file"
				name="Curriculum Vitae"><br> <br>
			<br> <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
	</fieldset>
</body>
</html>