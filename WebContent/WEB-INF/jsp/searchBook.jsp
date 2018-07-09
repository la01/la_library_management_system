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
        <h1>資料検索</h1>
        <form action="SearchBook" method="post">
            <div class="row">
                <div class="col-xs-2">
                    <label for="bookId">ID</label>
                    <input type="text" class="form-control" id="id" autocomplete="off">
                </div>
                <div class="col-xs-2">
                    <label for="isbn">ISBN番号</label>
                    <input type="text" class="form-control" id="isbn" autocomplete="off">
                </div>
                <div class="col-xs-7">
                    <label for="bookName">資料名</label>
                    <input type="text" class="form-control" id="bookName" autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <label for="code">分類コード</label>
                    <div class="row">
                        <div class="col-xs-12">
                            <select class="form-control" id="code">
                                <option value="0">総記</option>
                                <option value="1">哲学</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-xs-2">
                    <label for="author">著者</label>
                    <input type="text" class="form-control" id="author" autocomplete="off">
                </div>
                <div class="col-xs-3">
                    <label for="company">出版社</label>
                    <input type="text" class="form-control" id="company" autocomplete="off">
                </div>
                <div class="col-xs-4">
                    <label for="date">出版日</label>
                    <div class="row">
                        <div class="col-xs-4">
                            <select class="form-control" id="year">
                                <option>2018</option>
                                <option>1900</option>
                            </select>
                        </div>
                        <div class="col-xs-4">
                            <select class="form-control" id="month">
                                <option>1</option>
                                <option>12</option>
                            </select>
                        </div>
                        <div class="col-xs-4">
                            <select class="form-control" id="day">
                                <option>1</option>
                                <option>31</option>
                            </select>
                        </div>
                    </div>
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
                        <th>ID</th>
                        <th>ISBN番号</th>
                        <th>資料名</th>
                        <th>分類名</th>
                        <th>著者</th>
                        <th>出版社</th>
                        <th>出版日</th>
                        <th>入荷日</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>000</td>
                        <td>1234567890123</td>
                        <td>声に出して読みたい日本語</td>
                        <td>総記</td>
                        <td>山田太郎</td>
                        <td>竹書房</td>
                        <td>2018/07/06</td>
                        <td>2018/07/06</td>
                        <td>
                            <form action="InputBook" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmBook" method="post" style="display: inline">
                                <button class="btn btn-danger table__button--margin">削除</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>000</td>
                        <td>1234567890123</td>
                        <td>声に出して読みたい日本語</td>
                        <td>総記</td>
                        <td>山田太郎</td>
                        <td>竹書房</td>
                        <td>2018/07/06</td>
                        <td>2018/07/06</td>
                        <td>
                            <form action="InputBook" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmBook" method="post" style="display: inline">
                                <button class="btn btn-danger table__button--margin">削除</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>000</td>
                        <td>1234567890123</td>
                        <td>声に出して読みたい日本語</td>
                        <td>総記</td>
                        <td>山田太郎</td>
                        <td>竹書房</td>
                        <td>2018/07/06</td>
                        <td>2018/07/06</td>
                        <td>
                            <form action="InputBook" method="post" style="display: inline">
                                <button class="btn btn-warning table__button--margin">更新</button>
                            </form>
                            <form action="ConfirmBook" method="post" style="display: inline">
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