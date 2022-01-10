package dao;

public class TodoQuery {
	public static final String DELETE_TODO;
	public static final String SELECT_TODO_LIST_BY_DATE;
	public static final String INSERT_TODO;
	public static final String SELECT_TODO_ONE;
	public static final String UPDATE_TODO_ONE;
	public static final String DELETE_TODO_ONE;
	public static final String SELECT_TODO_LIST_BY_MONTH;
	
	static {
		
		DELETE_TODO = "DELETE FROM todo WHERE member_id=?";
		SELECT_TODO_LIST_BY_DATE = "SELECT todo_no, todo_date, todo_content, create_date, update_date FROM todo WHERE todo_date=? AND member_id=?";
		INSERT_TODO = "INSERT INTO todo(todo_date,member_id,todo_content,create_date,update_date) VALUES(?,?,?,NOW(),NOW())";
		SELECT_TODO_ONE = "SELECT todo_no,member_id, todo_date, todo_content, create_date, update_date FROM todo WHERE todo_no=?";
		UPDATE_TODO_ONE = "UPDATE todo SET todo_content=?, update_date=NOW() WHERE todo_no=? AND member_id=?";
		DELETE_TODO_ONE = "DELETE FROM todo WHERE todo_no=? AND member_id=? ";
		SELECT_TODO_LIST_BY_MONTH = "SELECT todo_date todoDate, SUBSTR(todo_content,1,5) todoContent, font_color fontColor FROM todo WHERE member_id = ? AND SUBSTR(todo_date,1,7) = ? ORDER BY todo_date ASC" ;
	}
	
	
}
