<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/docnavigation.jspf"%>
<%@ include file="../common/docheader.jspf"%>
<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<c:forEach items="${appointmentData }" var="val">
			<div class="row col-md-12">
				<div class="media-body" >
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">${val.patientId.patientName }</h4>
						<ul class="media-date text-uppercase reviews list-inline">
							<%-- <li class="dd">${val.appointmentDateTime }</li> --%>

						</ul>
						<p class="media-comment">${val.illness }</p>
						<a class="btn btn-info btn-circle text-uppercase"
							href="/hospital/handleapp?id=${val.appointmentId }" id="reply"><span
							class="glyphicon glyphicon-share-alt"></span> Handle Appointment</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>