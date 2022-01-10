package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TodoDao;
import vo.Todo;
import commons.DBUtil;

public class TodoService {

	private TodoDao todoDao;
	
	public void updateTodo(Todo todo) {
		
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.updateTodoOne(conn, todo);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//일정 삭제
	public void deleteTodo(Todo todo) {
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.deleteTodoOne(conn, todo);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void insertTodo(Todo todo){
		
		Connection conn = null;
		
		try {
			
			conn=DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.insertTodo(conn, todo); //dao 호출
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				conn.close();
			}catch(SQLException e){
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public List<Todo>getTodoListByDate(Todo todo){
		
		List<Todo> list = null;
		Connection conn = null;
		
		try {
			
			conn=DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			list = todoDao.selectTodoListByDate(conn, todo);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				conn.close();
			}catch(SQLException e){
				
				e.printStackTrace();
				
			}
			
		}
		
		return list;
		
	}
	
	public Todo getTodoOne(int todoNo){
		
		Connection conn = null;
		Todo todo =null;
		
		try {
			
			conn=DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			todo = todoDao.selectTodoOne(conn,todoNo); //dao 호출
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				conn.close();
			}catch(SQLException e){
				
				e.printStackTrace();
				
			}
			
		}
		
		return todo;
		
	}
}