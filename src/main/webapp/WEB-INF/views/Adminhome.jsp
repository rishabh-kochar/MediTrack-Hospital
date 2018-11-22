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
						<h2 class="title" style="font-size: 20px;">
							<center>Hospital Profile Update</center>
						</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="#" method="POST">
						<input type="hidden" value="${HospitalData.hospitalID }" name="txthospitalID">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact Number</label> <input
											type="text" name="txtcontactno"
											value="${HospitalData.hospitalContactNo }"
											class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Email ID</label> <input
											type="email" name="txtemailid"
											value="${HospitalData.hospitalEmailID }"
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Location URL</label> <input
											type="text" name="txtlocationurl" class="form-control"
											value="${HospitalData.hospitalLocationURL }" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Website URL</label> <input
											type="text" name="txtebsiteurl" class="form-control"
											value="${HospitalData.hospitalWebsiteURL }" required />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Opening Time</label> <input
											type="time" name="txtopeningtime" class="form-control"
											value="${HospitalData.openingTime }" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Closing Time</label> <input
											type="time" name="txtclosingtime" class="form-control"
											value="${HospitalData.closingTime }" required />
									</div>
								</div>
							</div>

							<input type="submit" value="Update"
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