<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>完了</title>
    <jsp:include page="../../jsp/include.jsp" flush="true" />
  </head>
  <body>
    <jsp:include page="../../jsp/template.jsp" flush="true" />
    <div class="container">
      <h1>${mode}完了</h1>
      <h3>会員ID : 
        <span>${member.id}</span>
      </h3>
      <h3>会員名 : 
        <span>${member.familyName}　${member.name}</span>
      </h3>
      <h3>の${mode}を行いました</h3>
    </div>
  </body>
</html>