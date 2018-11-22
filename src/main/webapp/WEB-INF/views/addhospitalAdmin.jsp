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
						<h2 class="title" style="text-align: center">Hospital
							Admininstartor</h2>
						<!--<p class="category">Here is a subtitle for this table</p>-->
					</div>
					<br>
					<div class="card-content">
						<form action="#" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Admin Name</label> <input
											type="text" name="txthospitaladminanme" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">

								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Username</label> <input
											type="text" name="txtusername" class="form-control" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Password</label> <input
											type="password" name="txtpassword" class="form-control"
											required />
									</div>
								</div>
							</div>
							<div class="row">

								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Contact Number</label> <input
											type="text" name="txtcontactno"
											onblur="return allLetter(txtRAM);" class="form-control"
											required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group label-floating">
										<label class="control-label">Email Id</label> <input
											type="email" name="txtemail"
											onblur="return allLetter(txtRAM);" class="form-control"
											required />
									</div>
								</div>
							</div>





							<input type="submit" value="Register"
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