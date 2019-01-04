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
<%@ include file="/style.css" %>
</style>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista competenze</title>
</head>
<body>
	<fieldset id="fieldsetTable">
		<legend>Competenze</legend>
		<br> <a href="PanelControl"><input type="button"
			id="buttonHome" value="Torna alla Home"></a> <br>
		<br>
		<br> <br>
		<br>
		<br>
		<display:table name="ListaCompetenze" pagesize="20">
			<display:column property="nomeCompetenza" title="Nome Competenza" sortable="true" />
		</display:table>
		
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