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
		<legend>Lista candidature accettate</legend>
		<form action="Logout" id="alignRightOBJ">
		<p>Sei connesso come ${ute.user}</p>
		<input type='submit' id='buttonFunction'value='Logout'>
		<br><br>
		<a href="PanelControl"><input type="button" id="buttonFunction" value="Home"></a>
		</form>
		<br><br><br>
		<br><br><br>
		<display:table name="ListaCandidature" pagesize="20">
		  <display:column property="id_candidatura" title="Id" sortable="true"/>
          <display:column property="nome" title="Nome" sortable="true"/>
          <display:column property="cognome" title="Cognome" sortable="true"/>
          <display:column property="email" title="Email" sortable="true"/>
          <display:column property="dataNascita" title="Data di nascita" sortable="true"/>
          <display:column property="numTelefono" title="Telefono" sortable="true"/>
          <display:column property="titoloStudio" title="Titolo di studio" sortable="true"/>
          <display:column property="livelloEsperienza" title="Esperienza" sortable="true"/>
          <display:column property="ultimaEsperienza" title="Ultima esperienza"/>
          <display:column property="stato" title="Stato"/>
        </display:table>
	</fieldset>
</body>
</html>