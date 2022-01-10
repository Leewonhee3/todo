<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
	</head>
	
	<body>
	
		<div class="container">
			
			<br>
			<br>
			<br>
			<br>
			
			<div class="row text-center">
	  			
		  		<div class="col"></div>
		  		
		  		<div class="col">
		  			
		  			<h1>
		  		
			  			<p>${loginMember.memberId}님 정말로 탈퇴하시겠습니까?</p>
			  		
			  		</h1>
			  		
			  			<br>
			  		 	<br>
			  		 	<br>
			  		
			  		<h6>
			  		
			  		 	<p>탈퇴시 계정과 데이터는 복구되지 않습니다.</p>
			  			<p>탈퇴 하시려면 비밀번호를 입력해 주십시오.</p>
			  		
			  		</h6>
			  		
		  		</div>
		  		
		  		<div class="col"></div>
		
			</div>
			
			<br>
			<br>
			
			<div class="row">
	  			
		  		<div class="col"></div>
		  		
		  		<div class="col">
		  			
		  			<form class="center-block text-center" method="post" action="${pageContext.request.contextPath}/member/remove">
				    	
				    	<input type="text" name="memberId" value="${loginMember.memberId}" hidden="hidden">
				    	
					    <div class="form-group">
					    
					      <input type="password" class="form-control" id="memberPw" placeholder="비밀번호" name="memberPw">
					    
					    </div>
					    
					    <button type="submit" class="btn btn-primary btn-block btn-lg">탈퇴하기</button>
					    
					</form>
		  			
		  			<br>
		  			
		  		</div>
		  		
		  		<div class="col"></div>
		
			</div>
			
			<div class="row">
		  			
		  		<div class="col"></div>
		  		<div class="col"><a href="${pageContext.request.contextPath}/member/calendar">이전페이지로 가기</a></div>
		  		<div class="col"></div>
		  		
		  	</div>
			
		</div>
			
	</body>
	
</html>