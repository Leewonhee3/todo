package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.*;

public class TodoDao {
	
	public List<Todo> selectTodoListByMonth(Connection conn, Todo todo) throws SQLException{
		
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			Todo t = new Todo();
		
			t.setTodoDate(rs.getString("todo_date"));
			t.setTodoContent(rs.getString("todoContent"));
			t.setFontColor(rs.getString("fontColor"));
		    list.add(t);
		
		}
	
		return list;
	
	}
	
	
	
	
	//일정 1개 삭제
	
	public void deleteTodoOne(Connection conn, Todo todo) throws SQLException {
		
		String sql = TodoQuery.DELETE_TODO_ONE;
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, todo.getTodoNo());
		stmt.setString(2, todo.getMemberId());
		
		stmt.executeUpdate();
		
		stmt.close();
		
		
	}
	
	//일정 수정
	
	public void updateTodoOne(Connection conn, Todo todo) throws SQLException {
				
		String sql=TodoQuery.UPDATE_TODO_ONE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoContent());
		stmt.setInt(2, todo.getTodoNo());
		stmt.setString(3, todo.getMemberId());
		stmt.executeUpdate();
		
		stmt.close();
		
	}
	
	//일정 불러오기
	public Todo selectTodoOne(Connection conn, int todoNo) throws SQLException {
		
		Todo t=null;
		
		String sql=TodoQuery.SELECT_TODO_ONE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, todoNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			
			t = new Todo();
			t.setTodoNo(rs.getInt("todo_no"));
			t.setMemberId(rs.getString("member_id"));
			t.setTodoDate(rs.getString("todo_date"));
			t.setTodoContent(rs.getString("todo_content"));
			t.setCreateDate(rs.getString("create_date"));
			t.setUpdateDate(rs.getString("update_date"));
			
			
		}
		stmt.close();
		
		return t;
		
		
	}
	
	//일정 추가
	
	public void insertTodo(Connection conn, Todo todo) throws SQLException {
		
		String sql=TodoQuery.INSERT_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoDate());
		stmt.setString(2, todo.getMemberId());
		stmt.setString(3, todo.getTodoContent());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException{
		
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoDate());
		stmt.setString(2, todo.getMemberId());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			Todo t= new Todo();
			t.setTodoNo(rs.getInt("todo_no"));
			t.setTodoDate(rs.getString("todo_date"));
			t.setTodoContent(rs.getString("todo_content"));
			t.setCreateDate(rs.getString("create_date"));
			t.setUpdateDate(rs.getString("update_date"));
			list.add(t);
			
		}
	
		return list;
		
	}
	
	
	//일정 전체 삭제
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeUpdate();
		stmt.close();
		
	}
	
}
