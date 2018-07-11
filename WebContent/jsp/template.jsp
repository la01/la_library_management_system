<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container-fluid">
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand">新宿図書館 / 図書管理システム</label>
		</div>
		<div id="navbar-collapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><c:if test="${!empty login}">
						<a href="#" class="navbar__dropdown--margin"
							data-toggle="dropdown">職員でログイン中</a>
						<ul class="dropdown-menu dropdown-block" role="menu">
							<li><a href="Logout">Logout</a></li>
						</ul>
					</c:if> <c:if test="${empty login}">
						<a href="#" class="navbar__dropdown--margin"
							data-toggle="dropdown">職員はこちら</a>
						<ul class="dropdown-menu dropdown-block" role="menu">
							<li><a href="Login">Login</a></li>
						</ul>
					</c:if></li>
			</ul>
		</div>
	</nav>
</div>
<div class="wrapper">
	<div class="sidebar-wrapper">
		<div id="sidebar">
			<ul class="sidebar-nav">
				<li><a href="./" class="bar-1"> <span class="sidebar-icon">
							<i class="fas fa-home"></i>
					</span> <span class="sidebar-title">ホーム</span>
				</a></li>
				<li><a class="accordion-toggle collapsed toggle-switch bar-2"
					data-toggle="collapse" href="#submenu-1"> <span
						class="sidebar-icon"> <i class="fa fa-users"></i>
					</span> <span class="sidebar-title">会員メニュー</span> <b class="caret"></b>
				</a>
					<ul id="submenu-1" class="panel-collapse collapse panel-switch"
						role="menu">
						<li><a href="SearchMember" class="bar-2"> <i
								class="fa fa-caret-right"></i>会員検索・更新・削除
						</a></li>
						<li><a href="InputMember" class="bar-2"> <i
								class="fa fa-caret-right"></i>会員登録
						</a></li>
					</ul></li>
				<li><a class="accordion-toggle collapsed toggle-switch bar-3"
					data-toggle="collapse" href="#submenu-2"> <span
						class="sidebar-icon"> <i class="fas fa-book"></i>
					</span> <span class="sidebar-title">資料メニュー</span> <b class="caret"></b>
				</a>
					<ul id="submenu-2" class="panel-collapse collapse panel-switch"
						role="menu">
						<li><a href="SearchBook" class="bar-3"> <i
								class="fa fa-caret-right"></i>資料検索・更新・削除
						</a></li>
						<li><a href="InputBook" class="bar-3"> <i
								class="fa fa-caret-right"></i>資料登録
						</a></li>
					</ul></li>
				<li><a class="accordion-toggle collapsed toggle-switch bar-4"
					data-toggle="collapse" href="#submenu-3"> <span
						class="sidebar-icon"> <i class="fas fa-exchange-alt"></i>
					</span> <span class="sidebar-title">レンタルメニュー</span> <b class="caret"></b>
				</a>
					<ul id="submenu-3" class="panel-collapse collapse panel-switch"
						role="menu">
						<li><a href="InputRental" class="bar-4"> <i
								class="fa fa-caret-right"></i>貸出
						</a></li>
						<li><a href="InputReturn" class="bar-4"> <i
								class="fa fa-caret-right"></i>返却
						</a></li>
						<li><a href="SearchRental" class="bar-4"> <i
								class="fa fa-caret-right"></i>履歴
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>