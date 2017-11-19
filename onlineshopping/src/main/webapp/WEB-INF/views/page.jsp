<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title}</title>
<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css }/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<link href="${css}/readable.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/NavBar.jsp"%>

		<div class="content">
			<c:if test="${userClickHome==true }">
				<!-- Home content -->
				<%@include file="Home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout==true }">
				<!-- Home content -->
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true }">
				<!-- Home content -->
				<%@include file="contact.jsp"%>
			</c:if>
			
				<c:if test="${userClickAllProducts==true or userClickCatagoryProducts==true }">
				<!-- Home content -->
				<%@include file="listProducts.jsp"%>
			</c:if>
			
		</div>


		<!-- Footer -->
		<%@include file="./shared/Footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
