<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png" />
<link rel="icon" type="image/png" href="../assets/img/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Medi-Track | Hospital Registration</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<!--  Material Dashboard CSS    -->
<link href="assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/demo.css" rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>

<script src="assets/js/jquery.min.js">
	<link href="pagination/demo/Content/bootstrap.min.css" rel="stylesheet">
	<link href="pagination/demo/css/jquery.dataTables_themeroller.css" rel="stylesheet">
</script>

<style>
.main-panel {
	float: none;
	width: 100%;
}

.logoname {
	float: left;
	text-align: center;
	color: #8e24aa;
	margin-top: -10px;
}

.successmessage {
	color: green;
	font-size: 25px;
	text-align: center;
	margin-top: 25px;
}
</style>

</head>

<body>

	<div class="wrapper">

		<div class="main-panel">
			<div id="headerclass">
				<nav class="navbar navbar-transparent navbar-absolute">
					<div class="container-fluid">

						<div class="collapse navbar-collapse">
							<div class="logoname">
								<h2>Medi Track</h2>
							</div>
						</div>
					</div>
				</nav>
			</div>
			<div class="content" style="padding: 0; margin-top: 75px;">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header" data-background-color="purple">
									<h2 class="title" style="font-size: 20px; text-align: center">
										Hospital Registration</h2>

								</div>
								<c:if test="${not empty message }">
									<p class="successmessage">
										Requested to the Adminstrator for approval. <a
											href="/hospital/login"> Login </a>
									</p>
								</c:if>
								<br>
								<div class="card-content">
									<form action="/hospital/register" method="POST">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group label-floating">
													<label class="control-label">Hospital Name</label> <input
														type="text" name="txthospitalname" class="form-control"
														required />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group label-floating">
													<label class="control-label">Address</label> <input
														type="text" name="txtaddress" class="form-control"
														required />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Hospital Type</label> <select
														class="form-control" name="dropdownhospitaltype"
														style="float: left;" required>
														<option>Select Hospital Type</option>
														<c:forEach items="${hospitalType}" var="val">
															<option value="${val.hospitalTypeID}"><c:out
																	value="${val.hospitalType}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Registration Number</label> <input
														type="text" name="txtregistrationno" class="form-control"
														required />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Contact Number</label> <input
														type="text" name="txtcontactno" class="form-control"
														required />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Email ID</label> <input
														type="email" name="txtemailid" class="form-control"
														required />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Location URL</label> <input
														type="text" name="txtlocationurl" class="form-control"
														required />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Website URL</label> <input
														type="text" name="txtebsiteurl" class="form-control"
														required />
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Opening Time</label> <input
														type="time" name="txtopeningtime" class="form-control"
														required />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group label-floating">
													<label class="control-label">Closing Time</label> <input
														type="time" name="txtclosingtime" class="form-control"
														required />
												</div>
											</div>
										</div>



										<input type="submit" value="Register"
											class="btn btn-primary pull-right">

										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>


</body>
<script src="assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/material.min.js" type="text/javascript"></script>
<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>
<!--  Dynamic Elements plugin -->
<script src="assets/js/arrive.min.js"></script>
<!--  PerfectScrollbar Library -->
<script src="assets/js/perfect-scrollbar.jquery.min.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Material Dashboard javascript methods -->
<script src="assets/js/material-dashboard.js?v=1.2.0"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

<script src="pagination/demo/Scripts/bootstrap.min.js"></script>
<script src='pagination/demo/js/jquery.dataTables.min.js'></script>


</html>
