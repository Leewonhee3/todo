<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>update todo</h1>
	
		<form method="post" action="${pageContext.request.contextPath}/member/updateTodo">
			
			<div>
			
				todoDate : <input type="text" readonly="readonly" name = "todoDate" value="${todoDate}">
			
			</div>
			
			<div>
				
				todoContent : 
				<textarea rows="3" cols="50" name ="todoContent">${todoContent}</textarea>
			
			</div>
			
			<button type="submit">update todo</button>	
		
		</form>
		
</body>
</html>