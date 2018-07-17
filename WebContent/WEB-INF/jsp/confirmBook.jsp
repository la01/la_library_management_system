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
      <form action="DoneBook" method="post">
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
            <c:if test="${!action.equals('insert')}">
              <tr>
                <th>資料ID</th>
                <td>${id} 
                <input type="hidden" name="id" value="${id}">
                </td>
              </tr>
            </c:if>
            <tr>
              <th>ISBN番号</th>
              <td>
              <c:out value="${isbn}" />
              <input type="hidden" name="isbn" value="${isbn}">
            </tr>
            <tr>
              <th>資料名</th>
              <td>
              <c:out value="${name}" />
              <input type="hidden" name="name" value="${name}">
              </td>
            </tr>
            <tr>
              <th>分類</th>
              <td>
              <c:out value="${categoryName}" />
              <input type="hidden" name="categoryCode" value="${categoryCode }">
              <input type="hidden" name="categoryName" value="${categoryName}">
              </td>
            </tr>
            <tr>
              <th>著者</th>
              <td>
              <c:out value="${author}" />
              <input type="hidden" name="author" value="${author}">
              </td>
            </tr>
            <tr>
              <th>出版社</th>
              <td>
              <c:out value="${publisher}" />
              <input type="hidden" name="publisher" value="${publisher}">
              </td>
            </tr>
            <tr>
              <th>出版日</th>
              <td>
              <c:out value="${publishedDay}" />
              <input type="hidden" name="publishedDay" value="${publishedDay}">
              </td>
            </tr>
            <c:if test="${action.equals('insert')}">
              <tr>
                <th>入荷冊数</th>
                <td>
                <c:out value="${number}" />
                <input type="hidden" name="number" value="${number}">
                </td>
              </tr>
            </c:if>
          </tbody>
        </table>
        <h3>上記のデータを${mode}します</h3>
        <div class="form_button--margin">
          <button class="btn btn-primary form__button form__button--padding">OK</button>
          <button type="button" class="btn btn-default form__button form__button--padding" onclick="history.back()">戻る</button>
        </div>
      </form>
    </div>
  </body>
</html>