package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/updateTodo")
public class UpdateTodoController extends HttpServlet {
	
	private TodoService todoService;
	private int todoNo;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		todoService = new TodoService();
		todo = new Todo();
		todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		//디버깅
		System.out.println(todoNo+"<--------UpdateTodoController - todoNo");
		
		todo = todoService.getTodoOne(todoNo);
		
		System.out.println(todo+"<--------UpdateTodoController - todo");
		
		request.setAttribute("todoDate", todo.getTodoDate());
		request.setAttribute("todoContent", todo.getTodoContent());
		
		request.getRequestDispatcher("/WEB-INF/view/updateTodo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		todoService = new TodoService();
		todo = new Todo();
		
		todo.setTodoNo(todoNo);
		todo.setMemberId(((Member)(request.getSession().getAttribute("loginMember"))).getMemberId());
		todo.setTodoContent(request.getParameter("todoContent"));
		todo.setTodoDate(request.getParameter("todoDate"));
		
		//디버깅
		System.out.println(todo+"<-------UpdateTodoController - todo by post");
		
		todoService.updateTodo(todo);
		
		String y = todo.getTodoDate().substring(0,4);
		String m = todo.getTodoDate().substring(5,7);
		String d = todo.getTodoDate().substring(8,10); //subString으로 분리
   	
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d); //update 실행후 list페이지로 돌아간다.
		
		
	}

}
