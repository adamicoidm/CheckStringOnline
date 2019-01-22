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
		<br><br><br>
		<a href="PanelControl"><input type="button" id="buttonFunction" value="Home"></a>
		</form>
		<table>
			<tr>
				<td>
					<form action="cercaCandidaturaCompetenza" id='fieldsetSearch'>
						Ricerca candidature con queste competenze:
						<br>
						<input type="text" style="width:185px" name="comp" placeholder="es: HTML-CSS-JAVA">
						<br><br>
						<input type="submit" id="buttonSubmit" value="Cerca Candidatura">
					</form>
				</td>
				<td>
					<form action="cercaCandidaturaTitoloStudio" id='fieldsetSearch'>
						Ricerca candidatura con questo titolo di studio:
						<br>
						<select name="titolostudio">
							<option value='Nessuno'>Nessuno</option>
							<option value='Elementare'>Elementare</option>
							<option value='Media_Inferiore'>Media inferiore</option>
							<option value='Media_Superiore'>Media superiore</option>
							<option value='Laurea_Triennale'>Laurea triennale</option>
							<option value='Laurea_Successiva'>Laurea successiva</option>
						</select>
						<br><br>
						<input type="submit" id="buttonSubmit" value="Cerca Candidatura">
					</form>
				</td>
					<td>
					<form action="cercaCandidaturaLivelloEsperienza" id='fieldsetSearch'>
						Ricerca candidatura con questo livello di esperienza:
						<br>
						<select name="livelloesperienza">
							<option value='Junior'>Junior</option>
							<option value='Middle'>Middle</option>
							<option value='Senior'>Senior</option>
						</select>
						<br><br>
						<input type="submit" id="buttonSubmit" value="Cerca Candidatura">
					</form>
				</td>
				<td>
					<form action="cercaCandidaturaStato" id='fieldsetSearch'>
						Ricerca candidatura con questo stato:
						<br>
						<select name="stato">
							<option value='Non interessante'>Non interessante</option>
							<option value='Da rivedere'>Da rivedere</option>
							<option value='Interessante'>Interessante</option>
							<option value='Inserito'>Inserito</option>
						</select>
						<br><br>
						<input type="submit" id="buttonSubmit" value="Cerca Candidatura">
					</form>
				</td>
			</tr>
		</table>
		
		<br><br><br>
			<table id="indextable">
			<thead>
				<tr>
					<th><a href="OrderBy?order_by=nome">NOME</a></th>
					<th><a href="OrderBy?order_by=cognome">COGNOME</a></th>
					<th><a href="OrderBy?order_by=titolostudio">TITOLO STUDIO</a></th>
					<th><a href="OrderBy?order_by=livelloesperienza">LIVELLO ESPERIENZA</a></th>
					<th>VEDI CANDIDATURA</th>
					<th><a href="OrderBy?order_by=stato">STATO</a></th>
					<th>CONFERMA MODIFICA</th>
				</tr>
	</thead>
	<tbody>
		<% 
		Object obj= request.getAttribute("Lista_candidature");
		List<Candidatura> lista_candidature =new ArrayList<Candidatura>();
				lista_candidature=(ArrayList<Candidatura>) obj;
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
	
	 				table+="<option selected >"+lista_candidature.get(i).getStato()+"</option>";
	 					table+="<option value='Non interessante'>Non interessante</option>";
	 					table+="<option value='Da rivedere'>Da rivedere</option>";
	 					table+="<option value='Interessante'>Interessante</option>";
	 					table+="<option value='Inserito'>Inserito</option>";
					
	 				table+="</select></td>";
					table+="<td><input id='buttonCandidature'type='submit' value='Cambia Stato'></td></tr></form>";
					
		}
		out.println(table);
		%>
			</tbody>
		</table>
	</fieldset>
</body>
</html>