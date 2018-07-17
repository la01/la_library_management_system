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
    <div class="page-content-wrapper">
      <h1>職員ログイン</h1>
      <form action="Login" method="post">
        <div class="row">
          <div class="col-xs-2">
            <label for="id">ID</label>
            <input type="text" class="form-control" name="id" autocomplete="off">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label for="passwd">パスワード</label>
            <input type="password" class="form-control" name="passwd" autocomplete="off">
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <button class="btn btn-primary form__button--margin btn-block">ログイン</button>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>