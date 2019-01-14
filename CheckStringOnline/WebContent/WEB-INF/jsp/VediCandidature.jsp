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
	<fieldset id="fieldsetTable">
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
					<th>NOME</th>
					<th>COGNOME</th>
					<th>TITOLO STUDIO</th>
					<th>LIVELLO ESPERIENZA</th>
					<th>STATO</th>
					<th>VEDI CANDIDATURA</th>
				</tr>
	
		<% 
		Object obj= request.getAttribute("Lista_candidature");
		List<Candidatura> lista_candidature =new ArrayList<Candidatura>();
				lista_candidature=(List<Candidatura>) obj;
		String table="";
		for(int i=0;i<lista_candidature.size();i++){
			table+="<form action='ResocontoCandidatura' method='get'>";
			table+="<tr name='id_candidatura' value='"+lista_candidature.get(i).getId_candidatura()+"'>";
			table+="<input type='hidden'name='id_candidatura' value='"+lista_candidature.get(i).getId_candidatura()+"'>";
				table+="<td>"+lista_candidature.get(i).getNome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getCognome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getTitoloStudio()+"</td>";
				table+="<td>"+lista_candidature.get(i).getLivelloEsperienza()+"</td>";
				table+="<td>"+lista_candidature.get(i).isStato()+"</td>";
				table+="<td><input type='submit' value='Vedi Candidatura'></td>";
					table+="</tr></form>";
		}
		out.println(table);
		%>
		</table>
	</fieldset>
</body>
</html>