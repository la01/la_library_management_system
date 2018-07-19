<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="./">新宿図書館 / 図書管理システム</a>
    </div>
    <div class="collapse navbar-collapse" id="navbar">
      <c:if test="${!empty login}">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="sidebar-icon">
                <i class="fa fa-users"></i>
              </span>会員
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="SearchMember">検索・更新・削除</a>
              </li>
              <li>
                <a href="InputMember">登録</a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="sidebar-icon">
                <i class="fas fa-book"></i>
              </span>資料
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="SearchBook">検索・更新・削除</a>
              </li>
              <li>
                <a href="InputBook">登録</a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="sidebar-icon">
                <i class="fas fa-exchange-alt"></i>
              </span>レンタル
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="InputRental">貸出</a>
              </li>
              <li>
                <a href="InputReturn">返却</a>
              </li>
              <li>
                <a href="SearchRental">履歴</a>
              </li>
            </ul>
          </li>
          <li><a href="Later">遅延対応</a></li>
        </ul>
      </c:if>
      <c:if test="${empty login}">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="sidebar-icon">
                <i class="fas fa-book"></i>
              </span>資料
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="SearchBook">検索</a>
              </li>
            </ul>
          </li>
        </ul>
      </c:if>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <c:if test="${!empty login}">
            <a href="#" data-toggle="dropdown">職員でログイン中</a>
            <ul class="dropdown-menu dropdown-block">
              <li>
                <a href="Logout">Logout</a>
              </li>
            </ul>
          </c:if>
          <c:if test="${empty login}">
            <a href="#" data-toggle="dropdown">職員はこちら</a>
            <ul class="dropdown-menu dropdown-block">
              <li>
                <a href="Login">Login</a>
              </li>
            </ul>
          </c:if>
        </li>
      </ul>
    </div>
  </div>
</nav>