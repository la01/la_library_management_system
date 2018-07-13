<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<jsp:include page="../../jsp/include.jsp" flush="true" />
<script type="text/javascript" src="./js/inputReturn.js"></script>
</head>
<body>
	<jsp:include page="../../jsp/template.jsp" flush="true" />
	<div class="page-content-wrapper">
		<h1>${mode}</h1>
		<form action="ConfirmRental" method="post">
			<input type="hidden" name="mode" value="${mode}"> <input
				type="hidden" name="action" value="${action}">
			<div class="row">
				<div class="col-xs-2">
					<label for="memberId">会員ID</label> <input type="text"
						class="form-control" id="memberId" name="memberId" value="${memberId }"
						pattern="^[0-9]+$" title="半角数字で入力してください。" required>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="bookId1">資料ID</label> <input type="text"
						class="form-control" id="bookId1" name="bookId1" value="${bookId1 }"
						pattern="^[0-9]+$" title="半角数字で入力してください。" required>
				</div>
				<div class="col-xs-2">
					<label for="bookId2">資料ID</label> <input type="text"
						class="form-control" id="bookId2" name="bookId2" value="${bookId2 }"
						pattern="^[0-9]+$" title="半角数字で入力してください。">
				</div>
				<div class="col-xs-2">
					<label for="bookId3">資料ID</label> <input type="text"
						class="form-control" id="bookId3" name="bookId3" value="${bookId3 }"
						pattern="^[0-9]+$" title="半角数字で入力してください。">
				</div>
				<div class="col-xs-2">
					<label for="bookId4">資料ID</label> <input type="text"
						class="form-control" id="bookId4" name="bookId4" value="${bookId4 }"
						pattern="^[0-9]+$" title="半角数字で入力してください。">
				</div>
				<div class="col-xs-2">
					<label for="bookId5">資料ID</label> <input type="text"
						class="form-control" id="bookId5" name="bookId5" value="${bookId5 }"
						pattern="^[0-9]+$" title="半角数字で入力してください。">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-primary form__button--margin btn-block">${mode}</button>
				</div>
				<c:if test='${action.equals("return")}'>
					<div class="col-xs-2">
						<button type="button"
							class="btn btn-primary form__button--margin btn-block"
							onclick="getDataFromMemberId()">会員IDから取得</button>
					</div>
				</c:if>
			</div>
		</form>
		<form action="InputReturn" method="post" name="searchIdForm">
			<input type="hidden" name="searchId" id="searchId">
		</form>
	</div>
</body>
</html>