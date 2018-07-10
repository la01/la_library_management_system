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
		<h1>会員登録/会員更新</h1>
		<form action="ConfirmMember" method="post">
			<div class="row">
				<div class="col-xs-2">
					<label for="memberId">会員ID</label> <input type="text"
						class="form-control" id="memberId" disabled>
				</div>
				<div class="col-xs-4">
					<label for="lastName">苗字</label> <input type="text"
						class="form-control" id="lastName" autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="fisrtName">名前</label> <input type="text"
						class="form-control" id="fisrtName" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="zip">郵便番号</label> <input type="text"
						class="form-control" id="zip" placeholder="0000000"
						autocomplete="off">
				</div>
				<div class="col-xs-8">
					<label for="address">住所</label> <input type="text"
						class="form-control" id="address" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="phone">電話番号</label> <input type="text"
						class="form-control" id="phone" placeholder="000-0000-0000"
						autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="mail">メールアドレス</label> <input type="text"
						class="form-control" id="mail" placeholder="my@address.com"
						autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="date">生年月日</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="year">
								<option>1998</option>
								<option>1900</option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="month">
								<option>1</option>
								<option>12</option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="day">
								<option>1</option>
								<option>31</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-primary form__button--margin btn-block">登録/更新</button>
				</div>
				<div class="col-xs-2">
					<button type="button"
						class="btn btn-default form__button--margin btn-block">戻る</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>