<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>

<style>
<%@ include file="/style.css" %>
</style>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista competenze</title>
</head>
<body>
	<fieldset id="fieldsetTable">
		<legend>Competenze</legend>
		<br>

		<table>
			<tr>
				<td>Nome competenza</td>
				<td>Stato</td>
			</tr>

			<tr>
				<td>${competenze.get(0).getNomeCompetenza()}</td>
				<td>${ListaCandidature.get(0).getCognome()}</td>
				<td>${ListaCandidature.get(0).getEmail()}</td>
				<td>${ListaCandidature.get(0).getDataNascita()}</td>
				<td>${ListaCandidature.get(0).getNumTelefono()}</td>
				<td>${ListaCandidature.get(0).getTitoloStudio()}</td>
				<td>${ListaCandidature.get(0).getLivelloEsperienza()}</td>
				<td>${ListaCandidature.get(0).getCompetenze()}</td>
				<td>${ListaCandidature.get(0).getUltimaEsperienza()}</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>