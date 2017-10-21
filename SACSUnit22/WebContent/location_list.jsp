<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="LocationController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Iteration</th>
			 <th>Creation Date</th>
			 <th>Mod. Date</th>
			 <th>Username</th>
			
		</tr>
		<c:forEach var="location" items="${locations}">
		
		<tr>
			<td>
				<form action= "LocationController">
					<input type = "hidden" name = "id" value= "${location.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${location.id}</td>
			<td> ${location.iteration}</td>
			<td> ${location.creDate}</td>
			<td> ${location.modDate}</td>
			<td> ${location.username}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>