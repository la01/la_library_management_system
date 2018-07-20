<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>フロアマップ</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
</head>
<body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>フロアマップ</h1>
      <div style="text-align:center">
        <img border="2" alt="フロアマップ" src="${imgSource}"><br><br>
        <div class="form_button--margin">
          <button type="button" class="btn btn-default form__button form__button--padding" onclick="history.back()">戻る</button>
        </div>
      </div>
    </div>
</body>
</html>