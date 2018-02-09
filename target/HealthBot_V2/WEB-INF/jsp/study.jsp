<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<title>Study</title>
</head>
<style>

.box-custom-layout{
	    border: 1px solid #cdcdcd;
    padding: 15px;
    border-radius: 4px;
}

/* Panel Styles  */
.panel-heading.collapsed .fa-chevron-down,
.panel-heading .fa-chevron-right {
  display: none;
}

.panel-heading.collapsed .fa-chevron-right,
.panel-heading .fa-chevron-down {
  display: inline-block;
}

i.fa {
  cursor: pointer;
  margin-right: 5px;
}

.collapsed ~ .panel-body {
  padding: 0;
}

</style>
<body>
	<table border="2" width="70%" cellpadding="2" class="table">
		<tr>
			<th>Study ID</th>
			<th>Study Description</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>User Id</th>
		</tr>
		<c:forEach var="study" items="${list}">
			<tr>
				<td>${study.studyId}</td>
				<td>${study.studyDesc}</td>
				<td>${study.startDate}</td>
				<td>${study.endDate}</td>
				<td>${study.tblUsers.userId} : <a href="users/${study.tblUsers.userId}">Get user Details</a></td>
			</tr>
		</c:forEach>
	</table> 
	
	<h1>USER TABLE</h1>
	
	<table border="2" width="70%" cellpadding="2" class="table">
		<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Gender</th>
			<th>User Id</th>
			<th>User Module Id</th>
			<th>User Module Id Survey</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.gender}</td>
				<td>${user.goals}</td>
				<td>${user.tblUserType.userTypeId}</td>
				<td>${user.tblUserModuleses.userModuleId}</td>
				<td>${user.tblUserModuleSurveys.userModuleSurveyId}</td>
				<td>${user.tblModuleses.moduleId}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<a href="studyform" class="btn btn-sm btn-primary">Add study</a>
	
	
	
	
	
	<br>
	<h1>Study table</h1>	
	
	<!-- New modified table -->
	<div>
		<c:forEach var="study" items="${list}">
		<div class="col-sm-8 col-sm-offset-2 box-custom-layout">
			<div class="row">
				<div class="col-sm-3" ><b>Study ID </b></div>
				<div class="col-sm-3">${study.studyId}</div>
				<div class="col-sm-3"><b>Study Description  </b></div>
				<div class="col-sm-3">${study.studyDesc}</div>
			</div>
			<div class="row">
				<div class="col-sm-3"><b>Start Date</b></div>
				<div class="col-sm-3">${study.startDate}</div>
				<div class="col-sm-3"><b>End Date</b></div>
				<div class="col-sm-3">${study.endDate}</div>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-2 ">
			<div class="row">
				<%-- <label>User Id</label>
				<td>${study.tblUsers.userId}</td>
				<th>Edit / delete</label>  
				<td>
					<a href="editstudy/${study.studyId}" class="btn btn-sm btn-primary">Edit</a>
					<a href="deletestudy/${study.studyId}" class="btn btn-sm btn-danger">Delete</a>
				</td> --%>
			</div>
		</div>
		</c:forEach>
	</div>
	
	
</body>
</html>