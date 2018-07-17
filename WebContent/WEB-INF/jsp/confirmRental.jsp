<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>確認</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>${mode}確認</h1>
      <form action="DoneRental" method="post">
        <input type="hidden" name="mode" value="${mode}">
        <input type="hidden" name="action" value="${action}">
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
              <td>${memberId }
                <input type="hidden" name="memberId" value="${memberId}" >
              </td>
            </tr>
            <c:forEach items="${bookId }" var="item" varStatus="status">
              <tr>
                <th>資料ID</th>
                <td>${item }
                  <input type="hidden" name="${'bookId' += status.count}" value="${item}">
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <h3>上記の資料を${mode}します</h3>
        <div class="form_button--margin">
          <button class="btn btn-primary form__button form__button--padding">OK</button>
          <button type="button" class="btn btn-default form__button form__button--padding" onclick="history.back()">戻る</button>
        </div>
      </form>
    </div>
  </body>
</html>