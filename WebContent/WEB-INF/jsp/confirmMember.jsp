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
		<h1>${mode}確認</h1>
		<form action="DoneMember" method="post">
			<input type="hidden" name="mode" value="${mode}"> <input
				type="hidden" name="action" value="${action}">
			<table class="table">
				<thead>
					<tr>
						<th>項目</th>
						<th>情報</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>会員ID</th>
						<td><c:out value="${memberId}" /><input type="hidden"
							name="memberId" value="${memberId}"></td>
					</tr>
					<tr>
						<th>姓名</th>
						<td><c:out value="${familyName}" /><input type="hidden"
							name="familyName" value="${familyName}"> <c:out
								value="${name}" /><input type="hidden" name="name"
							value="${name}"></td>
					</tr>
					<tr>
						<th>郵便番号</th>
						<td><c:out value="${postal}" /><input type="hidden"
							name="postal" value="${postal}"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><c:out value="${address}" /><input type="hidden"
							name="address" value="${address}"></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><c:out value="${tel}" /><input type="hidden" name="tel"
							value="${tel}"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><c:out value="${email}" /><input type="hidden"
							name="email" value="${email}"></td>
					</tr>
					<tr>
						<th>生年月日</th>
						<td><c:out value="${year}" /><input type="hidden"
							name="year" value="${year}">/<c:out value="${month}" /><input
							type="hidden" name="month" value="${month}">/<c:out
								value="${date}" /><input type="hidden" name="date"
							value="${date}"></td>
					</tr>
				</tbody>
			</table>
			<h3>上記のデータを${mode}します</h3>
			<div class="form_button--margin">
				<button type="submit"
					class="btn btn-primary form__button form__button--padding">OK</button>
				<button type="button"
					class="btn btn-default form__button form__button--padding"
					onclick="history.back()">戻る</button>
			</div>
		</form>
	</div>
</body>
</html>