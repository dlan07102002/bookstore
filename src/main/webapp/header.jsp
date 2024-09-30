<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>

	<!-- Menu bar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://www.svgrepo.com/show/232132/duck.svg" alt="Bootstrap"
				height="24">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
							<li><a class="dropdown-item" href="#">Áo thun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
					<%
					Object o = session.getAttribute("customer");
					Customer c = null;
					String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
					if (o != null)
						c = (Customer) o;

					if (c == null) {
					%>
					<a class="btn btn-primary ms-1" href="<%=url%>/customer/login.jsp">
						Login </a>
					<%
					} else {
					%>

					<div class="dropdown">
						<button class="dropbtn btn">My account</button>
						<div class="dropdown-content">
							<a href="#">My order</a> <a href="#">Notification</a> <a
								href="<%=url%>/customer/changeUserInfo.jsp">Change user info</a> <a
								href="<%=url%>/customer/changePassword.jsp">Change password</a> <a
								href="<%=url%>/customer?action=logout"
								style="border-top: #aaa8a8 2px solid;"> Log out </a>

						</div>
					</div>
			</div>


			<%
			}
			%>


			</form>
		</div>
		</div>
	</nav>

	<!-- End Menu bar -->
