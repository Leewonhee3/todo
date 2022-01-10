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
	
	<style type="text/css">
		
		#t_height{
			 	
			height:1px
			  	
		}
		
	</style>
	
	<body>
	
		<div>
		
			<!-- top menu -->
			<div class="row">
	  			
				<div class="col text-right">
				
					${loginMember.memberId}님 반갑습니다
					<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
					<a href="${pageContext.request.contextPath}/member/remove">회원탈퇴</a>
				
				</div>
				
				<div class="col">
				
				</div>
				
				<div class="col"></div>
			
			</div>
			
		</div>
		<!-- main view -->
		<div class="container-fluid">
			
			<div class="row">
  				
  				<div class="col-sm-3">
  				
  					<!-- 달력 +  todo -->
					
					<div class="row">
			  		
				   		<div class="col">
						  		
							<h6>${targetYear}년 ${targetMonth}월 이달의 총 일정 : ${todoList.size()}</h6>
						  	<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">&lt;</a></span>
							<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">&gt;</a></span>
						  	
						</div>
					
					</div>
					
				  	<table class="table table-bordered" style="width: 100%; table-layout: fixed;">
						
						<thead>
							
							<tr class="text-center">
						    	
						    	<th style="color:#FF0000;"><h6><small>일</small></h6></th>
								<th><h6><small>월</small></h6></th>
								<th><h6><small>화</small></h6></th>
								<th><h6><small>수</small></h6></th>
								<th><h6><small>목</small></h6></th>
								<th><h6><small>금</small></h6></th>
								<th style="color:#88e5ff;"><h6><small>토</small></h6></th>
					      
					      	</tr>
					    
					    </thead>
					    
					    <tbody>
							
							<tr>
								<!-- JSTL for문 -->
								<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
									
									<c:if test="${i-startBlank <= 0 || i-startBlank > endDay}">
										
										<td>
											
											&nbsp;
										
										</td>
									
									</c:if>
									
									<c:if test="${i-startBlank >= 1 && i-startBlank <= endDay}">
										
										<td id="t_height">
										
											<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}" >
												
												<c:choose>
													
													<c:when test="${i%7 eq 0}">
													
														<div class="text-right" style="color: #88e5ff;">
													
													</c:when>
												
													<c:when test="${i eq 1}">
													
														<div class="text-right" style="color: #FF0000;">
													
													</c:when>
													
													<c:when test="${(i-1)%7 eq 0}">
													
														<div class="text-right" style="color: #FF0000;">
													
													</c:when>
													
													<c:otherwise>
													
														<div class="text-right" style="color: #000000;">
													
													</c:otherwise>
												
												</c:choose>
												
													${i-startBlank}
													
												</div>
											
											</a>
										
										</td>
					
									</c:if>
									
									<c:if test="${i%7 == 0}">
									
										</tr><tr>
									
									</c:if>
									
								</c:forEach>
								
							</tr>
							
					    </tbody>
					
					</table>
					
					<h2>공지사항<a href="${pageContext.request.contextPath }/noticeList">more</a></h2>
		
					<table border="1">
			
						<tr>
						
							<td>noticeTitle</td>
							<td>createDate</td>
							
						</tr>
						
						<c:forEach var = "n" items="${noticeList}">
							
							<tr>
							
								<td><a href="${pageContext.request.contextPath }/noticeOne?noticeNo=${n.noticeNo}">${n.noticeTitle}</a></td>
								<td>${n.createDate}</td>			
							
							</tr>
						
						</c:forEach>
					
					</table>
				
  				</div>
  				
  				<div class="col-sm-9 text-left">
  				
  					<div class="container">
						
						<h2>주간 일정</h2>
						<p>
							
							주간 일정 리스트 입니다.
							<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">&lt;</a></span>
							<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">&gt;</a></span>
						
						</p>            
					  	
					  	<table class="table table-bordered">
					    
					    	<thead>
					      		
					      		<tr>
					        		
					        		<th>일</th>
					        		<th>월</th>
					        		<th>화</th>
					        		<th>수</th>
					        		<th>목</th>
					        		<th>금</th>
					        		<th>토</th>
					      		
					      		</tr>
					    
					    	</thead>
					    
						    <tbody>
						      
						    	<tr>
							        
									<td>John</td>
							        <td>Doe</td>
							        <td>john@example.com</td>
						      	
						      	</tr>
						      	
						   		<tr>
						        
							    	<td>Mary</td>
							        <td>Moe</td>
							        <td>mary@example.com</td>
							      
						      	</tr>
						      	
						      	<tr>
						        
							        <td>July</td>
							        <td>Dooley</td>
							        <td>july@example.com</td>
						      	
						    	</tr>
						      
							</tbody>
						    
					  	</table>
					
					</div>
				
  				</div>
			
			</div>
		
		</div>
			
	</body>

</html>