<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	<%@include file="/style.css" %>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<fieldset id="fieldset">
		<legend>Login</legend>
		<br><br><br>
		<br><br><br>
		<br><br><br>
		<br><br><br>
		<br><br><br>
		<form action="Login" method="get" id="Login" >
			User:<br> 
			<input type="text" name="user" placeholder="Inserire user" autofocus ><br>
			Password:<br> 
			<input type="password" name="password" placeholder="Inserire la password"><br>
			<br>
			<input id="buttonSubmit" type="submit" value="Login">
		</form>
	</fieldset>
</body>
</html>