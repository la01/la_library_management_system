<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>ログイン</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>遅延対応</h1>
      <h2>電話・メール対応が必要な一覧</h2>
      <c:forEach items="${tel_or_mail_list}" var="later">
        <div class="row">
          <h4>name:${later.familyName } ${later.name }</h4>
          <h4>tel:${later.tel }</h4>
          <h4>email:${later.email }</h4>
          <h5>bookList</h5>
          <table>
            <thead>
              <tr>
                <th>id</th>
                <th>name</th>
                <th>rental</th>
                <th>return</th>
              </tr>
            </thead>
              <c:forEach items="${later.bookList }" var="book">
                <td>${book.bookId }</td>
                <td>${book.name }</td>
                <td>${book.rentalDate }</td>
                <td>${book.returnDate }</td>
              </c:forEach>
            <tbody>
            </tbody>
          </table>
        </div>
      </c:forEach>
      <h2>督促書類の郵送対応が必要な一覧</h2>
      <c:forEach items="${post_list}" var="later">
        <div class="row">
          <h4>name:${later.familyName } ${later.name }</h4>
          <h4>tel:${later.tel }</h4>
          <h4>email:${later.email }</h4>
          <span>bookList</span>
          <table>
            <thead>
              <tr>
                <th>id</th>
                <th>name</th>
                <th>rental</th>
                <th>return</th>
              </tr>
            </thead>
              <c:forEach items="${later.bookList }" var="book">
                <td>${book.bookId }</td>
                <td>${book.name }</td>
                <td>${book.rentalDate }</td>
                <td>${book.returnDate }</td>
              </c:forEach>
            <tbody>
            </tbody>
          </table>
        </div>
      </c:forEach>
    </div>
  </body>
</html>