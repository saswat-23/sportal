<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Portal</title>
</head>
<body>
	<h1>Welcome to Student Portal!</h1>
	<form action="setUser">
		<label for="userid">User Id: </label>
		<input id="userid" name="userid" type="text" required="required">
		<input type="submit" value="Go to Dashboard">
	</form>
	<br>
</body>
</html>