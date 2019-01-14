<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="DAO.Candidatura"%>
  <%@page import="DAO.Competenza" %>
   <%@page import="DAO.Sinonimo" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<style><%@include file="/style.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Candidatura</title>
</head>
<body>
<fieldset id="fieldsetTable">
    <legend>Candidatura</legend>
	<br>
<table>
	<tr>
		<td>Nome</td>
		<td>${nome}</td>
	</tr>
	<tr>
		<td>Cognome</td>
		<td>${cognome}</td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td>${email}</td>
	</tr>
	<tr>
		<td>Data di nascita</td>
		<td>${dataNascita}</td>
	<tr>
		<td>Numero di telefono</td>	
		<td>${numTelefono}</td>
	</tr>
		<tr>
		<td>Titolo di Studio</td>	
		<td>${titoloStudio}</td>
	</tr>
	<tr>
		<td>Livello di esperienza</td>
		<td>${livelloEsperienza}</td>
	</tr>
	<tr>
		<td>Competenze</td>
		<td>
		<% 
		Object obj= request.getAttribute("listaSinonimi");
		List<Sinonimo> lista_sinonimi =new ArrayList<Sinonimo>();
				lista_sinonimi=(List<Sinonimo>) obj;
		String table="";
		for(int i=0;i<lista_sinonimi.size();i++){
			if(lista_sinonimi.get(i).getCompetenzaStandard()!="")
				table+=lista_sinonimi.get(i).getCompetenzaStandard()+" <br> ";
			else
				table+=lista_sinonimi.get(i).getCorrispondenza()+" <br> ";
		}
		out.println(table);
		%>
		</td>
	</tr>
	<tr>
		<td>Ultima esperienza</td>
		<td>${ultimaEsperienza}</td>
	</tr>
</table>

<form action="/CheckStringOnline/">
	<input type="submit" value="back">
</form>

</fieldset>
</body>
</html>