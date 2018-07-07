<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
</head>
<body>
	<jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="page-content-wrapper">
        <h1>会員検索</h1>
            <form>
                <div class="row">
                    <div class="col-xs-2">
                        <label for="id">ID</label>
                        <input type="text" class="form-control" id="id" placeholder="000">
                    </div>
                    <div class="col-xs-3">
                        <label for="lastName">苗字</label>
                        <input type="text" class="form-control" id="lastName" placeholder="山田">

                    </div>
                    <div class="col-xs-3">
                        <label for="fisrtName">名前</label>
                        <input type="text" class="form-control" id="fisrtName" placeholder="太郎">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <label for="zip">郵便番号</label>
                        <input type="text" class="form-control" id="zip" placeholder="0000000">
                    </div>
                    <div class="col-xs-6">
                        <label for="address">住所</label>
                        <input type="text" class="form-control" id="address" placeholder="東京都新宿区">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <label for="phone">電話番号</label>
                        <input type="text" class="form-control" id="phone" placeholder="000-0000-0000">
                    </div>
                    <div class="col-xs-3">
                        <label for="InputId">メールアドレス</label>
                        <input type="text" class="form-control" id="InputId" placeholder="my@address.com" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <button class="btn btn-primary form__button--margin form__button--padding">検索</button>
                    </div>
                </div>
            </form>
            <div class="search__table--margin">
                <table class="table table-condensed">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>メールアドレス</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>000</th>
                            <td>山田　太郎</td>
                            <td>my@address.com</td>
                            <td>
                                <form action="inputMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-warning table__button--margin">更新</button>
                                </form>
                                <form action="confirmMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-danger table__button--margin">削除</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th>000</th>
                            <td>山田　太郎</td>
                            <td>my@address.com</td>
                            <td>
                                <form action="inputMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-warning table__button--margin">更新</button>
                                </form>
                                <form action="confirmMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-danger table__button--margin">削除</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th>000</th>
                            <td>山田　太郎</td>
                            <td>my@address.com</td>
                            <td>
                                <form action="inputMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-warning table__button--margin">更新</button>
                                </form>
                                <form action="confirmMemberView.html" method="post" style="display: inline">
                                    <button class="btn btn-danger table__button--margin">削除</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>