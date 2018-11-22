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
						<h2 class="title" style="text-align: center;">Book
							Appointment</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="/hospital/addapp" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Patient ID</label> <input
											type="text" name="txtpatientid" class="form-control" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Doctor</label> <select
											class="form-control" name="drpdoctor" style="float: left;"
											required>
											<option>Select Hospital Type</option>
											<c:forEach items="${doctorType}" var="val">
												<option value="${val.doctorID}"><c:out
														value="${val.doctorName}"></c:out></option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Date and Time</label> <input
											type="date" name="txtappointmentdate"
											class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Illness</label> <input
											type="text" name="txtillness" class="form-control" required />
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