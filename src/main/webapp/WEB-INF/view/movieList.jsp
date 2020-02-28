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
		<div class="col-md-3">
			<p class="lead">Categories</p>
			<div id="category-options" class="list-group">
				<c:if test="${not empty movieCategories}">
					<c:forEach var="category" items="${movieCategories}">
						<a href="<c:url value='/category/${category.id}' />"
							class="list-group-item category-select-option">${category.name}</a>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<c:if test='${isCategoryEmpty!="Y"}'>
		<div id="products" class="row list-group col-md-9">
			<c:forEach var="movie" items="${subCategoryMovies}">
				<div class="item  col-xs-3 col-lg-3">
					<div class="thumbnail">
						<img class="group list-group-image" src="${movie.mediumImage}"
							alt="${movie.name}" />
						<div class="caption">
							<h5 class="group inner list-group-item-heading">${movie.nameDispWeb()}</h5>
							<p class="group inner list-group-item-text">${movie.shDispWeb()}</p>
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<p class="lead">$${movie.salePrice}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<a class="btn btn-success" href="/movie?itemId=${movie.itemId}">Details..</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:url value="/category/${categoryId}" var="prev">
				<c:param name="page" value="${page-1}" />
			</c:url>
			<c:if test="${page > 1}">
				<li class="page-item"><a class="page-link"
					href='<c:out value="${prev}" />' aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
				<c:choose>
					<c:when test="${page == i.index}">
						<li class="page-item"><a class="page-link" href='#'>${i.index}</a></li>
					</c:when>
					<c:otherwise>
						<c:url value="/category/${categoryId}" var="url">
							<c:param name="page" value="${i.index}" />
						</c:url>
						<li class="page-item"><a class="page-link"
							href='<c:out value="${url}" />'>${i.index}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:url value="/category/${categoryId}" var="next">
				<c:param name="page" value="${page + 1}" />
			</c:url>
			<c:if test="${page + 1 <= maxPages}">
				<li class="page-item"><a class="page-link"
					href='<c:out value="${next}" />' aria-label="Next"> <span
						aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
		</nav>
	    </c:if>
	    <c:if test='${isCategoryEmpty=="Y"}'>
	       <h1>No movies found in this category!</h1>
	    </c:if>
	    
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>