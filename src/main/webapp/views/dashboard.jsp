<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome ${stud.userid} to Student Portal</h1>
	<h3>This is your dashboard</h3>
	<br>
	<div>Student List: ${studList}</div>
	<br>
	<div><a href="deleteAllStudents">Click here to delete all student data</a></div>
	<br>
	<div>Deletion Status: ${deletionState}</div>
	<br>
	<a href="logout">Click here to logout</a><br>
</body>
</html>