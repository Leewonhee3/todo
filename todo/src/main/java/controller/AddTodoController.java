package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/addTodo")
public class AddTodoController extends HttpServlet {
	
	private Todo todo = new Todo();
	private TodoService todoService = new TodoService();
	
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       		
	}

       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       		//입력할 값을 받는다.
       		String todoDate = request.getParameter("todoDate");
       		String todoContent = request.getParameter("todoContent");
       		
       		//디버깅
       		System.out.println(todoDate+"<---- AddTodoController\n"+todoContent+"<---- AddTodoController");
       		System.out.println(request.getParameter("fontColor")+"<---- AddTodoController - fontColor");
       		
       		//vo 타입 todo에 저장
       		todo.setTodoDate(todoDate);
       		todo.setTodoContent(todoContent);
       		todo.setMemberId(((Member)(request.getSession().getAttribute("loginMember"))).getMemberId());
       		
       		todoService.insertTodo(todo); //todo 서비스 호출 서비스에서 dao호출한다.
       		
       		String y = todoDate.substring(0,4);
    		String m = todoDate.substring(5,7);
    		String d = todoDate.substring(8,10); //subString으로 분리
       		
    		/*
       		response.sendRedirect(request.getContextPath()+"/member/todoList?" //insert 실행후 list페이지로 돌아간다.
       				+ "y="+request.getParameter("y") //별도로 값을 setAttribute로 저장했다가 post시 값을 넘겨 받았음.
       				+"&m="+request.getParameter("m")
       				+"&d="+request.getParameter("d"));
	
			*/
    		
    		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d); //insert 실행후 list페이지로 돌아간다.
	}

}
