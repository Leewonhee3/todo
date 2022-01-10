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
	
		<h1>${todoDate} todo list</h1>
		
		<table border="1">
			
			<tr>
				
				<td>todoDate</td>
				<td>todoContent</td>
				<td>createDate</td>
				<td>updateDate</td>	
				<td>수정</td>
				<td>삭제</td>
				
			</tr>
			
			<c:forEach var = "t" items="${todoList}">
				
				<tr>
				
					<td>${t.todoDate}</td>
					<td>${t.todoContent}</td>
					<td>${t.createDate}</td>
					<td>${t.updateDate}</td>
					<td><a href ="${pageContext.request.contextPath}/member/updateTodo?todoNo=${t.todoNo}">수정</a></td>
					<td><a href ="${pageContext.request.contextPath}/member/delete?todoNo=${t.todoNo}&todoDate=${t.todoDate}">삭제</a></td>
					
				</tr>
				
			</c:forEach>
			
		</table>
		
		<h1>add todo</h1>
		<form method="post" action="${pageContext.request.contextPath}/member/addTodo">
			
			<div>
			
				todoDate : <input type="text" readonly="readonly" name = "todoDate" value="${todoDate}">
			
			</div>
			
			<input type="hidden" name="y" value="${y}">
			<input type="hidden" name="m" value="${m}">
			<input type="hidden" name="d" value="${d}">
			
			<div>
				
				todoContent : 
				<textarea rows="3" cols="50" name ="todoContent"></textarea>
			
			</div>
			
			<div>
			
				<input type="color" name = "fontColor">
			
			</div>
			
			<button type="submit">add todo</button>	
			
			<div>
			
				<a href="${pageContext.request.contextPath}/member/calendar">이전페이지로 가기</a>
				
			</div>
			
		</form>
		
	</body>
	
</html>