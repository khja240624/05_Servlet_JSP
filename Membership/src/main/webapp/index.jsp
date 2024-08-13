<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 관리 프로그램</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <div class="container">
    <h1>회원 관리 프로그램</h1>
    <div class="menu">
      <div class="menu-item"><a href="/signUp">회원 가입(추가)</a></div>
      <div class="menu-item"><a href="/selectList">회원 전체 조회</a></div>
    </div>
  </div>

  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert( "${message}" );    
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>