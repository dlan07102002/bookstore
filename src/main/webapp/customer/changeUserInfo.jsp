<%@page import="java.sql.Date"%>
<%@page import="com.mysql.cj.callback.UsernameCallback"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width-device-width, initial-scale=1, shrink-to-fit=no">
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">

</head>

<style>
.red {
	color: red;
}

.dropbtn {
	background-color: #04AA6D;
	color: white;
	margin-left: 0.25rem;
	font-size: 1 rem;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
	right: 0;
	z-index: 9999;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
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

	String name = c.getName();
	System.out.println(name);
	String birthDate_str = c.getBirthDate() + "";
	String gender_str = (c.getSex()) ? "male" : "female";
	String address = c.getAddress();
	String ordAddress = c.getOrdAddress();
	String shipTo = c.getShipTo();
	String email = c.getEmail();
	String phoneNumber = c.getPhoneNumber();
	boolean isUseMsgService = c.isUseMsgService();
	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h3 style="text-align: center">User Info</h3>

		<div class="red" id="error">
			<%=err%>
		</div>

		<form class="form" action="../customer" method="POST">
			<input type="hidden" name="action" value="change-user-info" />
			<div class="row">
				<div class="col-md-6">
					<div class="mb-3">
						<label for="name" class="form-label">Full Name</label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Enter your name" value="<%=name%>">
					</div>

					<div class="mb-3">
						<label for="birthdate" class="form-label">Birth Date</label> <input
							type="date" class="form-control" id="birthdate" name="birthDate"
							value=<%=birthDate_str%>>
					</div>

					<div class="mb-3">
						<label for="gender" class="form-label">Gender</label> <select
							class="form-select" id="gender" name="gender">
							<option selected>Choose your gender</option>
							<option value="male"
								<%=(gender_str.equals("male")) ? "selected='selected'" : ""%>>Male</option>
							<option value="female"
								<%=(gender_str.equals("female")) ? "selected='selected'" : ""%>>Female</option>
							<option value="other">Other</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Address <span
							class="red">*</span></label> <input type="text" class="form-control"
							id="address" placeholder="Enter your address" name="address"
							value="<%=address%>">
					</div>
				</div>

				<div class="col-md-6">



					<div class="mb-3">
						<label for="orderAddress" class="form-label">Order Address
							<span class="red">*</span>
						</label> <input type="text" class="form-control" id="orderAddress"
							placeholder="Enter order address" name="ordAddress"
							value="<%=ordAddress%>">
					</div>

					<div class="mb-3">
						<label for="shipTo" class="form-label">Ship To </label> <input
							type="text" class="form-control" id="shipTo"
							placeholder="Enter shipping address" name="shipTo"
							value="<%=shipTo%>">
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">Email <span
							class="red">*</span></label> <input type="email" class="form-control"
							id="email" name="email" placeholder="Enter your email"
							name="email" value="<%=email%>">
					</div>

					<div class="mb-3">
						<label for="phone" class="form-label">Phone Number <span
							class="red">*</span></label> <input type="tel" class="form-control"
							id="phone" placeholder="Enter your phone number"
							name="phoneNumber" value="<%=phoneNumber%>">
					</div>

					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input"
							name="isUseMsgService" <%=(isUseMsgService) ? "checked" : ""%>>
						<label class="form-check-label" for="exampleCheck1"> Use
							Message Service</label>
					</div>



				</div>

				<button type="submit" class="btn btn-primary" name="save"
					id="save-btn">Save</button>
			</div>
		</form>
	</div>
	
	<%
	}
	%>
	<jsp:include page = "../footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
</body>
<script>
	function checkPasswordMatch() {
		passwordEle = document.getElementById("password").value;
		confirmPasswordEle = document.getElementById("confirm-password").value;
		if (passwordEle != confirmPasswordEle) {
			document.getElementById("err-msg").innerHTML = "Password do not match";
			return false;
		} else {
			document.getElementById("err-msg").innerHTML = "";
			return true;
		}
	}

	function isCheckBtn() {
		agreeTermCon = document.getElementById("agree-check");
		console.log(agreeTermCon.checked);
		if (agreeTermCon.checked == true) {
			document.getElementById("register-btn").style.visibility = "visible";
		} else {
			document.getElementById("register-btn").style.visibility = "hidden";
		}

	}
</script>
</html>