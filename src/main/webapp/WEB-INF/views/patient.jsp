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
						<h3 class="title" style="text-align: center;">
							Patients <a href="/hospital/addpatient"><button type="button"
									name="btnapprove" value="Dispatch Event"
									class="btn btn-primary"
									style="float: right; background-color: #46b8da; border-radius: 10px; margin-top: 1px;">Add
									Patient</button></a>
						</h3>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<div class="card-content table-responsive">
						<table class="table table-hover" id="dataTable">
							<thead>
								<th>Patient ID</th>
								<th>Name</th>
								<th>Gender</th>
								<th>Address</th>
								<th>Email</th>
								<th>Date of Birth</th>
								<th>Contact Number</th>

								<th></th>
							</thead>
							<tbody>

								<c:forEach items="${patients}" var="patient">
									<tr>
										<td>${patient.patientID}</td>
										<td>${patient.patientName}</td>
										<td>${patient.gender}</td>
										<td>${patient.address}</td>
										<td>${patient.email}</td>
										<td>${patient.dateOfBirth}</td>
										<td>${patient.contact}</td>

										<td></td>
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