<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<label for="bookId">資料ID</label> <input type="text"
						class="form-control" id="id" name="id" value="${id }"
						autocomplete="off">
				</div>
				<div class="col-xs-2">
					<label for="isbn">ISBN番号</label> <input type="text"
						class="form-control" id="isbn" name="isbn" value="${isbn }"
						autocomplete="off">
				</div>
				<div class="col-xs-8">
					<label for="bookName">資料名</label> <input type="text"
						class="form-control" id="name" name="name" value="${name }"
						autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label for="category">分類コード</label>
					<div class="row">
						<div class="col-xs-12">
							<select class="form-control" id="category" name="category">
								<option value="-1"></option>
								<c:forEach var="category" items="${categoryList }"
									varStatus="status">
									<option value="${category.categoryCode}"
										<c:if test="${category.categoryCode == categoryCode }">selected="selected"</c:if>><c:out
											value="${category.categoryName }" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-5">
					<label for="author">著者</label> <input type="text"
						class="form-control" id="author" name="author" value="${author}"
						autocomplete="off">
				</div>
				<div class="col-xs-5">
					<label for="company">出版社</label> <input type="text"
						class="form-control" id="publisher" name="publisher"
						value="${publisher}" autocomplete="off">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<label for="from_publish_date">出版日(From)</label> <input type="date"
						class="form-control" id="from_publish_date"
						name="from_publish_date" value="${from_publish_date }">
				</div>
				<div class="col-xs-3">
					<label for="to_publish_date">出版日(To)</label> <input type="date"
						class="form-control" id="to_publish_date" name="to_publish_date"
						value="${to_publish_date }">
				</div>
				<div class="col-xs-3">
					<label for="date">貸出状況</label> <select class="form-control"
						id="rental" name="rental">
						<option value="0"
							<c:if test="${rental == 0}">selected="selected"</c:if>>全て</option>
						<option value="1"
							<c:if test="${rental == 1}">selected="selected"</c:if>>貸出可能</option>
						<option value="2"
							<c:if test="${rental == 2}">selected="selected"</c:if>>貸出不可</option>
					</select>
				</div>
				<div class="col-xs-3">
					<label for="date">資料の状態</label> <select class="form-control"
						id="status" name="status">
						<option value="0"
							<c:if test="${status == 0}">selected="selected"</c:if>>全て</option>
						<option value="1"
							<c:if test="${status == 1}">selected="selected"</c:if>>蔵書のみ</option>
						<option value="2"
							<c:if test="${status == 2}">selected="selected"</c:if>>処分済み</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<label for="from_added_date">入荷日(From)</label> <input type="date"
						class="form-control" id="from_added_date" name="from_added_date"
						value="${ from_added_date}">
				</div>
				<div class="col-xs-3">
					<label for="to_added_date">入荷日(To)</label> <input type="date"
						class="form-control" id="to_added_date" name="to_added_date"
						value="${ to_added_date}">
				</div>
				<div class="col-xs-3">
					<label for="from_removed_date">処分日(From)</label> <input type="date"
						class="form-control" id="from_removed_date"
						name="from_removed_date" value="${ from_removed_date}">
				</div>
				<div class="col-xs-3">
					<label for="to_removed_date">処分日(To)</label> <input type="date"
						class="form-control" id="to_removed_date" name="to_removed_date"
						value="${ to_removed_date}">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-primary form__button--margin btn-block">検索</button>
				</div>
			</div>
		</form>
		<div class="search__table--margin">
			<c:if test="${!empty result}">
				<h5>
					<span>${ fn:length( bookList ) }</span>件のデータが見つかりました
				</h5>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>資料ID</th>
							<th>ISBN番号</th>
							<th>資料名</th>
							<th>分類名</th>
							<th>著者</th>
							<th>出版社</th>
							<th>貸出状況</th>
							<th>出版日</th>
							<th>入荷日</th>
							<th>処分日</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${bookList }" varStatus="status">
							<tr>
								<td><c:out value="${book.id }" /></td>
								<td><c:out value="${book.ISBNCode }" /></td>
								<td><c:out value="${book.name }" /></td>
								<td><c:out value="${book.categoryName }" /></td>
								<td><c:out value="${book.author }" /></td>
								<td><c:out value="${book.publisher }" /></td>
								<td><c:if test='${book.statusCode == 1}'>貸出可能</c:if> <c:if
										test='${book.statusCode == 2}'>貸出不可</c:if></td>
								<td><c:out value="${book.publishedDay }" /></td>
								<td><c:out value="${book.addedDay }" /></td>
								<td><c:out value="${book.removedDay }" /></td>
								<td>
									<form action="InputBook" method="post" style="display: inline">
										<input type="hidden" name="id" value="${book.id }"> <input
											type="hidden" name="isbn" value="${book.ISBNCode }"> <input
											type="hidden" name="name" value="${book.name }"> <input
											type="hidden" name="categoryName"
											value="${book.categoryName }"> <input type="hidden"
											name="author" value="${book.author }"> <input
											type="hidden" name="publisher" value="${book.publisher }">
										<input type="hidden" name="publishedDay"
											value="${book.publishedDay }">
										<button class="btn btn-warning table__button--margin">更新</button>
									</form>
									<form action="ConfirmBook" method="post"
										style="display: inline">
										<input type="hidden" name="id" value="${book.id }"> <input
											type="hidden" name="isbn" value="${book.ISBNCode }"> <input
											type="hidden" name="name" value="${book.name }"> <input
											type="hidden" name="categoryCode"
											value="${book.categoryName }"> <input type="hidden"
											name="author" value="${book.author }"> <input
											type="hidden" name="publisher" value="${book.publisher }">
										<input type="hidden" name="publishedDay"
											value="${book.publishedDay }">
										<button class="btn btn-danger table__button--margin" <c:if test="${book.removedDay != NULL}">disabled="disabled"</c:if>>削除</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>