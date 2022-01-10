package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import controller.TodoListController;
import dao.TodoDao;
import vo.Todo;

public class CalendarService {

	private TodoDao todoDao;
	
	public Map<String,Object> getTargetCalendar(String memberId, String currentYear, String currentMonth, String option){ // option : pre(������), next(������)
		
		Map<String,Object> map = new HashMap<String, Object>();
		Calendar c = Calendar.getInstance();// ���� ��¥�� ������ ����Ų��.
		
		if(currentYear != null && currentMonth != null) { // currentYear,currentMonth�� null�� �ƴѰ�� ���� y,m�� ������ ���� �����Ѵ�.
			
			int y = 0; // ���� �������� ������,���� �����ϴ� ����
			int m = 0;
			y = Integer.parseInt(currentYear);
			// 1�� ~ 12��
			m = Integer.parseInt(currentMonth);
			
			if(option != null && option.equals("pre")) { // �ɼ� ���� null�� �ƴϰ� ���� pre�� ���(���������� ������ư�� �������)
				
				m = m-1; // �����޷� ���ߵǹǷ� ���� ������ -1�� ���� ����
				if(m == 0) { //������ 12���� �Ѿ��(1������ �۳� 12���� ����)
					
					y = y-1; //���� �������� -1
					m = 12;  //���� 12��
					
				}
				
			}else if(option != null && option.equals("next")) { // �ɼ� ���� null�� �ƴϰ� ���� next�� ���(���������� ������ư�� �������)
				
				m = m+1; // �����޷� ���ߵǹǷ� ���� ������ +1�� ���� ����
				
				if(m == 13) { //������ 1���� �Ѿ��(12������ ���� 1���� ����)
					m = 1; //���� 1��
					y = y+1; //���� �������� +1
				}
			}
			
			c.set(Calendar.YEAR, y);
			//���ǹ������� 1~12���� ��������� Ķ������ month���� 0~11�� ���� �̹Ƿ� -1����� �Ѵ�.
			c.set(Calendar.MONTH, m-1);
		
		}
		
		c.set(Calendar.DATE, 1); //c��ü ������ ���� -> ������ 1�Ϸ� ����
		
		//�޷¿� �ʿ��� ������
		int targetYear = c.get(Calendar.YEAR);
		int targetMonth = c.get(Calendar.MONTH)+1;
		int endDay = c.getActualMaximum(Calendar.DATE);
		
		//�޷� ��,�� ������ ����
		int startBlank = 0; // Ÿ���� �Ǵ� ���� 1���� ���� -> �Ͽ����̸� 0, �������̸� 1.... ������̸� 6�� �ʿ�
		startBlank = c.get(Calendar.DAY_OF_WEEK) -1;
		
		int endBlank = 0; // ��ü <td>�� ���� = startBlank + endDay + endBlank <-- �� ���� 7�� ������ ����������
		endBlank = 7 - ((startBlank+endDay)%7);
		
		if(endBlank ==7) { // �ڿ� ������ 6ĭ���� ���°� �����ϹǷ� 7ĭ�� ������ϸ� ������ ���ٴ� ��.
			endBlank = 0;
		}
		
		map.put("targetYear", targetYear); // �ش��ϴ� ����
		map.put("targetMonth", targetMonth); // �ش��ϴ� ��
		map.put("endDay", endDay); // �ش��ϴ� ���� �� �ϼ�
		map.put("startBlank", startBlank); // �ش��ϴ� ���� 1�� ��ġ
		map.put("endBlank", endBlank); // �ش��ϴ� ���� �������� ���� ����
		
		//2. �޷¿� �߰��� ��(todo) �˰��� �ڵ�
		List<Todo> list =null;
		Connection conn =null;
		
		try {

			todoDao = new TodoDao();
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			Todo todo = new Todo(); 
			
			// memberId <-- �Ķ���ͷ� ���� �޴´�.
			// todoDate�� ��,�� <- targetYear�� targetMonth�� ����ؼ� ���Ѵ�.
			todo.setMemberId(memberId);
			
			String strYear=""+targetYear; // �ش��ϴ� ������ ���ڿ��� ����
			String strMonth=""+targetMonth; // �ش��ϴ� ���� ���ڿ��� ����
			
			if(targetMonth <10) { // �ش���� 10���� �������
				 
				strMonth = "0"+targetMonth; // 1~9������ �޾տ� 0�� �ٴ´�.
			
			}
			
			todo.setTodoDate(strYear+"-"+strMonth); //2021-09
			
			//�����
			System.out.println(todo+"<-----CalendarService.getTargetCalendar - todo");
			
			list = todoDao.selectTodoListByMonth(conn, todo);// �ش��ϴ� ���� ���� ����� ��ȯ�ϴ� �޼ҵ�
							
		}catch(Exception e){
							
			e.printStackTrace();
							
		}finally {
							
			try {
								
				conn.close();
								
			}catch(SQLException e) {
								
				e.printStackTrace();
								
			}
							
		}
		
		map.put("todoList", list); // �ʿ� todoList�� ����
		
		return map;
		
	}
	
}
