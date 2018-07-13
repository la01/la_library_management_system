<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h3>会員ID : <span>${memberId }</span></h3>
        <h3>資料ID :
        	<c:forEach items="${bookId}" var="item">
        		<span>${item} </span>
        	</c:forEach>
        </h3>
        <h3>上記の資料を${mode}しました</h3>
    </div>
</body>
</html>