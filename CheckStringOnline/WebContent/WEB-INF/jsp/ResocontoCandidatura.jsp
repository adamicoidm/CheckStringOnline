<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="DAO.Candidatura"%>
  <%@page import="DAO.Candidatura2Competenze" %>
  <%@page import="java.util.ArrayList"%>
  <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/style.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Candidatura</title>
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
    <legend>Candidatura</legend>
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
		<th>CAMPO</th>
		<th>DATI</th>
	</tr>
	<tr>
		<td>Nome</td>
		<td>${ListaCandidature.get(0).getNome()}</td>
	</tr>
	<tr>
		<td>Cognome</td>
		<td>${ListaCandidature.get(0).getCognome()}</td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td>${ListaCandidature.get(0).getEmail()}</td>
	</tr>
	<tr>
		<td>Data di nascita</td>
		<td>${ListaCandidature.get(0).getDataNascita()}</td>
	<tr>
		<td>Numero di telefono</td>	
		<td>${ListaCandidature.get(0).getNumTelefono()}</td>
	</tr>
		<tr>
		<td>Titolo di Studio</td>	
		<td>${ListaCandidature.get(0).getTitoloStudio()}</td>
	</tr>
	<tr>
		<td>Livello di esperienza</td>
		<td>${ListaCandidature.get(0).getLivelloEsperienza()}</td>
	</tr>

	<tr>
		<td>Ultima esperienza</td>
		<td>${ListaCandidature.get(0).getUltimaEsperienza()}</td>
	</tr>
		<tr>
		<td>Competenze</td>
		<td>	<% 
		Object obj= request.getAttribute("listaCompetenze");
		List<Candidatura2Competenze> lista_competenze = new ArrayList<Candidatura2Competenze>();
		lista_competenze= (List<Candidatura2Competenze>) obj;
		String table="";
		for(int i=0;i<lista_competenze.size();i++){
				table+=lista_competenze.get(i).getNomeCompetenza()+" <br> ";
		}
		out.println(table);
		%>
		</td>
	</tr>
		<tr>
		<td>Cambia stato</td>
		<td><br>
		<% 	Object object= request.getAttribute("ListaCandidature");
	
		List<Candidatura> ListaCandidature = new ArrayList<Candidatura>();
		ListaCandidature=(ArrayList<Candidatura>) object;
		System.out.println(ListaCandidature);
			table="";
						table="<form action='CambiaStato' method='get'>";
							table+="<input type='hidden'name='id_candidatura' value='"+lista_competenze.get(0).getId_candidatura()+"'>";
							table+="<select name='stato'>";
			 				table+="<option selected >"+ListaCandidature.get(0).getStato()+"</option>";
			 					table+="<option value='Non interessante'>Non interessante</option>";
			 					table+="<option value='Da rivedere'>Da rivedere</option>";
			 					table+="<option value='Interessante'>Interessante</option>";
			 					table+="<option value='Inserito'>Inserito</option> <br>";
			 					table+="</select><input type='submit' value='Cambia Stato'>";
			 			table+="</form>";
			out.println(table);
			%>
			</td>
		</tr> 
	</table>
<form action="VediCandidature">
	<input type="submit" value="back">
</form>

</fieldset>
</body>
</html>