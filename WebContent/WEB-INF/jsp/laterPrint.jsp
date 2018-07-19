<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>検索</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <div class="hidden-print border">
      <span>このページを印刷してください  ピンクでで囲まれた部分は印刷画面に<b>表示されません</b></span><br>
      <span>Google Chromeでヘッダー、フッターを消して印刷する場合、</span><br>
      <span>1.右クリックから「印刷」をクリックする</span><br>
      <span>2.「詳細設定」を開く</span><br>
      <span>3.「オプション」欄の「ヘッダーとフッター」のチェックを外し、「印刷」をクリックする</span><br>
    </div>
    <div class="container">
      <h5><b>${familyName} ${name} 様</b></h5>
      <h5 class="text-right"><b>${date }</b></h5>
      <h1 class="text-center">図書館からのお知らせ（督促）</h1>
      <div class="print__block--magin"></div>
      <h4>平素は当図書館をご利用いただき、心より御礼申し上げます。</h4>
      <h4>さて、現在お貸し出し中の図書に関しまして、期限切れが御座いますので速やかにご返却頂きますよう、宜しくお願い申し上げます。</h4>
      <h4>なお、処理の都合上、既にご返却いただいている場合は、ご理解のうえご容赦くださいますようお願い申し上げます。</h4>
      <div class="print__block--magin"></div>
      <h4 class="text-center">記</h4>
      <table class="table table-condensed">
        <thead>
          <tr>
            <th>書名</th>
            <th>貸出開始日</th>
            <th>返却予定日</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${books }" var="book">
            <tr>
              <td>${book.name }</td>
              <td><fmt:formatDate value="${book.rentalDate }" pattern="yyyy年MM月dd日" /></td>
              <td><fmt:formatDate value="${book.returnDate }" pattern="yyyy年MM月dd日" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <h4 class="text-right">以上</h4>
    </div>
  </body>
</html>