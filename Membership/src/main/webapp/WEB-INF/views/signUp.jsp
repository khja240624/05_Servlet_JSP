<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 가입(추가)</title>
  <link rel="stylesheet" href="/resources/css/main.css">
  <style>
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .form-group {
        width: 100%;
        max-width: 300px;
        margin-bottom: 15px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>회원 가입(추가)</h1>
    <form action="/signUp" method="POST">
      <div class="form-group">
        <input type="text" id="name" name="name" placeholder="이름" required>
      </div>
      <div class="form-group">
        <input type="tel" id="phone" name="phone" placeholder="휴대폰 번호 (- 제외)" pattern="[0-9]{11}" required>
      </div>

      <div>
        <a href="/" class="button">돌아가기</a>
        <button type="submit" class="button">가입하기</button>
      </div>
    </form>
  </div>

  <c:if test="${not empty sessionScope.message}" >
      <script>
        alert( "${message}" );    
      </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>