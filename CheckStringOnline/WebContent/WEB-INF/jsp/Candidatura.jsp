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
		<legend>Candidatura</legend>
		<br>
		<div id="LogData">
			<%
				Utente user = (Utente) request.getAttribute("utente");
// 				String email = user.getEmail();
			%>
		</div>
		<form action="addCandidatura" method="get">
				Nome:<br> <input type="text" name="nome"
				placeholder="Inserire il nome" value="W" autofocus required><br>
				<br> Cognome:<br> <input type="text" name="cognome"
				placeholder="Inserire il cognome" value="B" required><br>
				<br>E-mail:<br> <input type="email" name="email"
				placeholder="Inserire la e-mail" value="K@B" required><br>
				<br> Data di nascita: <br> <input type="date"
				name="dataNascita" value="1955-05-03" required><br>
				<br>Numero di telefono:<br> <input type="number" name="numTelefono"
				placeholder="Inserire il numero di telefono" value="3" required><br>
			<br><label for="campo_studio">Titolo di studio </label><br>
			<select id="campo_studio" name="titoloStudio" required>
				<option class="dropdown" disabled selected >-- Seleziona titolo di studio --
				</option>
				<option class="dropdown" value="Nessuno" selected>Nessuno</option>
				<option class="dropdown" value="Elementare">Elementare</option>
				<option  class="dropdown"value="Media_Inferiore">Media Inferiore</option>
				<option  class="dropdown"value="Media_Superiore">Media Superiore</option>
				<option  class="dropdown"value="Laurea_Triennale">Laurea Triennale</option>
				<option  class="dropdown"value="Laurea_Successiva">Laurea Successiva</option>
			</select><br>
			<br> <label for="campo_lavoro">Livello esperienze:</label> <br>
			<select id="campo_studio" name="livelloEsperienza" required>
				<option disabled selected>-- Seleziona livello esperienza
					--</option>
				<option value="Junior" selected>Junior</option>
				<option value="Middle">Middle</option>
				<option value="Senior">Senior</option>
			</select><br>
			<br> Competenze Tecniche:<br>
			<textarea id="textArea" name="stringaCompetenza" rows="5" cols="50"
				placeholder="Inserire le competenze separate da punto e virgola"  required></textarea>
			<br>
			<br> Ultima esperienza Lavorativa<br>
			<textarea id="textArea" name="ultimaEsperienza" rows="5" cols="50"
				placeholder="Inserire l'ultima esperienza lavorativa" required></textarea>
			<br>
			<br> Allega Curriculum Vitae: <br> <input type="file"
				name="Curriculum Vitae"><br> <br>
			<br> <input id="buttonSubmit" type="submit" value="Invia Dati">
		</form>
		<form action="LoginButtonCand">
<input type="submit" value="Login">
</form>
	</fieldset>
</body>
</html>