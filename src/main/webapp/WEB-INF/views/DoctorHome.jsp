<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../common/docnavigation.jspf"%>
<%@ include file="../common/docheader.jspf"%>
<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Profile</h4>
						<p class="category">Complete your profile</p>
					</div>
					<div class="card-content">
						<form method="post" action="/hospital/doctorhome">
							<div class="row">

								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Name</label> <input type="text"
											name="txtdoctorname" class="form-control" value="${doctorData.doctorName }">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Password</label> <input
											type="password" class="form-control" name="txtpassword"
											value="${doctorData.doctorPassword }">
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Designation</label> <input
											type="text" class="form-control" name="txtdesignation"
											value="${doctorData.doctorDesignation }">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Specialization</label> <input
											type="text" class="form-control" name="txtspecialization"
											value="${doctorData.doctorSpecialization }">
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact No.</label> <input
											type="text" class="form-control" name="txtcontact"
											value="${doctorData.doctorContact }">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Address</label> <input
											type="text" class="form-control" name="txtaddress"
											value="${doctorData.doctorAddress }">
									</div>
								</div>
							</div>


							<button type="submit" class="btn btn-primary pull-right">Update
								Profile</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-profile">

					<div class="content">
						<h6 class="category text-gray">Doctor</h6>
						<h4 class="card-title">${ doctorData.doctorName }</h4>
						<p class="card-content">${ doctorData.doctorAddress }</p>
						<p class="card-content">${ doctorData.doctorContact }</p>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>