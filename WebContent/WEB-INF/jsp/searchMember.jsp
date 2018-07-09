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
        <form action="SearchMember" action="post">
            <div class="row">
                <div class="col-xs-2">
                    <label for="memberId">会員ID</label>
                    <input type="text" class="form-control" id="memberId" autocomplete="off">
                </div>
                <div class="col-xs-3">
                    <label for="lastName">苗字</label>
                    <input type="text" class="form-control" id="lastName" autocomplete="off">

                </div>
                <div class="col-xs-3">
                    <label for="fisrtName">名前</label>
                    <input type="text" class="form-control" id="fisrtName" autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <label for="zip">郵便番号</label>
                    <input type="text" class="form-control" id="zip" placeholder="000-0000" autocomplete="off">
                </div>
                <div class="col-xs-6">
                    <label for="address">住所</label>
                    <input type="text" class="form-control" id="address" autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <label for="phone">電話番号</label>
                    <input type="text" class="form-control" id="phone" placeholder="000-0000-0000" autocomplete="off">
                </div>
                <div class="col-xs-3">
                    <label for="mail">メールアドレス</label>
                    <input type="text" class="form-control" id="mail" required autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <button class="btn btn-primary form__button--margin btn-block">検索</button>
                </div>
            </div>
        </form>
        <div class="search__table--margin">
            <h5><span>3</span>件のデータが見つかりました</h5>
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>会員ID</th>
                        <th>姓名</th>
                        <th>郵便番号</th>
                        <th>電話番号</th>
                        <th>メールアドレス</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>000</td>
                        <td>山田　太郎</td>
                        <td>000-0000</td>
                        <td>080-1234-5678</td>
                        <td>my@address.com</td>
                        <td>
                            <form action="InputMember" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmMember" method="post" style="display: inline">
                                <button class="btn btn-danger table__button--margin">削除</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>000</td>
                        <td>山田　太郎</td>
                        <td>000-0000</td>
                        <td>080-1234-5678</td>
                        <td>my@address.com</td>
                        <td>
                            <form action="InputMember" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmMember" method="post" style="display: inline">
                                <button class="btn btn-danger table__button--margin">削除</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>000</td>
                        <td>山田　太郎</td>
                        <td>000-0000</td>
                        <td>080-1234-5678</td>
                        <td>my@address.com</td>
                        <td>
                            <form action="InputMember" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmMember" method="post" style="display: inline">
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