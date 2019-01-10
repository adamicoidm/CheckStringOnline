<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="DAO.PostgresCompetenzeDAO"%>
<%@ page import="DAO.Competenza"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="java.util.List"%>
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
 <%
         if(request.getSession().getAttribute("ute")==null)
         {
         String site = new String("LoginButtonCand");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
         }
      %>
	<fieldset id="fieldsetTable">
		<legend>Competenze</legend>
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
			<th>Nome competenza</th>
		</tr>
		
		<% 
		Object obj= request.getAttribute("ListaCompetenze");
		List<Competenza> lista_competenze =new ArrayList<Competenza>();
				lista_competenze=(List<Competenza>) obj;
		String table="";
		for(int i=0;i<lista_competenze.size();i++){
				table+="<td>"+lista_competenze.get(i).getNomeCompetenza()+"</td>";
					table+="</tr>";
		}
		out.println(table);
		%>
		</table>
		
		<br><br><br>
		
		<table>
			<tr>
				<td>INSERISCI COMPETENZA</td>
				<td>ELIMINA COMPETENZA</td>
			</tr>
			<tr>
				<td>
					<form action="addCompetenza" method="get">
						<input type="text" name="nomeCompetenza" placeholder="Inserire competenza" value="" autofocus required>
						<br><br>
						<input id="buttonSubmit" type="submit" value="Inserisci">
					</form>
					
				</td>
				<td>
					<form action="removeCompetenza" method="get">
						<input type="text" name="nomeCompetenza"
						placeholder="Inserire competenza" autofocus required> <br> <br> 
						<input id="buttonSubmit" type="submit" value="Elimina">
					</form>
				</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>