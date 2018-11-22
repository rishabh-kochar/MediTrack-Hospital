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
							Administrators <a href="/hospital/addadmin"><button
									type="button" name="btnapprove" value="Dispatch Event"
									class="btn btn-primary"
									style="float: right; background-color: #46b8da; border-radius: 10px; margin-top: 1px;">Insert
									Admin</button></a>
						</h3>

						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<div class="card-content table-responsive">
						<table class="table table-hover" id="dataTable">
							<thead>
								<th>Admin Name</th>
								<th>Username</th>
								<th>Contact No</th>
								<th>Email Id</th>
								<th></th>
							</thead>
							<tbody>

								<c:forEach items="${admins}" var="admin">
									<c:if
										test="${admin.hospitalAdminId != sessionScope.sessionId }">
										<tr>
											<td>${admin.hospitalAdminName}</td>
											<td>${admin.hospitalAdminUsername}</td>
											<td>${admin.hospitalAdminContactNo}</td>
											<td>${admin.hospitalAdminEmail}</td>
											<td><c:if test="${admin.status == 1 }">
													<a
														href="/hospital/deactiveadmin?id=${admin.hospitalAdminId }"><button
															type="button" name="btnapprove" value="Dispatch Event"
															class="btn btn-success"
															style="border-radius: 10px; margin-top: 1px;">Approve</button></a>
												</c:if> <c:if test="${admin.status == 0 }">
													<a
														href="/hospital/activeadmin?id=${admin.hospitalAdminId }"><button
															type="button" name="btnapprove" value="Dispatch Event"
															class="btn btn-warning"
															style="border-radius: 10px; margin-top: 1px;">DisApprove</button></a>
												</c:if></td>


										</tr>
									</c:if>
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