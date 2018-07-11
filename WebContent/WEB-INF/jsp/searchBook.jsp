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
					<label for="code">分類コード</label>
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
				<div class="col-xs-4">
					<label for="author">著者</label> <input type="text"
						class="form-control" id="author" name="author" value="${author}"
						autocomplete="off">
				</div>
				<div class="col-xs-4">
					<label for="company">出版社</label> <input type="text"
						class="form-control" id="publisher" name="publisher"
						value="${publisher}" autocomplete="off">
				</div>
				<div class="col-xs-2">
					<label for="date">貸出状況</label> <select class="form-control"
						id="rental">
						<option>全て</option>
						<option>貸出可能</option>
						<option>貸出不可</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<label for="from_publish_date">出版日(From)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="from_publish_year">
								<option>2018</option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_publish_month">
								<option>12</option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_publish_day">
								<option>31</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-4">
					<label for="to_publish_date">出版日(To)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="to_publish_year">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_publish_month">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_publish_day">
								<option></option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<label for="date">資料の状態</label> <select class="form-control"
						id="status">
						<option>全て</option>
						<option>蔵書のみ</option>
						<option>処分済み</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<label for="from_add_date">入荷日(From)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="from_add_year">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_add_month">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_add_day">
								<option></option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-4">
					<label for="to_add_date">入荷日(To)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="to_add_year">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_add_month">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_add_day">
								<option></option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<label for="from_remove_date">処分日(From)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="from_remove_year">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_remove_month">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="from_remove_day">
								<option></option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-xs-4">
					<label for="to_remove_date">処分日(To)</label>
					<div class="row">
						<div class="col-xs-4">
							<select class="form-control" id="to_remove_year">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_remove_month">
								<option></option>
							</select>
						</div>
						<div class="col-xs-4">
							<select class="form-control" id="to_remove_day">
								<option></option>
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
							<th>出版日</th>
							<th>入荷日</th>
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
								<td><c:out value="${book.publishedDay }" /></td>
								<td><c:out value="${book.addedDay }" /></td>
								<td>
									<form action="InputBook" method="post" style="display: inline">
										<button class="btn btn-warning table__button--margin">更新</button>
									</form>
									<form action="ConfirmBook" method="post"
										style="display: inline">
										<button class="btn btn-danger table__button--margin">削除</button>
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