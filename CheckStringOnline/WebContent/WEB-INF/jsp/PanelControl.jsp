<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@page import="DAO.Utente"%>
<%@ page session="true" %>
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
		<form action="Logout" id="alignRightOBJ">
		<p>Sei connesso come ${ute.user}</p>
		<br><input type='submit' id='buttonFunction'value='Logout'>
		</form>
	
		</div>
		<br><br><br>
		<br><br><br>
		<table>
		<tr>
			<td>
				<form action="VediCompetenze" method="get">
				<input id="buttonSubmit" type="submit" value="Competenze">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="VediCandidature" method="get">
				<input id="buttonSubmit" type="submit" value="Candidature">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="VediNuoveCandidature" method="get">
				<input id="buttonSubmit" type="submit" value="Nuove candidature">
				</form>
			</td>
		</tr>
	</table>
	</fieldset>
</body>
</html>