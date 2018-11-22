<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../common/navigation.jspf"%>
<%@ include file="../common/header.jspf"%>
<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h2 class="title" style="text-align: center;">Add Patient</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="/hospital/addpatient" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Patient Name</label> <input
											type="text" name="PatientName"
											onblur="return allLetter(txtModelNumber);"
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Username</label> <input
											type="text" name="username"
											onblur="return allLetter(txtModelNumber);"
											class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Date of Birth</label> <input
											type="date" name="date_of_birth"
											onblur="return allLetter(txtPicture);" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Address</label> <input
											type="text" name="address"
											onblur="return allLetter(txtOperatingSystem);"
											class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact Number</label> <input
											type="text" name="contact" onblur="return allLetter(txtRAM);"
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Gender</label> <input type="text"
											name="gender" onblur="return allLetter(txtCamera);"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Email ID</label> <input
											type="text" name="email"
											onblur="return allLetter(txtProcessor);" class="form-control"
											required />
									</div>
								</div>
							</div>

							<input type="submit" value="Add"
								class="btn btn-primary pull-right">


							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<%@ include file="../common/footer.jspf"%>