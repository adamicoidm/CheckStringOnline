<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="DAO.Utente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html>
<html>
<head>
<style>
	<%@include file="/style.css" %>
</style>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista candidature</title>

<script src="https://www.w3schools.com/lib/w3.js"></script>
</head>
<body>
     <%
         if(request.getSession().getAttribute("ute")==null)
         {
         String site = new String("LoginButtonCand");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
         }
      %>
	<fieldset id="fieldset">
		<legend>Lista nuove candidature</legend>
		<br>
		<form action="Logout" id="alignRightOBJ">
		<p>Sei connesso come ${ute.user}</p>
		<input type='submit' id='buttonFunction'value='Logout'>
		<br><br>
		<a href="PanelControl"><input type="button" id="buttonFunction" value="Home"></a>
		</form>
		<br><br><br>
		<br><br><br>
			<table>
				<tr>
<!-- 					<th onclick="w3.sortHTML('#myTable', '.item', 'td:nth-child(2)')" style="cursor:pointer">NOME</th> -->
<!-- 					<th onclick="w3.sortHTML('#myTable', '.item', 'td:nth-child(3)')" style="cursor:pointer">COGNOME</th> -->
<!-- 					<th onclick="w3.sortHTML('#myTable', '.item', 'td:nth-child(4)')" style="cursor:pointer">TITOLO STUDIO</th> -->
<!-- 					<th onclick="w3.sortHTML('#myTable', '.item', 'td:nth-child(5)')" style="cursor:pointer">LIVELLO ESPERIENZA</th> -->
<!-- 					<th onclick="w3.sortHTML('#myTable', '.item', 'td:nth-child(6)')" style="cursor:pointer">STATO</th> -->
<!-- 					<th>VEDI CANDIDATURA</th> -->
					<th>NOME</th>
					<th>COGNOME</th>
					<th>TITOLO STUDIO</th>
					<th>LIVELLO ESPERIENZA</th>
<!-- 					<th>STATO</th> -->
					<th>VEDI CANDIDATURA</th>
					<th> STATO</th>
					<th>CONFERMA MODIFICA</th>
				</tr>

		<% 
		Object obj= request.getAttribute("Lista_candidature");
		List<Candidatura> lista_candidature =new ArrayList<Candidatura>();
				lista_candidature=(List<Candidatura>) obj;
		String table="";
		for(int i=0;i<lista_candidature.size();i++){
		
			table+="<tr>";
			table+="<form action='ResocontoCandidatura' method='get'>";
			table+="<input type='hidden'name='id_candidatura' value='"+lista_candidature.get(i).getId_candidatura()+"'>";
				table+="<td>"+lista_candidature.get(i).getNome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getCognome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getTitoloStudio()+"</td>";
				table+="<td>"+lista_candidature.get(i).getLivelloEsperienza()+"</td>";
// 				table+="<td>"+lista_candidature.get(i).getStato()+"</td>";
				table+="<td><input id='buttonCandidature' type='submit' value='Vedi Candidatura'></td>";
					table+="</form>";
					table+="<td><form action='CambiaStato' method='get'>";
					table+="<input type='hidden'name='id_candidatura' value='"+lista_candidature.get(i).getId_candidatura()+"'>";
					table+="<select name='stato'>";
	 				table+="<option hidden disabled selected >"+lista_candidature.get(i).getStato()+"</option>";
	 					table+="<option value='Non interessante'>Non interessante</option>";
	 					table+="<option value='Da rivedere'>Da rivedere</option>";
	 					table+="<option value='Interessante'>Interessante</option>";
	 					table+="<option value='Inserito'>Inserito</option>";
	 				table+="</select></td>";
					table+="<td><input id='buttonCandidature'type='submit' value='Cambia Stato'></td></tr></form>";
	 				
		}
		out.println(table);
		%>
	</fieldset>
</body>
</html>