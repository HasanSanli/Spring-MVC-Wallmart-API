<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Walmart Open API</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/4-col-portfolio.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/custom.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400i,700,700i|Roboto+Slab:100,300,400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<small>Walmart Open API</small>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 item-photo">
				<img style="max-width: 100%;" src="${movie.largeImage}" />
			</div>
			<div class="col-xs-5" style="border: 0px solid gray">
				<h3>${movie.name}</h3>
				<h5 style="color: #337ab7">${movie.categoryPath}</h5>
				<h6 class="title-price">
					<small>Sale Price</small>
				</h6>
				<h3 style="margin-top: 0px;">$${movie.salePrice}</h3>
				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>${movie.stock}</small>
					</h6>
				</div>
			</div>
			<div class="col-xs-9">
				<ul class="menu-items">
					<li class="active">Description</li>
				</ul>
				<div style="width: 100%; border-top: 1px solid silver">
					<p style="padding: 15px;">
						<small> ${movie.longDescription}</small>
					</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>