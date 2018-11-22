<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Medi-Track | Hospital</title>


<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />

<!--     Fonts and icons     -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/material-kit.css" rel="stylesheet" />
<script src="assets/js/jquery.min.js">
	
</script>
</head>

<body class="signup-page">



	<div class="main main-raised">

		<div class="section section-full-screen section-signup"
			style="background-image: url('../assets/img/city.png'); background-size: cover; background-position: top center; min-height: 700px;">
			<div class="container" style="margin-top: 50px;">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="card card-signup">
							<form class="form" method="post" action="/hospital/select">
								<div class="header header-primary text-center">
									<h4>Medi-Track</h4>
								</div>
								<div class="content" style="margin: 50px 30px;">
									<h3>Select Hospital</h3>
									<c:forEach items="${hospitals }" var="hospital">
										<div class="form-check">
											<input class="form-check-input" type="radio"
												name="radiohospital" id="radiohospital"
												value="${hospital.hospitalID }"> <label
												class="form-check-label" for="exampleRadios1"> <c:out
													value="${ hospital.hospitalName }" />
											</label>
										</div>
									</c:forEach>
								</div>
								<div class="footer text-center">
									<input type="submit" class="btn btn-primary" name="btnlogin"
										value="Login"> <br>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
<!--   Core JS Files   -->
<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="assets/js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="assets/js/material-kit.js" type="text/javascript"></script>

</html>