<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.Candidatura"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="java.util.List"%>
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
	<fieldset id="fieldsetTable">
		<legend>Lista nuove candidature</legend>
		<br>
		<a href="PanelControl"><input type="button" id="buttonHome" value="Torna alla Home"></a>
		<br><br><br>
		<br><br><br>
			<table id="MyP">
				<tr>
					<td>NOME</td>
					<td>COGNOME</td>
					<td>TITOLO STUDIO</td>
					<td>LIVELLO ESPERIENZA</td>
					<td>STATO</td>
					<td>VEDI CANDIDATURA</td>
				</tr>
	
		<% 
		Object obj= request.getAttribute("ListaCandidature");
		List<Candidatura> lista_candidature = (List<Candidatura>) obj;
		String table="";
		out.println(lista_candidature.size());
		for(int i=0;i<lista_candidature.size();i++){
			table+="<tr>";
				table+="<td>"+lista_candidature.get(i).getNome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getCognome()+"</td>";
				table+="<td>"+lista_candidature.get(i).getTitoloStudio()+"</td>";
				table+="<td>"+lista_candidature.get(i).getLivelloEsperienza()+"</td>";
				table+="<td>"+lista_candidature.get(i).isStato()+"</td>";
				table+="<td><input type='submit' name='"+lista_candidature.get(i).getId_candidatura()+"'value='Vedi Candidatura "+lista_candidature.get(i).getId_candidatura()+"'></td>";
			table+="</tr>";
			out.println(table);
		}
		%>
		</table>
		<display:table name="ListaCandidature" pagesize="20">
		  <display:column property="id_candidatura" title="Id" sortable="true"/>
          <display:column property="nome" title="Nome" sortable="true"/>
          <display:column property="cognome" title="Cognome" sortable="true"/>
          <display:column property="email" title="Email" sortable="true"/>
          <display:column property="dataNascita" title="Data di nascita" sortable="true"/>
          <display:column property="numTelefono" title="Telefono" sortable="true"/>
          <display:column property="titoloStudio" title="Titolo di studio" sortable="true"/>
          <display:column property="livelloEsperienza" title="Esperienza" sortable="true"/>
          <display:column property="competenze" title="Competenze"/>
          <display:column property="ultimaEsperienza" title="Ultima esperienza"/>
          <display:column ><form action="accettaCandidatura" method="get"> <input type="submit" name="idCandidatura" value="${ListaCandidature.get(0).id_candidatura}"/>Accetta Candidatura</form></display:column>
      </display:table>
	</fieldset>
</body>
</html>