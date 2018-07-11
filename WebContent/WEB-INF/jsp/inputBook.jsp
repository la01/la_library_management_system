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
		<h1>資料登録/資料更新</h1>
		<form action="ConfirmBook" method="post">
			<div class="row">
				<div class="col-xs-2">
					<label for="bookId">資料ID</label> <input type="text"
						class="form-control" id="bookId" disabled>
				</div>
				<div class="col-xs-2">
					<label for="isbn">ISBN番号</label> <input type="text"
						class="form-control" id="isbn" autocomplete="off">
				</div>
				<div class="col-xs-7">
					<label for="bookName">資料名</label> <input type="text"
						class="form-control" id="bookName" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="code">分類コード</label>
					<div class="row">
						<div class="col-xs-12">
							<select class="form-control" id="code">
								<option value="0">総記</option>
								<option value="1">哲学</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<label for="author">著者</label> <input type="text"
						class="form-control" id="author" autocomplete="off">
				</div>
				<div class="col-xs-3">
					<label for="company">出版社</label> <input type="text"
						class="form-control" id="company" autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="date">出版日</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="year">
								<option>2018</option>
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
					<label for="num">入荷冊数</label> <input type="text"
						class="form-control" id="num" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-primary form__button--margin btn-block">登録/更新</button>
				</div>
				<div class="col-xs-2">
					<button type="button"
						class="btn btn-primary form__button--margin btn-block">ISBN番号から取得</button>
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