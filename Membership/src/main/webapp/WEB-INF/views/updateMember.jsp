<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OOO 회원 정보 수정</title>
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
    <h1>회원 정보 수정</h1>
    <form action="/update/member" method="POST">
      <div class="form-group">
        <h4>${member.name}</h4>
      </div>
      <div class="form-group">
        <input type="tel" id="phone" name="phone" placeholder="휴대폰 번호 (- 제외)" 
        pattern="[0-9]{11}" required value="${member.phone}">
      </div>

      <div>
        <a href="/selectList" class="button">목록으로</a>
        <button type="submit" class="button">수정</button>
      </div>

      <input type="hidden" name="index" value="${param.index}">
    </form>
  </div>

</body>
</html>