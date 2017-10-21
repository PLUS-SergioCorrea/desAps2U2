<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Form</title>
</head>
<body>
	<form action="PasswordController">
		<label>Password:</label><br>
		<input type = "text" name= "password" value = "${password.password}" /><br>
		
		<label>TIme stamp:</label><br>
		<input type = "text" name= "timStamp" value = "${password.timStamp}" /><br>
		
		<label>Username:</label><br>
		<input type = "text" name= "username" value = "${password.username}" /><br>
		
		<label>Mail:</label><br>
		<input type = "text" name= "usermail" value = "${password.usermail}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>