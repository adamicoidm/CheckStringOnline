<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<style><%@include file="/style.css"%></style>

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
			<%
			ArrayList<Candidatura> lista = (ArrayList <Candidatura>)request.getAttribute("ListaCandidature");
 			if(lista != null){
				
				for(Candidatura c : lista){
					out.println("<tr>" + 
									"<td> "+ c.getNome()+"</td> " +
									"<td> "+ c.getCognome()+"</td> " +
									"<td> "+ c.getEmail()+"</td> " +
									"<td> "+ c.getDataNascita()+"</td> " +
									"<td> "+ c.getNumTelefono()+"</td> " +
									"<td> "+ c.getTitoloStudio()+"</td> " +
									"<td> "+ c.getLivelloEsperienza()+"</td> " +
									"<td> "+ c.getCompetenze()+"</td> " +
									"<td> "+ c.getUltimaEsperienza()+"</td> " +
								"</tr>");
				}
				
			}else
				out.println("<h1>ERROR MISS</h1>");
			
			%>
		</table>
	</fieldset>
</body>
</html>