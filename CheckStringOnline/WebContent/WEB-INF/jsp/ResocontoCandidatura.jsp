<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="DAO.Candidatura"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/style.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Candidatura</title>
</head>
<body>
<%-- <% Candidatura candidatura= (Candidatura)request.getAttribute("candidatura"); %> --%>
<fieldset id="fieldsetTable">
    <legend>Candidatura</legend>
	<br>
<table>
	<tr>
		<td>Nome</td>
		<td>${nome}</td>
<%-- 		<td> <% String nome = candidatura.getNome(); out.print(nome); %></td> --%>
	</tr>
	<tr>
		<td>Cognome</td>
		<td>${cognome}</td>
<%-- 		<td> <% String cognome = candidatura.getCognome(); out.print(cognome); %></td> --%>
	</tr>
	<tr>
		<td>E-mail</td>
		<td>${email}</td>
<%-- 		<td> <% String email = candidatura.getEmail(); out.print(email); %></td> --%>
	</tr>
	<tr>
		<td>Data di nascita</td>
		<td>${dataNascita}</td>
<%-- 	<td> <% String dataNascita = candidatura.getDataNascita(); out.print(dataNascita); %></td></tr> --%>
	<tr>
		<td>Numero di telefono</td>	
		<td>${numTelefono}</td>
<%-- 		<td> <% String titoloStudio = candidatura.getTitoloStudio(); out.print(titoloStudio); %></td> --%>
	</tr>
		<tr>
		<td>Titolo di Studio</td>	
		<td>${titoloStudio}</td>
<%-- 		<td> <% String titoloStudio = candidatura.getTitoloStudio(); out.print(titoloStudio); %></td> --%>
	</tr>
	<tr>
		<td>Livello di esperienza</td>
		<td>${livelloEsperienza}</td>
<%-- 		<td> <% String livelloEsperienza =candidatura.getLivelloEsperienza(); out.print(livelloEsperienza); %></td> --%>
	</tr>
	<tr>
		<td>Competenze</td>
		<td>${competenze}</td>
<%-- 		<td> <% String competenze = candidatura.getCompetenze(); out.print(competenze); %></td> --%>
	</tr>
	<tr>
		<td>Ultima esperienza</td>
		<td>${ultimaEsperienza}</td>
<%-- 		<td> <% String ultimaEsperienza = candidatura.getUltimaEsperienza(); out.print(ultimaEsperienza); %></td> --%>
	</tr>
</table>
<td>
<form action="/CheckStringOnline/">
	<input type="submit" value="back">
</form>
</td>
</fieldset>
</body>
</html>