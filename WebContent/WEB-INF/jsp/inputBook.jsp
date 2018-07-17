<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>入力</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
    <script type="text/javascript" src="./js/inputBook.js"></script>
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="page-content-wrapper">
      <h1>資料${mode}</h1>
      <form action="ConfirmBook" method="post">
        <input type="hidden" name="mode" value="${mode }">
        <input type="hidden" name="action" value="${action }">
        <div class="row">
          <div class="col-xs-2">
            <label for="id">資料ID</label>
            <input type="text" class="form-control" name="id" value="${id}" readonly>
          </div>
          <div class="col-xs-2">
            <label for="isbn">ISBN番号</label>
            <input type="text" class="form-control" name="isbn" value="${isbn}" autocomplete="off" pattern="[0-9]{13}" maxlength="13" title="半角数字13文字で入力してください。" required
            <c:if test="${action == 'update' || action == 'delete'}">readonly</c:if>>
          </div>
          <div class="col-xs-8">
            <label for="bookName">資料名</label>
            <input type="text" class="form-control" name="name" value="${name}" autocomplete="off" maxlength="100" title="100文字以内で入力してください。"
            <c:if test="${action == 'delete'}">readonly</c:if> required>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label for="categoryCode">分類コード</label>
            <div class="row">
              <div class="col-xs-12">
                <select class="form-control" name="categoryCode" <c:if test="${action == 'delete'}">readonly</c:if>>
                  <c:forEach var="category" items="${categoryList }" varStatus="status">
                    <option value="${category.categoryCode}"
                      <c:if test="${category.categoryCode == categoryCode }">selected="selected"</c:if>
                      <c:if test="${action == 'delete' && category.categoryCode != categoryCode}">disabled="disabled"</c:if>>
                      <c:out value="${category.categoryName }" />
                    </option>
                  </c:forEach>
                </select>
              </div>
            </div>
          </div>
          <div class="col-xs-5">
            <label for="author">著者</label>
            <input type="text" class="form-control" name="author" value="${author}" autocomplete="off" maxlength="20" title="20文字以内で入力してください。"
            <c:if test="${action == 'delete'}">readonly</c:if> required>
          </div>
          <div class="col-xs-5">
            <label for="publisher">出版社</label>
            <input type="text" class="form-control" name="publisher" value="${publisher}" autocomplete="off" maxlength="20" title="20文字以内で入力してください。"
            <c:if test="${action == 'delete'}">readonly</c:if> required>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-3">
            <label for="publishedDay">出版日(From)</label>
            <input type="date" class="form-control" name="publishedDay" value="${publishedDay }" <c:if test="${action == 'delete'}">readonly</c:if> required>
          </div>
          <c:if test="${action == 'insert'}">
            <div class="col-xs-3">
              <label for="number">入荷冊数</label>
              <input type="text" class="form-control" name="number" autocomplete="off" pattern="^[0-9]+$" title="半角数字で入力してください。" required>
            </div>
          </c:if>
        </div>
        <c:if test="${action == 'delete'}">
         <div class="row">
           <div class="col-xs-8">
             <label for="note">廃棄理由</label>
             <input type="text" class="form-control" name="note" autocomplete="off" maxlength="100" title="100文字以内で入力してください。">
           </div>
         </div>
        </c:if>
        <div class="row">
          <div class="col-xs-2">
            <button class="btn btn-primary form__button--margin btn-block">${mode}</button>
          </div>
          <c:if test="${action == 'insert'}">
            <div class="col-xs-2">
              <button type="button" onclick="getDataFromISBN()" class="btn btn-primary form__button--margin btn-block">ISBN番号から取得</button>
            </div>
          </c:if>
          <c:if test="${action == 'update'|| action == 'delete'}">
            <div class="col-xs-2">
              <button type="button" onclick="history.back()" class="btn btn-default form__button--margin btn-block">戻る</button>
            </div>
          </c:if>
        </div>
      </form>
      <form action="ISBNSearch" method="post" name="ISBNForm">
        <input type="hidden" id="searchISBN" name="searchISBN">
      </form>
    </div>
  </body>
</html>