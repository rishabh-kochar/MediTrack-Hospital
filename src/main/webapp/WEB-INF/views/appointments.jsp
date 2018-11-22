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
						<h3 class="title" style="text-align: center">
							Appointments <a href="/hospital/addapp"><button type="button"
									name="btnapprove" value="Dispatch Event"
									class="btn btn-primary"
									style="float: right; background-color: #46b8da; border-radius: 10px; margin-top: 1px;">Add
									Appointment</button></a>
						</h3>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<div class="card-content table-responsive">
						<table class="table table-hover" id="dataTable">
							<thead>
								<th>Appoitment ID</th>
								<th>Patient</th>

								<th>Doctor</th>
								<th>Date-Time</th>

								<th>Status</th>

								<th>Illness</th>
								<th></th>
							</thead>
							<tbody>

								<c:forEach items="${AppointmentList}" var="app">
									<tr>
										<td>${app.appointmentId}</td>
										<td>${app.patientId.patientName}</td>
										<td>${app.doctorHospitalId.doctorID.doctorName}</td>
										<td>${app.appointmentDateTime}</td>
										<c:if test="${ app.appointmentStatus == 0 }">
											<td>Pending</td>
										</c:if>
										<c:if test="${ app.appointmentStatus == 1 }">
											<td>Approved</td>
										</c:if>
										<td>${app.illness}</td>
										<td><c:if test="${ app.appointmentStatus == 0 }">
												<a href="/hospital/approveapp?id=${ app.appointmentId}"><button
														type="button" name="btnview" value="View Event"
														class="btn btn-success"
														style="border-radius: 10px; margin-top: 1px;">Approve</button></a>
											</c:if> <c:if test="${ app.appointmentStatus == 1 }">
												<a href="/hospital/deleteapp?id=${ app.appointmentId}"><button
														type="button" name="btnview" value="View Event"
														class="btn btn-danger"
														style="border-radius: 10px; margin-top: 1px;">Delete</button></a>
											</c:if> <a href="#"><button type="button" name="btnapprove"
													value="Dispatch Event" class="btn btn-warning"
													style="border-radius: 10px; margin-top: 1px;">Generate
													Bill</button></a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<%@ include file="../common/footer.jspf"%>