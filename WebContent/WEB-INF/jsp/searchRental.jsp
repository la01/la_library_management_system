<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
    <script type="text/javascript" src="./js/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="./js/tablesorter.js"></script>
</head>
<body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="page-content-wrapper">
        <h1>履歴検索</h1>
        <form action="SearchRental" method="post">
            <div class="row">
                <div class="col-xs-2">
                    <label for="memberId">会員ID</label>
                    <input type="text" class="form-control" id="memberId" autocomplete="off">
                </div>
                <div class="col-xs-2">
                    <label for="bookId">資料ID</label>
                    <input type="text" class="form-control" id="bookId" autocomplete="off">
                </div>
                <div class="col-xs-2">
                    <label for="bookName">ISBN番号</label>
                    <input type="text" class="form-control" id="isbn" autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <label for="bookName">資料名</label>
                    <input type="text" class="form-control" id="bookName" autocomplete="off">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <div class="checkbox">
                    <label><input type="checkbox" value="late" id="late">返却遅延</label>
                    </div>
                </div>
                <div class="col-xs-2">
                    <div class="checkbox">
                    <label><input type="checkbox" value="notReturned" id="notReturned">未返却</label>
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
            <h5>項目名をクリックすることでソートされます</h5>
            <table class="table table-condensed" id="resultTable">
                <thead>
                    <tr>
                        <th>貸出ID</th>
                        <th>会員ID</th>
                        <th>資料ID</th>
                        <th>資料名</th>
                        <th>貸出年月日</th>
                        <th>返却期日</th>
                        <th>返却年月日</th>
                        <th>返却遅延</th>
                        <th>未返却</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>001</td>
                        <td>300</td>
                        <td>000</td>
                        <td>声に出して読みたい日本語</td>
                        <td>2018/05/09</td>
                        <td>2018/07/19</td>
                        <td>2018/07/12</td>
                        <td>いいえ</td>
                        <td>いいえ</td>
                    </tr>
                    <tr>
                        <td>002</td>
                        <td>200</td>
                        <td>000</td>
                        <td>声に出して読みたい日本語</td>
                        <td>2018/06/09</td>
                        <td>2018/07/24</td>
                        <td>2018/07/13</td>
                        <td>いいえ</td>
                        <td>いいえ</td>
                    </tr>
                    <tr>
                        <td>003</td>
                        <td>000</td>
                        <td>100</td>
                        <td>声に出して読みたい日本語</td>
                        <td>2018/07/09</td>
                        <td>2018/07/24</td>
                        <td></td>
                        <td>はい</td>
                        <td>はい</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>