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


@WebServlet("/member/calendar") // ����� ��θ��� �ƴ϶� ���ͷ� �����Ҽ� �ֵ��� �ؽ�Ʈ�� �߰��Ѱ���.
public class CalendarController extends HttpServlet {
	
	private CalendarService calendarService;
	private TodoService todoService;
	private NoticeService noticeService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �α��� ���¿����� ��û�Ҽ� �ֵ��� ���͸�. -> ���͸� ���(LoginFilter)
		
		/*
		HttpSession session =request.getSession(); //����ڵ�
		if(session.getAttribute("loginMember") == null){ // �̹� �α��� �Ǿ��ִ� ���´�.
			
			response.sendRedirect(request.getContextPath()+"/login");
			return;
			
		}
		���� ����ؼ� �ʿ� ���� �ڵ�*/
		
		//Ķ���� �������� ������
		/*
		 * 
		 * �ش� ������
		 * 
		 * �ش�� ��ü �ϼ��� ���´�.
		 * 
		 * */
		
		String currentYear = request.getParameter("currentYear"); //calendar.jsp���� get���� ���� ����, ��, �ɼ�(������, ������)���� �޴´�. 
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		
		
		//��������
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList();
		request.setAttribute("noticeList", noticeList);
		
		//�����
		
		System.out.println(currentYear + "<-------------- CalendarController - currentYear\n"
		+currentMonth + "<-------------- CalendarController - currentMonth\n"
		+option + "<-------------- CalendarController - option\n");
		
		calendarService = new CalendarService();
		String memberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId(); //���ǿ� ������̵� ���� ������ �����Ѵ�.
		Map<String,Object> map = calendarService.getTargetCalendar(memberId, currentYear, currentMonth, option); //�޷� �����͸� ������ ����
		
		//��
		
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("endDay", map.get("endDay"));
		//�޷��� ����Ҷ� ��/�� �ʿ��� ���� <td>
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		
		//�޷¿� ������� todo �� ���(�� ���� ���� ���)
		request.setAttribute("todoList", map.get("todoList"));
		
		request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
	
	}
}
