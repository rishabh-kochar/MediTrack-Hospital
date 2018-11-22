<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../common/docnavigation.jspf"%>
<%@ include file="../common/docheader.jspf"%>

<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h2 class="title" style="text-align: center">Add Patient Symptoms</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="/hospital/handleapp" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Appointment ID</label> <input
											type="text" value="${appointmentID }" name="txtappointmentid" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Symptoms</label> <input
											type="text" name="txtsymptoms"
											
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Notes</label> <input type="text"
											name="txtnotes"
											
											class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Abstain From</label> <input
											type="text" name="txtabstain" class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Recommended</label> <input
											type="text" name="txtrecommened" class="form-control"
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