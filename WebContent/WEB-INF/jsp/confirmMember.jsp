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
        <h1>登録確認/更新確認/削除確認</h1>
        <form action="DoneMember" method="post">
            <table class="table">
                <thead>
                    <tr>
                        <th>項目</th>
                        <th>情報</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td>000</td>
                    </tr>
                    <tr>
                        <th>姓名</th>
                        <td>山田太郎</td>
                    </tr>
                    <tr>
                        <th>郵便番号</th>
                        <td>000-0000</td>
                    </tr>
                    <tr>
                        <th>住所</th>
                        <td>東京都新宿区</td>
                    </tr>
                    <tr>
                        <th>電話番号</th>
                        <td>000-0000-0000</td>
                    </tr>
                    <tr>
                        <th>メールアドレス</th>
                        <td>my@address.com</td>
                    </tr>
                </tbody>
            </table>
            <h3>上記のデータで更新します/上記のデータを削除します/上記のデータを登録します</h3>
            <div class="form_button--margin">
                <button class="btn btn-primary form__button form__button--padding">OK</button>
            </div>
        </form>
    </div>
</body>
</html>