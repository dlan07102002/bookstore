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

<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/sign-in.css" rel="stylesheet">
</head>

<body>
	<form class="form-signin" action = "/login" method = "POST">
		<div class="text-center">
			<img class="mb-4 " class="rounded "
				src="https://www.svgrepo.com/show/232132/duck.svg" alt="" width="72">
		</div>

		<h1 class="h3 mb-3 font-weight-normal text-center">Please sign
			in</h1>
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
	<a class = "text-center d-block" href = "register.jsp">Register</a>
		<p class="mt-5 mb-3 text-muted text-center">&copy; 2001-2024</p>
	</form>
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