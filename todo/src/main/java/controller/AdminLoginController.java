package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//이미 로그인 되어 있다면 요청처리 불가.
		HttpSession session =request.getSession();
		if(session.getAttribute("loginMember") != null){ // 이미 로그인 되어있는 상태다.
					
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
					
		}
				
		request.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		memberService = new MemberService();
		Member loginMember = memberService.login(paramMember);
		
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		response.sendRedirect(request.getContextPath()+"/member/calendar");
		
	}

}
