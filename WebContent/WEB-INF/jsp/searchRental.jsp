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
    <script type="text/javascript" src="./js/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="./js/tablesorter.js"></script>
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>履歴検索</h1>
      <form action="SearchRental" method="post">
        <div class="row">
          <div class="col-xs-2">
            <label for="memberId">会員ID</label>
            <input type="text" class="form-control" name="memberId" value="${memberId}" autocomplete="off" pattern="^[0-9]+$" title="半角数字で入力してください。">
          </div>
          <div class="col-xs-2">
            <label for="bookId">資料ID</label>
            <input type="text" class="form-control" name="bookId" value="${bookId}" autocomplete="off" pattern="^[0-9]+$" title="半角数字で入力してください。">
          </div>
          <div class="col-xs-2">
            <label for="isbn">ISBN番号</label>
            <input type="text" class="form-control" name="isbn" value="${isbn}" autocomplete="off" pattern="^[0-9]+$" maxlength="13"title="半角数字13文字以内で入力してください。">
          </div>
          <div class="col-xs-6">
            <label for="name">資料名</label>
            <input type="text" class="form-control" name="name" value="${name}" autocomplete="off" maxlength="100" title="100文字以内で入力してください。">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-3">
            <label for="fromDay">貸出日(From)</label>
            <input type="date" class="form-control" value="${fromDay}" name="fromDay">
          </div>
          <div class="col-xs-3">
            <label for="toDay">貸出日(To)</label>
            <input type="date" class="form-control" name="toDay" value="${toDay}">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="later" name="later"
                <c:if test="${!empty later }">checked</c:if>>返却遅延
              </label>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="noReturn" name="noReturn"
                <c:if test="${!empty noReturn }">checked</c:if>>未返却
              </label>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <button class="btn btn-primary form__button--margin btn-block">検索</button>
          </div>
        </div>
      </form>
    </div>
    <div class="container-fluid">
      <div class="search__table--margin">
        <c:if test="${!empty result }">
          <h5>
            <span>${ fn:length( historyList ) }</span>件のデータが見つかりました
          </h5>
          <h5>項目名をクリックすることでソートされます</h5>
          <table class="table table-condensed" id="resultTable">
            <thead>
              <tr>
              <th>貸出ID</th>
              <th>会員ID</th>
              <th>資料ID</th>
              <th>資料名</th>
              <th>貸出年月日</th>
              <th>返却期日</th>
              <th>返却年月日</th>
              <th>返却遅延</th>
              <th>未返却</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="history" items="${historyList }" varStatus="status">
                <tr>
                <td>${history.rentalId }</td>
                <td>${history.bookId }</td>
                <td>${history.memberId }</td>
                <td>${history.name }</td>
                <td>${history.rentalDate }</td>
                <td>${history.limitDate }</td>
                <td>${history.returnDate }</td>
                <td>
                  <c:if test="${history.later && history.returnDate == null}">はい</c:if>
                  <c:if test="${history.later && history.returnDate != null}">はい(返却済み)</c:if>
                  <c:if test="${!history.later }">いいえ</c:if>
                </td>
                <td>
                  <c:if test="${history.noReturn }">はい</c:if>
                  <c:if test="${!history.noReturn }">いいえ</c:if>
                </td>
              </c:forEach>
            </tbody>
          </table>
        </c:if>
      </div>
    </div>
  </body>
</html>