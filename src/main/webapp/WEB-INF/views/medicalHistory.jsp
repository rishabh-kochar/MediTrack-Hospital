<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/docnavigation.jspf"%>
<%@ include file="../common/docheader.jspf"%>
<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<c:if test="${flag == true }">
			<div class="row">
				<form action="/hospital/patienthistory" method="GET">
					<div class="row">
						<div class="col-md-6 col-md-offset-2">
							<div class="form-group label-floating">
								<label class="control-label">Patient ID</label> <input
									type="text" name="id" class="form-control" required />
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group label-floating">
								<input type="submit" value="Add" class="btn btn-primary">
							</div>
						</div>
					</div>
				</form>
			</div>
		</c:if>
		<c:if test="${flag == false }">
			<div class="row text-center">
				<span><b>Name : </b>${patientData.patientName }</span> <br> <span><b>Date of
						Birth : </b>${patientData.dateOfBirth }</span>
			</div>

			<div class="row" style="margin-top: 50px;">

				<div class="timeline-centered">
					<c:forEach items="${symptomsData }" var="val">
						<article class="timeline-entry">
							<div class="timeline-entry-inner">
								<div class="timeline-icon bg-success">
									<i class="entypo-feather"></i>
								</div>
								<div class="timeline-label">
									<h2>
										<a href="#">${val.appoitmentID.appointmentDateTime } </a>
									</h2>
									<p><b>Symptoms : </b>${val.symptoms }</p>
									<p><b>Abstain From : </b>${val.abstainFrom }</p>
									<p><b>Recommended : </b>${val.recommended }</p>
									<p><b>Notes : </b>${val.notes }</p>
								</div>
							</div>
						</article>
					</c:forEach>
					<article class="timeline-entry begin">

						<div class="timeline-entry-inner">

							<div class="timeline-icon"
								style="-webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg);">
								<i class="entypo-flight"></i> +
							</div>

						</div>

					</article>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>