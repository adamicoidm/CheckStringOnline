<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>

<style>
<%@ include file="/style.css" %>
</style>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista candidature</title>
</head>
<body>
	<fieldset id="fieldsetTable">
		<legend>Candidatura</legend>
		<br>

		<table>
			<tr>
				<td>Nome</td>
				<td>Cognome</td>
				<td>E-mail</td>
				<td>Data di nascita</td>
				<td>Numero di telefono</td>
				<td>Titolo di Studio</td>
				<td>Livello di esperienza</td>
				<td>Competenze</td>
				<td>Ultima esperienza</td>
			</tr>

			<tr>
				<td>${ListaCandidature}</td>
				<td>${ListaCandidature}</td>
				<td>E-mail</td>
				<td>Data di nascita</td>
				<td>Numero di telefono</td>
				<td>Titolo di Studio</td>
				<td>Livello di esperienza</td>
				<td>Competenze</td>
				<td>Ultima esperienza</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>