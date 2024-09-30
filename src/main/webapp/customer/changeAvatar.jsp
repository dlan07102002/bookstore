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

	String imgPath = c.getImgPath();
	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h3 style="text-align: center">Avatar</h3>

		<div class="red" id="error">
			<%=err%>
		</div>
		<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		%>
		<form class="form" action="<%=url%>/change-avatar" method="POST" enctype ="multipart/form-data">
			<div class="row">
				<div class="col-md-6">
					<div class="mb-3">
					<div class="text-center">
						<img class = "rounder mb-4" src="<%=url %>/avatar/<%=imgPath %>" width = "150" height="150" alt="avatar" /> 
						</div>
						 <input type="file"
							class="form-control" id="imgPath" name="imgPath"
						>
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