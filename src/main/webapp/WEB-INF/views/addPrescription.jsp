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
						<h2 class="title" style="text-align: center">Add Prescription</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<p style="text-align: center; color: red; font-size: 25px;">${errorMessage }</p>
					<div class="card-content">
						<form action="/hospital/addprescription" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Appointment ID</label> <input
											type="text" name="txtappointmentid" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Medicine</label> <select
											class="form-control" name="drpMedicine" style="float: left;"
											required>
											<option value="0">Select Medicine</option>
											<c:forEach items="${medicineData }" var="val">
												<option value="${val.medicineId }"
													${val.medicineId == PrescriptionData.medicineId.medicineId ? 'selected' : ''}>${val.medicineName }</option>
											</c:forEach>

										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Quantity</label> <input
											type="text" value="${PrescriptionData.quantity }"
											name="txtqty" class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Morning</label> <input
											type="time" value="${PrescriptionData.morning }"
											name="txtmorning" class="form-control" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">AfterNoon</label> <input
											type="time" value="${PrescriptionData.afternoon }"
											name="txtafternoon" class="form-control" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Evening</label> <input
											type="time" value="${PrescriptionData.evening }"
											name="txtevening" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Start Date</label> <input
											type="date" value="${PrescriptionData.startDate }"
											name="txtstartdate" class="form-control" required />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">End Date</label> <input
											type="date" value="${PrescriptionData.endDate }"
											name="txtenddate" class="form-control" required />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Frequency</label> <input
											type="text" value="${PrescriptionData.frequency }"
											name="txtfrequency" class="form-control" required />
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