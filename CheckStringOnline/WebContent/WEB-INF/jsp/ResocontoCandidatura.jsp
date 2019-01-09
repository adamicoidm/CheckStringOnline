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
	<form action="Logout" id="alignRightOBJ">
		<p>Sei connesso come ${ute.user}</p>
		<input type='submit' id='buttonFunction'value='Logout'>
		<br><br>
		<a href="PanelControl"><input type="button" id="buttonFunction" value="Home"></a>
		</form>
		<br><br>
		<br><br><br>
		<br><br><br>
<table>
	<tr>
		<th>CAMPO</th>
		<th>DATI</th>
	</tr>
	<tr>
		<td>Nome</td>
		<td>${ListaCandidature.get(0).getNome()}</td>
<%-- 		<td> <% String nome = candidatura.getNome(); out.print(nome); %></td> --%>
	</tr>
	<tr>
		<td>Cognome</td>
		<td>${ListaCandidature.get(0).getCognome()}</td>
<%-- 		<td> <% String cognome = candidatura.getCognome(); out.print(cognome); %></td> --%>
	</tr>
	<tr>
		<td>E-mail</td>
		<td>${ListaCandidature.get(0).getEmail()}</td>
<%-- 		<td> <% String email = candidatura.getEmail(); out.print(email); %></td> --%>
	</tr>
	<tr>
		<td>Data di nascita</td>
		<td>${ListaCandidature.get(0).getDataNascita()}</td>
<%-- 	<td> <% String dataNascita = candidatura.getDataNascita(); out.print(dataNascita); %></td></tr> --%>
	<tr>
		<td>Numero di telefono</td>	
		<td>${ListaCandidature.get(0).getNumTelefono()}</td>
<%-- 		<td> <% String titoloStudio = candidatura.getTitoloStudio(); out.print(titoloStudio); %></td> --%>
	</tr>
		<tr>
		<td>Titolo di Studio</td>	
		<td>${ListaCandidature.get(0).getTitoloStudio()}</td>
<%-- 		<td> <% String titoloStudio = candidatura.getTitoloStudio(); out.print(titoloStudio); %></td> --%>
	</tr>
	<tr>
		<td>Livello di esperienza</td>
		<td>${ListaCandidature.get(0).getLivelloEsperienza()}</td>
<%-- 		<td> <% String livelloEsperienza =candidatura.getLivelloEsperienza(); out.print(livelloEsperienza); %></td> --%>
	</tr>
	<tr>
		<td>Stato</td>
		<td>${ListaCandidature.get(0).isStato()}</td>
<%-- 		<td> <% String competenze = candidatura.getCompetenze(); out.print(competenze); %></td> --%>
	</tr>
	<tr>
		<td>Ultima esperienza</td>
		<td>${ListaCandidature.get(0).getUltimaEsperienza()}</td>
<%-- 		<td> <% String ultimaEsperienza = candidatura.getUltimaEsperienza(); out.print(ultimaEsperienza); %></td> --%>
	</tr>
</table>
<form action="VediNuoveCandidature">
	<input type="submit" value="back">
</form>

</fieldset>
</body>
</html>