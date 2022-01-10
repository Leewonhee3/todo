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
		
       		//�Է��� ���� �޴´�.
       		String todoDate = request.getParameter("todoDate");
       		String todoContent = request.getParameter("todoContent");
       		
       		//�����
       		System.out.println(todoDate+"<---- AddTodoController\n"+todoContent+"<---- AddTodoController");
       		System.out.println(request.getParameter("fontColor")+"<---- AddTodoController - fontColor");
       		
       		//vo Ÿ�� todo�� ����
       		todo.setTodoDate(todoDate);
       		todo.setTodoContent(todoContent);
       		todo.setMemberId(((Member)(request.getSession().getAttribute("loginMember"))).getMemberId());
       		
       		todoService.insertTodo(todo); //todo ���� ȣ�� ���񽺿��� daoȣ���Ѵ�.
       		
       		String y = todoDate.substring(0,4);
    		String m = todoDate.substring(5,7);
    		String d = todoDate.substring(8,10); //subString���� �и�
       		
    		/*
       		response.sendRedirect(request.getContextPath()+"/member/todoList?" //insert ������ list�������� ���ư���.
       				+ "y="+request.getParameter("y") //������ ���� setAttribute�� �����ߴٰ� post�� ���� �Ѱ� �޾���.
       				+"&m="+request.getParameter("m")
       				+"&d="+request.getParameter("d"));
	
			*/
    		
    		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d); //insert ������ list�������� ���ư���.
	}

}
