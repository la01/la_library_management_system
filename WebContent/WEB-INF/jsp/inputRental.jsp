<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>貸出/返却</h1>
		<form action="ConfirmRental" method="post">
			<div class="row">
				<div class="col-xs-2">
					<label for="memberId">会員ID</label> <input type="text"
						class="form-control" id="memberId">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="bookId1">資料ID</label> <input type="text"
						class="form-control" id="bookId1">
				</div>
				<div class="col-xs-2">
					<label for="bookId2">資料ID</label> <input type="text"
						class="form-control" id="bookId2">
				</div>
				<div class="col-xs-2">
					<label for="bookId3">資料ID</label> <input type="text"
						class="form-control" id="bookId3">
				</div>
				<div class="col-xs-2">
					<label for="bookId4">資料ID</label> <input type="text"
						class="form-control" id="bookId4">
				</div>
				<div class="col-xs-2">
					<label for="bookId5">資料ID</label> <input type="text"
						class="form-control" id="bookId5">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-primary form__button--margin btn-block">貸出/返却</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>