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
	<form action="savestudyform">
		<table>
			<tr>
				<td>Study Title :</td>
				<td><input name="studyDesc" /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input name="startDate" type="date" placeholder="dd-mm-yyyy"/></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input name="endDate" type="date" placeholder="dd-mm-yyyy"/></td>
			</tr>
			<tr>
				<td>Goals :</td>
				<td><input name="goals" type="text" /></td>
			</tr>
			<tr>
				<td>User name :</td>
				<td><input name="username"/></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="male"> Male<br>
  					<input type="radio" name="gender" value="female"> Female<br>
  					<input type="radio" name="gender" value="other"> Other
  				</td>
			</tr>
			<tr>
				<td>User Type</td>
				<td><input type="radio" name="usertype" value="Researcher"> Researcher<br>
					<input type="radio" name="usertype"	value="Practitioner"> Practitioner<br>
					<input type="radio" name="usertype" value="Patient"> Patient
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>

	</form>
</body>
</html>