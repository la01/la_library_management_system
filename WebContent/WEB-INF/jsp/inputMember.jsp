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
		<h1>会員${mode}</h1>
		<form action="ConfirmMember" method="post">
			<input type="hidden" name="mode" value="${mode}">
			<input type="hidden" name="action" value="${action}">
			<div class="row">
				<div class="col-xs-2">
					<label for="memberId">会員ID</label> <input type="text"
						class="form-control" id="memberId" value="11" disabled>
					<input type="hidden" name="memberId" value = "11">
				</div>
				<div class="col-xs-4">
					<label for="lastName">苗字</label> <input type="text"
						class="form-control" id="lastName" name="familyName" autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="fisrtName">名前</label> <input type="text"
						class="form-control" id="name" name="name" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="zip">郵便番号</label> <input type="text"
						class="form-control" id="postal" name="postal" placeholder="0000000"
						autocomplete="off">
				</div>
				<div class="col-xs-8">
					<label for="address">住所</label> <input type="text"
						class="form-control" id="address" name="address" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="phone">電話番号</label> <input type="text"
						class="form-control" id="tel" name="tel" placeholder="000-0000-0000"
						autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="mail">メールアドレス</label> <input type="text"
						class="form-control" id="email"  name="email" placeholder="my@address.com"
						autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="date">生年月日</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="year" name="year">
								<jsp:include page="../../jsp/year.jsp" flush="true" />
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="month" name="month">
								<jsp:include page="../../jsp/month.jsp" flush="true" />
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="date" name="date">
								<jsp:include page="../../jsp/date.jsp" flush="true" />
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button type="submit" class="btn btn-primary form__button--margin btn-block">${mode}</button>
				</div>
				<div class="col-xs-2">
					<button type="button" onclick="history.back()"
						class="btn btn-default form__button--margin btn-block">戻る</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>