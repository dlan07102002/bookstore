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


<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/sign-in.css" rel="stylesheet">
</head>

<body style = "display: block; padding: 0; margin: 0">
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<form class="form-signin" action="../customer" method="POST">
			<input type="hidden" name="action" value="login" />
			<div class="text-center">
				<img class="mb-4 " class="rounded "
					src="https://www.svgrepo.com/show/232132/duck.svg" alt=""
					width="72">
			</div>

			<h1 class="h3 mb-3 font-weight-normal text-center">Please sign
				in</h1>

			<%
			String err = request.getAttribute("error") + "";
			err = (err.equals("null")) ? "" : err;
			%>
			<div class="text-center ">
				<span class="red"><%=err%></span>
			</div>
			<label for="username" class="sr-only">User name</label> <input
				type="text" id="username" name="username" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="password" class="sr-only">Password</label> <input
				type="password" id="password" class="form-control" name="password"
				placeholder="Password" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<div class="text-center">
				<button class="btn btn-lg btn-primary btn-block " type="submit">Sign
					in</button>
			</div>
			<a class="text-center d-block" href="register.jsp">Register</a>
			<p class="mt-5 mb-3 text-muted text-center">&copy; 2001-2024</p>
		</form>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>

</body>

</html>