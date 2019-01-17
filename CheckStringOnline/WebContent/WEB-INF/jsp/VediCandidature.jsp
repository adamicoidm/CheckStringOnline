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
		<script type="text/javascript">
		const getCellValue = (tr, idx) => tr.children[idx].innerText || tr.children[idx].textContent;

		const comparer = (idx, asc) => (a, b) => ((v1, v2) => 
		    v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.toString().localeCompare(v2)
		    )(getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));

		// do the work...
		document.querySelectorAll('th').forEach(th => th.addEventListener('click', (() => {
		    const table = th.closest('table');
		    Array.from(table.querySelectorAll('tr:nth-child(n+2)'))
		        .sort(comparer(Array.from(th.parentNode.children).indexOf(th), this.asc = !this.asc))
		        .forEach(tr => table.appendChild(tr) );
		})));</script>
			<table>
				<tr>
					<th>NOME</th>
					<th>COGNOME</th>
					<th>TITOLO STUDIO</th>
					<th>LIVELLO ESPERIENZA</th>
					<th>VEDI CANDIDATURA</th>
					<th>STATO</th>
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
	
	 				table+="<option selected >"+lista_candidature.get(i).getStato()+"</option>";
	 					table+="<option value='Non interessante'>Non interessante</option>";
	 					table+="<option value='Da rivedere'>Da rivedere</option>";
	 					table+="<option value='Interessante'>Interessante</option>";
	 					table+="<option value='Inserito'>Inserito</option>";
					
	 				table+="</select></td>";
					table+="<td><input id='buttonCandidature'type='submit' value='Cambia Stato'></td></tr></form>";
					
		}
		out.println(table);
		%></table>
	</fieldset>
</body>
</html>