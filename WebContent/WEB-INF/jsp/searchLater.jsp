<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>遅延対応</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>遅延対応</h1>
      <h3>電話・メール対応が必要な一覧</h3>
      <hr>
      <c:forEach items="${tel_or_mail_list}" var="later" varStatus="status">
        <div class="panel-group" id="accordion1">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion1" href="#acc1_${status.count }">${status.count }. ${later.familyName } ${later.name }</a>
              </h3>
            </div>
            <div id="acc1_${status.count }" class="panel-collapse collapse">
              <div class="panel-body">
                <div class="row">
                  <div class="col-xs-2">
                    <label>電話番号</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.tel }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-2">
                    <label>メールアドレス</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.email }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-12">
                    <label>レンタルしている本</label>
                    <table class="table table-condensed">
                      <thead>
                        <tr>
                          <th>id</th>
                          <th>name</th>
                          <th>rental</th>
                          <th>return</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${later.bookList }" var="book">
                          <tr>
                            <td>${book.bookId }</td>
                            <td>${book.name }</td>
                            <td>${book.rentalDate }</td>
                            <td>${book.returnDate }</td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
      <h3>督促書類の郵送対応が必要な一覧</h3>
      <hr>
      <c:forEach items="${post_list}" var="later" varStatus="status">
        <div class="panel-group" id="accordion2">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion2" href="#acc2_${status.count }">${status.count }. ${later.familyName } ${later.name }</a>
              </h3>
            </div>
            <div id="acc2_${status.count }" class="panel-collapse collapse">
              <div class="panel-body">
                <div class="row">
                  <div class="col-xs-2">
                    <label>電話番号</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.tel }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-2">
                    <label>メールアドレス</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.email }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-2">
                    <label>郵便番号</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.tel }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-2">
                    <label>住所</label>
                  </div>
                  <div class="col-xs-10">
                    <label>${later.address }</label>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-12">
                    <label>レンタルしている本</label>
                    <table class="table table-condensed">
                      <thead>
                        <tr>
                          <th>id</th>
                          <th>name</th>
                          <th>rental</th>
                          <th>return</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${later.bookList }" var="book">
                          <tr>
                            <td>${book.bookId }</td>
                            <td>${book.name }</td>
                            <td>${book.rentalDate }</td>
                            <td>${book.returnDate }</td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="row">
                  <div class="col-xs-12">
                    <form action="Later" method="post">
                      <button class="btn btn-primary btn-block">印刷用ページに遷移</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </body>
</html>