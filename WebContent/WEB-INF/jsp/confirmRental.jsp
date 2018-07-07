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
        <h1>確認</h1>
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
                        <th>図書ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>図書ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>図書ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>図書ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>図書ID</th>
                        <td>000</td>
                    </tr>
                </tbody>
            </table>
            <label>上記の図書を貸出します</label>
            <label>上記の図書を返却します</label>
            <div class="form_button--margin">
                <button class="btn btn-primary form__button form__button--padding">OK</button>
            </div>
        </form>
    </div>
</body>
</html>