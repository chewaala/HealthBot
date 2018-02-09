<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Study form</title>
</head>
<body>
	<h1>Add New Study</h1>
	<form method="POST" action="saveStudy">
		<table>
			<tr>
				<td>Study Description :</td>
				<td><input name="studyDesc" /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input name="startDate" type="datetime" /></td>
			</tr>
			<tr>
				<td>User Name :</td>
				<td><input name="endDate" type="datetime" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>

	<!-- User form -->
	<h1>Add New User</h1>
	<form method="POST" action="saveuser">
		<table>
			<tr>
				<td>Gender :</td>
				<td><input name="Gender" /></td>
			</tr>
			<tr>
				<td>Goals :</td>
				<td><input name="goals" /></td>
			</tr>
			<tr>
				<td>User Type :</td>
				<td><input name="userType" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="SaveUser" /></td>
			</tr>
		</table>
	</form>
	<h1>Select the User Type</h1>
	<form method="POST" action="saveuser">
		<input type="radio" name="researcher" value="Researcher"> Researcher<br>
		<input type="radio" name="practitioner" value="Practitioner"> Practitioner<br>
		<input type="radio" name="patient" value="Patient"> Patient
	</form>

</body>
</html>