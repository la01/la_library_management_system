<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<jsp:include page="../../jsp/include.jsp" flush="true" />
</head>
<body>
	<jsp:include page="../../jsp/template.jsp" flush="true" />
	<div class="page-content-wrapper">
		<h1>${mode}完了</h1>
		<h3>
			資料ID :
			<c:forEach var="bookId" items="${id}" varStatus="status">
				<span>${bookId }</span>
				<c:if test="${!status.last }"> , </c:if>
			</c:forEach>
		</h3>
		<h3>
			資料名 : ${name }
		</h3>
		<h3>の${mode}を行いました</h3>
	</div>
</body>
</html>