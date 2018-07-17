<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>検索</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="page-content-wrapper">
      <h1>会員検索</h1>
      <form action="SearchMember" method="POST">
        <div class="row">
          <div class="col-xs-2">
            <label for="memberId">会員ID</label>
            <input type="text" class="form-control" name="memberId" value="${memberId }" autocomplete="off">
          </div>
          <div class="col-xs-3">
            <label for="familyName">苗字</label>
            <input type="text" class="form-control" name="familyName" value="${familyName }" autocomplete="off">
          </div>
          <div class="col-xs-3">
            <label for="name">名前</label>
            <input type="text" class="form-control" name="name" value="${name }" autocomplete="off">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label for="postal">郵便番号</label>
            <input type="text" class="form-control" name="postal" value="${postal }" placeholder="0000000" autocomplete="off">
          </div>
          <div class="col-xs-6">
            <label for="address">住所</label>
            <input type="text" class="form-control" name="address" value="${address }" autocomplete="off">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label for="tel">電話番号</label>
            <input type="text" class="form-control" name="tel" value="${tel }" placeholder="000-0000-0000" autocomplete="off">
          </div>
          <div class="col-xs-3">
            <label for="email">メールアドレス</label>
            <input type="text" class="form-control" name="email" value="${email }" autocomplete="off">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <button class="btn btn-primary form__button--margin btn-block">検索</button>
          </div>
        </div>
      </form>
      <div class="search__table--margin">
        <c:if test="${!empty result}">
          <h5>
            <span>${ fn:length( memberList ) }</span>件のデータが見つかりました
          </h5>
          <h5>項目名をクリックすることでソートされます</h5>
          <table class="table table-condensed">
            <thead>
              <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>郵便番号</th>
                <th>電話番号</th>
                <th>メールアドレス</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="member" items="${memberList}" varStatus="status">
                <tr>
                  <td>
                    <c:out value="${member.id}" />
                  </td>
                  <td>
                    <c:out value="${member.familyName}" />　
                    <c:out value="${member.name}" />
                  </td>
                  <td>〒
                    <c:out value="${member.postal}" />
                  </td>
                  <td>
                    <c:out value="${member.tel}" />
                  </td>
                  <td>
                    <c:out value="${member.email}" />
                  </td>
                  <td>
                    <form action="InputMember" method="post" style="display: inline">
                      <input type="hidden" name="memberId" value="${member.id}">
                      <input type="hidden" name="familyName" value="${member.familyName}">
                      <input type="hidden" name="name" value="${member.name}">
                      <input type="hidden" name="postal" value="${member.postal}">
                      <input type="hidden" name="address" value="${member.address}">
                      <input type="hidden" name="tel" value="${member.tel}">
                      <input type="hidden" name="email" value="${member.email}">
                      <input type="hidden" name="birthday" value="${member.birthday}">
                      <button class="btn btn-warning table__button--margin">更新</button>
                    </form>
                    <form action="ConfirmMember" method="post" style="display: inline">
                      <input type="hidden" name="memberId" value="${member.id}">
                      <input type="hidden" name="familyName" value="${member.familyName}">
                      <input type="hidden" name="name" value="${member.name}">
                      <input type="hidden" name="postal" value="${member.postal}">
                      <input type="hidden" name="address" value="${member.address}">
                      <input type="hidden" name="tel" value="${member.tel}">
                      <input type="hidden" name="email" value="${member.email}">
                      <input type="hidden" name="birthday" value="${member.birthday}">
                      <input type="hidden" name="mode" value="削除">
                      <input type="hidden" name="action" value="delete">
                      <button class="btn btn-danger table__button--margin">削除</button>
                    </form>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:if>
      </div>
    </div>
  </body>
</html>