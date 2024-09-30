<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change password</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<style>
	.red{
		color: red;
	}
	
	.green{
		color: green;
	}
</style>
<body>
	<%
	Object o = session.getAttribute("customer");
	Customer c = null;
	if (o != null)
		c = (Customer) o;
	if (c == null) {
	%>
	<h1>You are not sign-in to the system. Please back to main page</h1>

	<%
	} else {
	String err = request.getAttribute("error") + "";
	err = (err.equals("null")) ? "" : err;
	
	String success = request.getAttribute("success") + "";
	success = (success.equals("null")) ? "" : success;
	%>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h3 class="text-center">Change Password</h3>
				<span class = "red"> <%=err%>
				</span>
				<span class = "green"> <%=success%>
				</span>
				<form action="../customer" method="POST">
				<input type = "hidden" name = "action" value = "change-password"/>
					<!-- Current Password -->
					<div class="mb-3">
						<label for="currentPassword" class="form-label">Current
							Password</label> <input type="password" class="form-control"
							id="currentPassword" name="currentPassword"
							placeholder="Enter current password" required>
					</div>

					<!-- New Password -->
					<div class="mb-3">
						<label for="newPassword" class="form-label">New Password</label> <input
							type="password" class="form-control" id="newPassword"
							name="newPassword" placeholder="Enter new password" required>
					</div>

					<!-- Confirm New Password -->
					<div class="mb-3">
						<label for="confirmPassword" class="form-label">Confirm
							New Password</label> <input type="password" class="form-control"
							id="confirmPassword" name="confirmPassword"
							placeholder="Re-enter new password" required>
					</div>

					<!-- Submit Button -->
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Change
							Password</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
	<%
	}
	%>
</body>
</html>