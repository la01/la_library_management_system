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
        <h1>貸出確認/返却確認</h1>
        <form action="DoneRental" method="post">
            <table class="table">
                <thead>
                    <tr>
                        <th>項目</th>
                        <th>情報</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>会員ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>資料ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>資料ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>資料ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>資料ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>資料ID</th>
                        <td>000</td>
                    </tr>
                </tbody>
            </table>
            <h3>上記の資料を貸出します/上記の資料を返却します</h3>
            <div class="form_button--margin">
                <button class="btn btn-primary form__button form__button--padding">OK</button>
                <button type="button" class="btn btn-default form__button form__button--padding">戻る</button>
            </div>
        </form>
    </div>
</body>
</html>