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
      <h1>職員ログイン</h1>
      <form action="Login" method="post" class="form-horizontal">
        <div class="form-group">
          <label class="col-sm-2 control-label" for="id">ID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="id" name="id" autocomplete="off">
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="password">パスワード</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="passwd" autocomplete="off">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-2">
            <button class="btn btn-primary form__button--margin btn-block">ログイン</button>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>