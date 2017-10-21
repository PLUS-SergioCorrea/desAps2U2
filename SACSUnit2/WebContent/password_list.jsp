<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="PasswordController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Password</th>
			 <th>Time stamp</th>
			 <th>Username</th>
			 <th>User mail</th>
			
		</tr>
		<c:forEach var="password" items="${passwords}">
		
		<tr>
			<td>
				<form action= "PasswordController">
					<input type = "hidden" name = "id" value= "${password.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${password.id}</td>
			<td> ${password.password}</td>
			<td> ${password.timStamp}</td>
			<td> ${password.username}</td>
			<td> ${password.usermail}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>