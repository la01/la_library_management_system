<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<input type="hidden" name="mode" value="${mode}"> <input
				type="hidden" name="action" value="${action}">
			<div class="row">
				<div class="col-xs-2">
					<label for="memberId">会員ID</label> <input type="text"
						class="form-control" id="memberId" value="${memberId}" disabled required> <input
						type="hidden" name="memberId" value="${memberId}">
				</div>
				<div class="col-xs-4">
					<label for="familyName">苗字</label> <input type="text"
						class="form-control" id="familyName" name="familyName" value="${familyName}"
						autocomplete="off" maxlength='10' required>
				</div>
				<div class="col-xs-4">
					<label for="name">名前</label> <input type="text"
						class="form-control" id="name" name="name" value="${name}"
						autocomplete="off" maxlength='10' required>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="postal">郵便番号</label> <input type="text"
						class="form-control" id="postal" name="postal" value="${postal}"
						placeholder="0000000" autocomplete="off" pattern="[0-9]{7}" maxlength="7" required>
				</div>
				<div class="col-xs-8">
					<label for="address">住所</label> <input type="text"
						class="form-control" id="address" name="address" value="${address}"
						autocomplete="off" maxlength="100"required>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="tel">電話番号</label> <input type="text"
						class="form-control" id="tel" name="tel" value="${tel}"
						placeholder="000-0000-0000" autocomplete="off" pattern="\d{2,4}-\d{3,4}-\d{3,4}" maxlength="20" required>
				</div>
				<div class="col-xs-4">
					<label for="email">メールアドレス</label> <input type="text"
						class="form-control" id="email" name="email" value="${email}"
						placeholder="my@address.com" autocomplete="off" maxlength="100" pattern="^[a-zA-Z]{1}[0-9a-zA-Z]+[\w\.-]+@[\w\.-]+\.\w{2,}$" required>
				</div>
				<div class="col-xs-4">
					<label for="birthday">生年月日</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="year" name="year">
								<c:forEach begin="1900" end="2030" var="i">
									<option <c:if test="${i == year}">selected</c:if> value="<fmt:formatNumber value="${i}" pattern="0000" />">
										<c:out value="${i}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="month" name="month">
								<c:forEach begin="0" end="11" var="i">
									<option <c:if test="${(i + 1) == month }">selected</c:if> value="<fmt:formatNumber value="${i + 1}" pattern="00" />">
										<c:out value="${i + 1}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="date" name="date">
								<c:forEach begin="1" end="31" var="i">
									<option <c:if test="${i == date }">selected</c:if> value="<fmt:formatNumber value="${i}" pattern="00" />">
										<c:out value="${i}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button type="submit"
						class="btn btn-primary form__button--margin btn-block">${mode}</button>
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