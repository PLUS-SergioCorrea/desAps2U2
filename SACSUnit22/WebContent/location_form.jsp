<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Form</title>
</head>
<body>
	<form action="LocationController">
		<label>Iteration:</label><br>
		<input type = "number" name= "iteration" value = "${location.iteration}" /><br>
		
		<label>Creation Date:</label><br>
		<input type = "text" name= "creDate" value = "${location.creDate}" /><br>
		
		<label>Mod. Date:</label><br>
		<input type = "text" name= "modDate" value = "${location.modDate}" /><br>
		
		<label>Username:</label><br>
		<input type = "text" name= "username" value = "${location.username}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>