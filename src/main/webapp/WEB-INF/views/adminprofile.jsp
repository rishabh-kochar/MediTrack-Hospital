<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/navigation.jspf"%>
<%@ include file="../common/header.jspf"%>

<div class="content" style="margin-top: -40px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Profile</h4>
						<p class="category">Complete your profile</p>
					</div>
					<div class="card-content">
						<form method="post" action="/hospital/adminprofile">
							<div class="row">

								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Name</label> <input type="text"
											class="form-control" name="txtadminname" value="${ProfileData.hospitalAdminName }">
									</div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Username</label> <input
											type="text" name="txtusername" class="form-control" value="${ProfileData.hospitalAdminUsername }">
									</div>
								</div>
								
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Password</label> <input
											type="password" name="txtpassword" class="form-control" value="${ProfileData.hospitalAdminPassword }">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact Number</label> <input
											type="text" name="txtcontactno" class="form-control" value="${ProfileData.hospitalAdminContactNo }">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Email</label> <input type="email"
											class="form-control" name="txtemail" value="${ProfileData.hospitalAdminEmail }">
									</div>
								</div>
							</div>


							



							<button type="submit" class="btn btn-primary pull-right">Update
								Profile</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-profile">
					
					<div class="content">
						<h6 class="category text-gray">Doctor</h6>
						<h4 class="card-title">${ProfileData.hospitalAdminName }</h4>
						<p class="card-content">${ProfileData.hospitalAdminEmail }</p>
						<p class="card-content">${ProfileData.hospitalAdminContactNo }</p>



					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jspf"%>