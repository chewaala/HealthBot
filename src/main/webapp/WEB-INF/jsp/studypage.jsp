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
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<script type="text/javascript">
    function doAjaxPost() {
        $.ajax({
            type: "GET",
            url: "subView",
            success: function(response) {
                $("#subViewDiv").html( response );
            }
        });
    }
</script>


<script type="text/javascript">
    function getUserDetails() {
        $.ajax({
            type: "GET",
            url: "userDetailssubview", //this is controller method url
            success: function(response) {
                alert('abc');
                $("#userdetailsubdiv").html( response );
            }
        });
    }
</script>


<script type="text/javascript">
    function getSingleUserDetails() {
        $.ajax({
            type: "GET",
            url: "userDetailssubview" + "${study.tblUsers.userId}", //this is controller method url
            success: function(response) {
                alert('Hello');
                $("#userdetailsubdiv").html( response );
            }
        });
    }
</script>


<title>Study Page</title>
</head>
<style>
.lf-container {
	max-width: 600px;
	margin: 0 auto;
	margin-top: 50px;
}

.panel-heading a:after {
	font-family: 'Glyphicons Halflings';
	content: "\e114";
	float: right;
	color: grey;
}

.panel-heading a.collapsed:after {
	content: "\e080";
}

.box-custom-layout {
	border: 1px solid #cdcdcd;
	padding: 15px;
	border-radius: 4px;
}

/* Panel Styles  */
.panel-heading.collapsed .fa-chevron-down, .panel-heading .fa-chevron-right
	{
	display: none;
}

.panel-heading.collapsed .fa-chevron-right, .panel-heading .fa-chevron-down
	{
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
			<th>user id AJAX</th>
		</tr>
		<c:forEach var="study" items="${list}">
			<tr>
				<td>${study.studyId}</td>
				<td>${study.studyDesc}</td>
				<td>${study.startDate}</td>
				<td>${study.endDate}</td>
				<td>${study.tblUsers.userId}: <a id="userlink" href="users/${study.tblUsers.userId}">User Details</a></td>
			</tr>
		</c:forEach>
	</table>

	<h1>USER TABLE</h1>

<a id="ajaxsample" onclick="doAjaxPost();">ajax sample</a>
<div id="subViewDiv"></div>

<!-- <div id="userdetailsubdiv"></div>

 -->










	<table border="2" width="70%" cellpadding="2" class="usertable">
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

	<!-- <a href="studyform" class="btn btn-sm btn-primary">Create New Study</a> -->
	<a href="showstudyform" class="btn btn-sm btn-primary">Add study</a>


	<br>
	<h1>New Study table</h1>
<c:forEach var="study" items="${list}">
	<div class="lf-container container">
		<!-- Root accordian -->

		<div class="panel-group" id="accordionYear">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4 class="panel-title">
						<a class="panel-toggle" data-toggle="collapse"
							data-parent="#accordionYear" href="#collapseJune"> Study </a>
					</h4>
					
				</div>
					<center><h2>Study Description: ${study.studyDesc}</h2></center> 
					<h3>Study Details</h3>
					Study Id: ${study.studyId} <div align="justify">Start Date: ${study.startDate}</div> <div align="justify"> End Date: ${study.endDate}</div>
				<br>
				<a href="userDetailssubview/${study.tblUsers.userId}">User id: ${study.tblUsers.userId}</a>
				
				<a id="userdetails" onclick="getUserDetails();" >User details</a>
				<br>
				<div id="userdetailsubdiv"></div>
				<!-- Here we insert another nested accordion -->
				<div id="collapseJune" class="panel-body collapse">
					<div class="panel-inner">


						<div class="panel-group" id="accordionJune">
							<div class="panel panel-info">

								<div class="panel-heading">
									<h4 class="panel-title" id="${user.userId}">
										<a class="panel-toggle" data-toggle="collapse"
											data-parent="#accordionJune" href="#collapseDay"> User Id : ${study.tblUsers.userId} </a>
									</h4>
								</div>

								<!-- Here we insert another nested accordion -->
								<div id="collapseDay" class="panel-body collapse">
									<div class="panel-inner">

										<div class="panel-group" id="accordionJune">
											<div class="panel panel-default">

												<div class="panel-heading">
													<h4 class="panel-title">
														<a class="panel-toggle" data-toggle="collapse"
															data-parent="#accordionDay" href="#collapseForm"> 2nd
															(Monday) </a>
													</h4>
												</div>

												<div id="collapseForm" class="panel-body collapse">
													<div class="panel-inner">

														<form action="">
															<div class="row">
																<div class="col-sm-12">
																	<h4>Step 1:</h4>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-12">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"> <input
																				type="checkbox">
																			</span>
																			<p class="form-control">Long description text
																				text text text text text text text text text text
																				text text text text...</p>
																		</div>
																	</div>
																</div>
															</div>
														</form>

													</div>
												</div>

											</div>
										</div>

									</div>
								</div>
								<!-- Inner accordion ends here -->

							</div>
						</div>

					</div>
				</div>
				<!-- Inner accordion ends here -->

			</div>
		</div>
		<!-- Root accordian ends here -->

	</div>
	<!-- /lf-container -->

</c:forEach>




</body>
</html>