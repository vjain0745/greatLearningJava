<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<style type="text/css">
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}

.error {
	color: red;
}

.message {
	color: blue;
}


</style>
</head>
<body>

	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div style="text-align: center" class="mb-4">
					<h1>Sign Up</h1>
					<span class='error'> <c:if test="${error != null }">
								${error} 
							</c:if>
					</span> <span class='message'> <c:if test="${message != null }">
								${message} 
							</c:if>
					</span>
				</div>
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="register" method="POST">

						<!-- Name input -->
						<div class="form-outline mb-3">
							<label class="form-label" for="name">Name</label> <input
								type="text" id="name" name="name" required
								class="form-control form-control-lg" placeholder="Enter name" />
						</div>

						<!-- Email input -->
						<div class="form-outline mb-4">
							<label class="form-label" for="email">Email address</label> <input
								type="email" id="email" name="email" required
								class="form-control form-control-lg" placeholder="Enter email" />
						</div>

						<!-- Number input -->
						<div class="form-outline mb-3">
							<label class="form-label" for="mobileNumber">Mobile No.</label> <input
								type="text" id="mobileNumber" name="mobileNumber" required
								class="form-control form-control-lg"
								placeholder="Enter mobile number" />
						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<label class="form-label" for="password">Password</label> <input
								type="password" id="password" name="password" required
								class="form-control form-control-lg"
								placeholder="Enter password" />
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
							<p class="small fw-bold mt-2 pt-1 mb-0">
								Already have an account? <a href="login" class="link-danger">Login</a>
							</p>
						</div>

					</form>
				</div>
			</div>
		</div>

	</section>
</body>
</html>