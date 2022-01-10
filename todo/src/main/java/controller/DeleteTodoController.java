package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/delete")
public class DeleteTodoController extends HttpServlet {
	
	private TodoService todoService;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		todo = new Todo();
		
		todo.setTodoNo(Integer.parseInt(request.getParameter("todoNo")));
		todo.setMemberId(((Member)(request.getSession().getAttribute("loginMember"))).getMemberId());
		todo.setTodoDate(request.getParameter("todoDate"));
		
		//디버깅
		
		System.out.println(todo+"<-------DeleteTodoController - todo");
		
		todoService = new TodoService();
		todoService.deleteTodo(todo);
		
		String y = todo.getTodoDate().substring(0,4);
		String m = todo.getTodoDate().substring(5,7);
		String d = todo.getTodoDate().substring(8,10); //subString으로 분리
		
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d); //delete 실행후 list페이지로 돌아간다.
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
