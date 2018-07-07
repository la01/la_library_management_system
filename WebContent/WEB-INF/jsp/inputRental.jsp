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
        <h1>貸出</h1>
            <h1>返却</h1>
            <form action="confirmRentalView.html" method="post">
                <div class="row">
                    <div class="col-xs-2">
                        <label for="id">会員ID</label>
                        <input type="text" class="form-control" id="id" placeholder="000">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <label for="bookId1">図書ID</label>
                        <input type="text" class="form-control" id="bookId1" placeholder="000">
                    </div>
                    <div class="col-xs-2">
                        <label for="bookId2">図書ID</label>
                        <input type="text" class="form-control" id="bookId2" placeholder="000">
                    </div>
                    <div class="col-xs-2">
                        <label for="bookId3">図書ID</label>
                        <input type="text" class="form-control" id="bookId3" placeholder="000">
                    </div>
                    <div class="col-xs-2">
                        <label for="bookId4">図書ID</label>
                        <input type="text" class="form-control" id="bookId4" placeholder="000">
                    </div>
                    <div class="col-xs-2">
                        <label for="bookId5">図書ID</label>
                        <input type="text" class="form-control" id="bookId5" placeholder="000">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <button class="btn btn-primary form__button--margin form__button--padding">貸出返却</button>
                    </div>
                </div>
            </form>
    </div>
</body>
</html>