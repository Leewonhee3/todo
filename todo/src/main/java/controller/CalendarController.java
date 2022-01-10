package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CalendarService;
import service.NoticeService;
import service.TodoService;
import vo.Member;
import vo.Notice;
import vo.Todo;


@WebServlet("/member/calendar") // 멤버는 경로명이 아니라 필터로 구분할수 있도록 텍스트를 추가한것임.
public class CalendarController extends HttpServlet {
	
	private CalendarService calendarService;
	private TodoService todoService;
	private NoticeService noticeService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태에서만 요청할수 있도록 필터링. -> 필터를 사용(LoginFilter)
		
		/*
		HttpSession session =request.getSession(); //방어코드
		if(session.getAttribute("loginMember") == null){ // 이미 로그인 되어있는 상태다.
			
			response.sendRedirect(request.getContextPath()+"/login");
			return;
			
		}
		필터 사용해서 필요 없는 코드*/
		
		//캘린더 페이지에 들어오면
		/*
		 * 
		 * 해당 연월일
		 * 
		 * 해당월 전체 일수가 나온다.
		 * 
		 * */
		
		String currentYear = request.getParameter("currentYear"); //calendar.jsp에서 get으로 현재 연도, 월, 옵션(이전달, 다음달)값을 받는다. 
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		
		
		//공지사항
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList();
		request.setAttribute("noticeList", noticeList);
		
		//디버깅
		
		System.out.println(currentYear + "<-------------- CalendarController - currentYear\n"
		+currentMonth + "<-------------- CalendarController - currentMonth\n"
		+option + "<-------------- CalendarController - option\n");
		
		calendarService = new CalendarService();
		String memberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId(); //세션에 멤버아이디 값을 가져와 저장한다.
		Map<String,Object> map = calendarService.getTargetCalendar(memberId, currentYear, currentMonth, option); //달력 데이터를 맵으로 저장
		
		//모델
		
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("endDay", map.get("endDay"));
		//달력을 출력할때 앞/뒤 필요한 공백 <td>
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		
		//달력에 출력해줄 todo 모델 목록(각 월의 일정 목록)
		request.setAttribute("todoList", map.get("todoList"));
		
		request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
	
	}
}
