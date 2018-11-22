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
							Doctors <a href="/hospital/adddoctor"><button type="button"
									name="btnapprove" value="Dispatch Event"
									class="btn btn-primary"
									style="float: right; background-color: #46b8da; border-radius: 10px; margin-top: 1px;">Insert
									Doctor</button></a>
						</h3>

						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<div class="card-content table-responsive">
						<table class="table table-hover" id="dataTable">
							<thead>
								<th>Doctor Name</th>
								<th>Designation</th>
								<th>Specialization</th>
								<th>Contact Number</th>
								<th>Address</th>
								<th></th>
							</thead>
							<tbody>

								<c:forEach items="${doctors}" var="doctor">
									<tr>
										<td>${doctor.doctorName}</td>
										<td>${doctor.doctorDesignation}</td>
										<td>${doctor.doctorSpecialization}</td>
										<td>${doctor.doctorContact}</td>
										<td>${doctor.doctorAddress}</td>
										<td><a href="/hospital/registerdoctor?id=${doctor.doctorID }"><button
													type="button" name="btnview" value="View Event"
													class="btn btn-info"
													style="border-radius: 10px; margin-top: 1px;">Register</button></a>
										</td>

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