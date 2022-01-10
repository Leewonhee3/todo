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
		  				
			  			<span class="text-danger">C</span>
			  			<span class="text-info">a</span>
			  			<span class="text-warning">l</span>
			  			<span class="text-primary">e</span>
			  			<span class="text-success">n</span>
			  			<span class="text-danger">d</span>
			  			<span class="text-info">a</span>
			  			<span class="text-warning">r</span>
			  			<div>관리자모드</div>
			  		
			  		</h1>
			  		
		  		</div>
		  		
		  		<div class="col"></div>
		
			</div>
			
			<br>
			<br>
			
			<div class="row">
	  			
		  		<div class="col"></div>
		  		
		  		<div class="col">
		  			
		  			<form class="center-block text-center" method="post" action="${pageContext.request.contextPath}/adminLogin">
				    
					    <div class="form-group">
					    
					      <input type="text" class="form-control" id="memberId" placeholder="아이디" name="memberId">
					    
					    </div>
					    
					    <div class="form-group">
					    
					      <input type="password" class="form-control" id="memberPw" placeholder="비밀번호" name="memberPw">
					    
					    </div>
					    
					    <button type="submit" class="btn btn-primary btn-block btn-lg">로그인</button>
					    
					</form>
		  			
		  			<br>
		  			
		  			<div class="row">
		  				
		  				<div class="col text-left">
		  				
		  					<a href="${pageContext.request.contextPath}/login">이전페이지로 가기</a>
		  					
		  					<!-- 1) /adminLogin, AdminLoginController.doGet(), adminLogin.jsp -->
							<!-- 2) /adminLogin, AdminLoginController.doPost(), /admin/index/, AdminIndexController.doGet(), adminIndex.jsp -->		
		
		  				</div>
		  				
		  			</div>
		  			
		  		</div>
		  		
		  		<div class="col"></div>
		
			</div>
		
		</div>

	</body>

</html>