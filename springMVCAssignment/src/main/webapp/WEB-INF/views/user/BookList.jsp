<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="content-language" content="en-us" />
<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<link href="resources/css/ie-win.css" rel="stylesheet" type="text/css">
<link href="resources/css/masters.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
img {
	width: 240px;
	height: 200px;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<%
	String cookie = null;
	Cookie[] cookies = null;
	cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("email")) {
		cookie = cookies[i].getValue();
			}
		}
	}
	%>
	<div id="header">
		<h1>
			<a href="#00">Bookess &middot; The Store</a>
		</h1>

		<%
		if (cookie != null) {
		%>
		<h1 style="color: white;">
			Welcome -
			<%
		out.print(cookie);
		%>
		</h1>
		<%
		}
		%>

	</div>
	<div id="navigation">
		<ul>
			<li class="active"><a href="#showcase/free_templates/">Home</a></li>

			<%
			if (cookie == null) {
			%>
			<li class="nav-item"><a class="nav-link" href="login">Login</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="register">Register</a>
			</li>
			<%
			}
			if (cookie != null) {
			%>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
			<%
			}
			%>

		</ul>
	</div>
	<div id="content-wrapper" class="mb-5">
		<div style="text-align: center">
			<span class='error'> <c:if test="${error != null }">
								${error } 
							</c:if>
			</span>
		</div>

		<div class="row row-cols-3 g-3">


			<c:forEach items="${books }" var="book">
				<form action="bookMapping" method="POST">
					<div class="col">
						<div class="card">
							<img src="${book.getBImagePath() }" class="card-img-top"
								alt="Hollywood Sign on The Hill" />
							<div class="card-body">
								<h5 class="card-title">${book.getBName() }</h5>
								<p class="card-text">${book.getBDescription() }</p>

								<a style="margin: 7.5%"
									href="bookMapping/readlater/${book.getBId() }"><i
									class="fa fa-bookmark-o"></i></a> &nbsp; <a
									href="bookMapping/liked/${book.getBId() }"> <i
									class="fa fa-heart-o"></i>
								</a>

							</div>
						</div>
					</div>
				</form>

			</c:forEach>



		</div>
	</div>
	<div id="footer">
		<div id="meta">
			<div class="upcoming">
				<h3>To Be Read Later</h3>
				<ul>
					<c:forEach items="${booksLater }" var="readLater">
						<li><a href="#">${readLater }</a></li>
					</c:forEach>

				</ul>
			</div>
			<div class="authors">
				<h3>Favorite Authors</h3>
				<ul>
					<c:forEach items="${booksLiked }" var="readLiked">
						<li><a href="#">${readLiked }</a></li>
					</c:forEach>
				</ul>
			</div>
			<hr />
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Copyright © 2020. All
				rights reserved.</div>
			<!-- Copyright -->

			<!-- Right -->
			<div>
				<a href="#!" class="text-white me-4"> <i
					class="fab fa-facebook-f"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-twitter"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-google"></i>
				</a> <a href="#!" class="text-white"> <i class="fab fa-linkedin-in"></i>
				</a>
			</div>
			<!-- Right -->
		</div>
	</div>
</body>

</html>