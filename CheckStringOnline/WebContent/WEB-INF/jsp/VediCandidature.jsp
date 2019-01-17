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
<script type="text/javascript">

var TableIDvalue = "indextable";

var TableLastSortedColumn = -1;
function SortTable() {
var sortColumn = parseInt(arguments[0]);
var type = arguments.length > 1 ? arguments[1] : 'T';
var dateformat = arguments.length > 2 ? arguments[2] : '';
var table = document.getElementById(TableIDvalue);
var tbody = table.getElementsByTagName("tbody")[0];
var rows = tbody.getElementsByTagName("tr");
var arrayOfRows = new Array();
type = type.toUpperCase();
dateformat = dateformat.toLowerCase();
for(var i=0, len=rows.length; i<len; i++) {
	arrayOfRows[i] = new Object;
	arrayOfRows[i].oldIndex = i;
	var celltext = rows[i].getElementsByTagName("td")[sortColumn].innerHTML.replace(/<[^>]*>/g,"");
	if( type=='D' ) { arrayOfRows[i].value = GetDateSortingKey(dateformat,celltext); }
	else {
		var re = type=="N" ? /[^\.\-\+\d]/g : /[^a-zA-Z0-9]/g;
		arrayOfRows[i].value = celltext.replace(re,"").substr(0,25).toLowerCase();
		}
	}
if (sortColumn == TableLastSortedColumn) { arrayOfRows.reverse(); }
else {
	TableLastSortedColumn = sortColumn;
	switch(type) {
		case "N" : arrayOfRows.sort(CompareRowOfNumbers); break;
		case "D" : arrayOfRows.sort(CompareRowOfNumbers); break;
		default  : arrayOfRows.sort(CompareRowOfText);
		}
	}
var newTableBody = document.createElement("tbody");
for(var i=0, len=arrayOfRows.length; i<len; i++) {
	newTableBody.appendChild(rows[arrayOfRows[i].oldIndex].cloneNode(true));
	}
table.replaceChild(newTableBody,tbody);
} // function SortTable()

function CompareRowOfText(a,b) {
var aval = a.value;
var bval = b.value;
return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
} // function CompareRowOfText()

function CompareRowOfNumbers(a,b) {
var aval = /\d/.test(a.value) ? parseFloat(a.value) : 0;
var bval = /\d/.test(b.value) ? parseFloat(b.value) : 0;
return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
} // function CompareRowOfNumbers()

function GetDateSortingKey(format,text) {
if( format.length < 1 ) { return ""; }
format = format.toLowerCase();
text = text.toLowerCase();
text = text.replace(/^[^a-z0-9]*/,"");
text = text.replace(/[^a-z0-9]*$/,"");
if( text.length < 1 ) { return ""; }
text = text.replace(/[^a-z0-9]+/g,",");
var date = text.split(",");
if( date.length < 3 ) { return ""; }
var d=0, m=0, y=0;
for( var i=0; i<3; i++ ) {
	var ts = format.substr(i,1);
	if( ts == "d" ) { d = date[i]; }
	else if( ts == "m" ) { m = date[i]; }
	else if( ts == "y" ) { y = date[i]; }
	}
d = d.replace(/^0/,"");
if( d < 10 ) { d = "0" + d; }
if( /[a-z]/.test(m) ) {
	m = m.substr(0,3);
	switch(m) {
		case "jan" : m = String(1); break;
		case "feb" : m = String(2); break;
		case "mar" : m = String(3); break;
		case "apr" : m = String(4); break;
		case "may" : m = String(5); break;
		case "jun" : m = String(6); break;
		case "jul" : m = String(7); break;
		case "aug" : m = String(8); break;
		case "sep" : m = String(9); break;
		case "oct" : m = String(10); break;
		case "nov" : m = String(11); break;
		case "dec" : m = String(12); break;
		default    : m = String(0);
		}
	}
m = m.replace(/^0/,"");
if( m < 10 ) { m = "0" + m; }
y = parseInt(y);
if( y < 100 ) { y = parseInt(y) + 2000; }
return "" + String(y) + "" + String(m) + "" + String(d) + "";
} // function GetDateSortingKey()
</script>


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
			<table id="indextable">
			<thead>
				<tr>
					<th><a href="javascript:SortTable(0,'T');">NOME</a></th>
					<th><a href="javascript:SortTable(1,'T');">COGNOME</a></th>
					<th><a href="javascript:SortTable(2,'T');">TITOLO STUDIO</a></th>
					<th><a href="javascript:SortTable(3,'T');">LIVELLO ESPERIENZA</a></th>
					<th>VEDI CANDIDATURA</th>
					<th><a href="javascript:SortTable(5,'T');">STATO</a></th>
					<th>CONFERMA MODIFICA</th>
				</tr>
</thead><tbody>
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
		%></tbody></table>
		<script type="text/javascript">

    
            </script>
	</fieldset>
</body>
</html>