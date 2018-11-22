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
						<h2 class="title">
							<center>Add Doctor</center>
						</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="/hospital/adddoctor" method="POST">
							<input type="hidden" name="doctorID" id="doctorID" value="${doctorID }">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Doctor Name</label> <input
											type="text" name="txtdoctorname" class="form-control"
											value="${doctorData.doctorName }" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Username</label> <input
											value="${doctorData.doctorUsername }" type="text" name="txtusername" class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Password</label> <input
											value="${doctorData.doctorPassword }" type="password" name="txtpassword" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Designation</label> <input
											value="${doctorData.doctorDesignation }" type="text" name="txtdesignation" class="form-control"
											required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Specialization</label> <input
											value="${doctorData.doctorSpecialization }" type="text" name="txtspecialization" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact Number</label> <input
											value="${doctorData.doctorContact }" type="text" name="txtcontactno" class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Address</label> <input
											value="${doctorData.doctorAddress }" type="text" name="txtaddress" class="form-control" required />
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