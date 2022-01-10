<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			  		
			  		</h1>
			  		
		  		</div>
		  		
		  		<div class="col"></div>
		
			</div>
			
			<br>
			<br>
			
			<div class="row">
	  			
		  		<div class="col"></div>
		  		
		  		<div class="col">
		  			
		  			<form class="center-block text-center" method="post" action="${pageContext.request.contextPath}/login">
				    
					    <div class="form-group">
					    
					      <input type="text" class="form-control" id="memberId" placeholder="아이디" name="memberId">
					    
					    </div>
					    
					    <div class="form-group">
					    
					      <input type="password" class="form-control" id="memberPw" placeholder="비밀번호" name="memberPw">
					    
					    </div>
					    
					    <button type="submit" class="btn btn-primary btn-block btn-lg">로그인</button>
					    
					    <div class="row">
		  				
			  				<div class="col-sm-5 text-center">
			  					
			  					<label class="form-check-label">
		        				
		        					<input class="form-check-input" type="checkbox" name="rememberId">아이디저장
		      						
		      					</label>
			  				
			  				</div>
			  				
			  				<div class="col-sm-2"></div>
			  				
			  				<div class="col-sm-5 text-right">
			  					
			  					<label class="form-check-label">
		        				
		        					<input class="form-check-input" type="checkbox" name="rememberPw">비밀번호저장
		      						
		      					</label>
			  				
			  				</div>
		  				
		  				</div>
					    
					</form>
		  			
		  			<br>
		  			
		  			<div class="row">
		  				
		  				<div class="col text-center">
		  				
		  					<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
		  					&nbsp;|&nbsp;
		  					<a href="${pageContext.request.contextPath }/adminLogin">관리자로그인</a>
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