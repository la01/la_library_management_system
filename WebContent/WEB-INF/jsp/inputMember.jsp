<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>入力</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>会員${mode}</h1>
      <form action="ConfirmMember" method="post">
        <input type="hidden" name="mode" value="${mode}">
        <input type="hidden" name="action" value="${action}">
        <div class="row">
          <div class="col-xs-2">
            <label for="memberId">会員ID</label>
            <input type="text" class="form-control" name="memberId" value="${memberId}" readonly>
          </div>
          <div class="col-xs-2">
            <label for="familyName">苗字</label>
            <input type="text" class="form-control" name="familyName" value="${familyName}" autocomplete="off" maxlength='10' title="10文字以内で入力してください。" required>
          </div>
          <div class="col-xs-2">
            <label for="name">名前</label>
            <input type="text" class="form-control" name="name" value="${name}" autocomplete="off" maxlength='10' title="10文字以内で入力してください。"required>
          </div>
          <div class="col-xs-3">
            <label for="tel">電話番号</label>
            <input type="text" class="form-control" name="tel" value="${tel}" placeholder="000-0000-0000" autocomplete="off" pattern="\d{2,5}-\d{1,4}-\d{3,4}" maxlength="20" required>
          </div>
          <div class="col-xs-3">
            <label for="email">メールアドレス</label>
            <input type="text" class="form-control" name="email" value="${email}" autocomplete="off" maxlength="100" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label for="postal">郵便番号</label>
            <input type="text" class="form-control" name="postal" value="${postal}" placeholder="0000000" autocomplete="off" pattern="[0-9]{7}" maxlength="7" title="半角数字7文字で入力してください。"required>
          </div>
          <div class="col-xs-7">
            <label for="address">住所</label>
            <input type="text" class="form-control" name="address" value="${address}" autocomplete="off" maxlength="100" title="100文字以内で入力してください。"required>
          </div>
          <div class="col-xs-3">
            <label for="birthday">生年月日</label>
              <input type="date" class="form-control" name="birthday" value="${birthday}" required>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <button type="submit" class="btn btn-primary form__button--margin btn-block">${mode}</button>
          </div>
          <c:if test="${action == 'update'}">
          <div class="col-xs-2">
            <button type="button" onclick="history.back()" class="btn btn-default form__button--margin btn-block">戻る</button>
          </div>
          </c:if>
        </div>
      </form>
    </div>
  </body>
</html>