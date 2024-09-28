<%@page import="java.sql.Date"%>
<%@page import="com.mysql.cj.callback.UsernameCallback"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<body>
	<%
	String err = (request.getAttribute("error") + "").equals("null") ? "" : request.getAttribute("error") + "";

	String username = request.getAttribute("username") + "";
	username = (username.equals("null")) ? "" : username;

	String name = request.getAttribute("name") + "";
	name = (name.equals("null")) ? "" : name;

	String gender_str = request.getAttribute("gender") + "";
	gender_str = (gender_str.equals("null")) ? "" : gender_str;

	String birthDate_str = request.getAttribute("birthDate") + "";
	birthDate_str = (birthDate_str.equals("null")) ? "" : birthDate_str;

	String address = request.getAttribute("address") + "";
	address = (address.equals("null")) ? "" : address;

	String ordAddress = request.getAttribute("ordAddress") + "";
	ordAddress = (ordAddress.equals("null")) ? "" : ordAddress;

	String email = request.getAttribute("email") + "";
	email = (email.equals("null")) ? "" : email;

	String phoneNumber = request.getAttribute("phoneNumber") + "";
	phoneNumber = (phoneNumber.equals("null")) ? "" : phoneNumber;

	String shipTo = request.getAttribute("shipTo") + "";
	shipTo = (shipTo.equals("null")) ? "" : shipTo;

	String isUseMsgService_str = request.getAttribute("isUseMsgService") + "";
	isUseMsgService_str = (isUseMsgService_str.equals("null")) ? "" : isUseMsgService_str;
	%>
	<div class="container">
		<h3 style="text-align: center">Register</h3>

		<div class="red" id="error">
			<%=err%>
		</div>

		<form class="form" action="do-register" method="POST">
			<div class="row">
				<div class="col-md-6">


					<div class="mb-3">
						<label for="username" class="form-label">Username <span
							class="red">*</span></label> <input type="text" class="form-control"
							id="name" placeholder="Enter your name" name="username"
							required="required" value=<%=username%>>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="password" placeholder="Enter your password" name="password"
							required="required" onkeyup="checkPasswordMatch()">
					</div>
					<div class="mb-3">
						<label for="confirmPassword" class="form-label"> Confirm
							Password<span class="red">*</span> <span id="err-msg" class="red"></span>
						</label> <input type="password" class="form-control" id="confirm-password"
							placeholder="Enter your password" name="confirmPassword"
							required="required" onkeyup="checkPasswordMatch()">
					</div>

					<div class="mb-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Enter your name" value=<%=name%>>
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
				</div>

				<div class="col-md-6">

					<div class="mb-3">
						<label for="address" class="form-label">Address <span
							class="red">*</span></label> <input type="text" class="form-control"
							id="address" placeholder="Enter your address" name="address"
							value=<%=address%>>
					</div>

					<div class="mb-3">
						<label for="orderAddress" class="form-label">Order Address
							<span class="red">*</span>
						</label> <input type="text" class="form-control" id="orderAddress"
							placeholder="Enter order address" name="ordAddress"
							value=<%=ordAddress%>>
					</div>

					<div class="mb-3">
						<label for="shipTo" class="form-label">Ship To </label> <input
							type="text" class="form-control" id="shipTo"
							placeholder="Enter shipping address" name="shipTo"
							value=<%=shipTo%>>
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">Email <span
							class="red">*</span></label> <input type="email" class="form-control"
							id="email" name="email" placeholder="Enter your email"
							name="email" value=<%=email%>>
					</div>

					<div class="mb-3">
						<label for="phone" class="form-label">Phone Number <span
							class="red">*</span></label> <input type="tel" class="form-control"
							id="phone" placeholder="Enter your phone number"
							name="phoneNumber" value=<%=phoneNumber%>>
					</div>

					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input"
							name="isUseMsgService"
							<%=(!isUseMsgService_str.isEmpty()) ? "checked" : ""%>> <label
							class="form-check-label" for="exampleCheck1"> Use Message
							Service</label>
					</div>


					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input"
							name="agreeToTermsandConds" onchange="isCheckBtn()"
							id="agree-check"> <label class="form-check-label"
							for="exampleCheck1"> I agree to <a href="#">Terms and
								Conditions</a>
						</label>
					</div>
				</div>


				<button type="submit" class="btn btn-primary"
					style="visibility: hidden" name="register" id="register-btn">Register</button>
			</div>
		</form>
	</div>
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