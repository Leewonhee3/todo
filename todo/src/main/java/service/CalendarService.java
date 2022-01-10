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
	
	public Map<String,Object> getTargetCalendar(String memberId, String currentYear, String currentMonth, String option){ // option : pre(이전달), next(다음달)
		
		Map<String,Object> map = new HashMap<String, Object>();
		Calendar c = Calendar.getInstance();// 오늘 날짜와 연도를 가리킨다.
		
		if(currentYear != null && currentMonth != null) { // currentYear,currentMonth가 null이 아닌경우 변수 y,m에 연도와 월을 저장한다.
			
			int y = 0; // 현재 페이지의 연도와,월을 저장하는 변수
			int m = 0;
			y = Integer.parseInt(currentYear);
			// 1월 ~ 12월
			m = Integer.parseInt(currentMonth);
			
			if(option != null && option.equals("pre")) { // 옵션 값이 null이 아니고 값이 pre인 경우(페이지에서 이전버튼을 누른경우)
				
				m = m-1; // 이전달로 가야되므로 현재 월에서 -1한 값을 저장
				if(m == 0) { //이전해 12월로 넘어갈때(1월에서 작년 12월로 갈때)
					
					y = y-1; //현재 연도에서 -1
					m = 12;  //월은 12월
					
				}
				
			}else if(option != null && option.equals("next")) { // 옵션 값이 null이 아니고 값이 next인 경우(페이지에서 다음버튼을 누른경우)
				
				m = m+1; // 다음달로 가야되므로 현재 월에서 +1한 값을 저장
				
				if(m == 13) { //다음해 1월로 넘어갈때(12월에서 내년 1월로 갈때)
					m = 1; //월은 1월
					y = y+1; //현재 연도에서 +1
				}
			}
			
			c.set(Calendar.YEAR, y);
			//조건문에서는 1~12월로 계산하지만 캘린더의 month값은 0~11월 까지 이므로 -1해줘야 한다.
			c.set(Calendar.MONTH, m-1);
		
		}
		
		c.set(Calendar.DATE, 1); //c객체 오늘의 정보 -> 같은달 1일로 변경
		
		//달력에 필요한 데이터
		int targetYear = c.get(Calendar.YEAR);
		int targetMonth = c.get(Calendar.MONTH)+1;
		int endDay = c.getActualMaximum(Calendar.DATE);
		
		//달력 앞,뒤 공백의 개수
		int startBlank = 0; // 타겟이 되는 달의 1일의 요일 -> 일요일이면 0, 월요일이면 1.... 토요일이면 6이 필요
		startBlank = c.get(Calendar.DAY_OF_WEEK) -1;
		
		int endBlank = 0; // 전체 <td>의 개수 = startBlank + endDay + endBlank <-- 이 값이 7로 나누어 떨어지도록
		endBlank = 7 - ((startBlank+endDay)%7);
		
		if(endBlank ==7) { // 뒤에 공백을 6칸까지 띄우는게 가능하므로 7칸을 띄워야하면 공백이 없다는 뜻.
			endBlank = 0;
		}
		
		map.put("targetYear", targetYear); // 해당하는 연도
		map.put("targetMonth", targetMonth); // 해당하는 월
		map.put("endDay", endDay); // 해당하는 월의 총 일수
		map.put("startBlank", startBlank); // 해당하는 월에 1일 위치
		map.put("endBlank", endBlank); // 해당하는 월의 마지막날 뒤의 공백
		
		//2. 달력에 추가할 모델(todo) 알고리즘 코드
		List<Todo> list =null;
		Connection conn =null;
		
		try {

			todoDao = new TodoDao();
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.145.56:3306/todo", "root", "java1004");
			Todo todo = new Todo(); 
			
			// memberId <-- 파라미터로 값을 받는다.
			// todoDate의 년,월 <- targetYear과 targetMonth를 사용해서 구한다.
			todo.setMemberId(memberId);
			
			String strYear=""+targetYear; // 해당하는 연도를 문자열로 저장
			String strMonth=""+targetMonth; // 해당하는 달을 문자열로 저장
			
			if(targetMonth <10) { // 해당월이 10보다 작은경우
				 
				strMonth = "0"+targetMonth; // 1~9월까지 달앞에 0이 붙는다.
			
			}
			
			todo.setTodoDate(strYear+"-"+strMonth); //2021-09
			
			//디버깅
			System.out.println(todo+"<-----CalendarService.getTargetCalendar - todo");
			
			list = todoDao.selectTodoListByMonth(conn, todo);// 해당하는 달의 일정 목록을 반환하는 메소드
							
		}catch(Exception e){
							
			e.printStackTrace();
							
		}finally {
							
			try {
								
				conn.close();
								
			}catch(SQLException e) {
								
				e.printStackTrace();
								
			}
							
		}
		
		map.put("todoList", list); // 맵에 todoList를 저장
		
		return map;
		
	}
	
}
