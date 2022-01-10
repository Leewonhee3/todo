package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;


@WebServlet("/member/remove")
public class RemoveController extends HttpServlet {
	
	private MemberService memberService;
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  //탈퇴 페이지 이동
	  request.getRequestDispatcher("/WEB-INF/view/remove.jsp").forward(request, response);
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//탈퇴 폼에서 post로 받은 경우
		
		//아이디, pw 받음.
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//디버깅
		System.out.println(memberId+"<----- removeController \n"+memberPw +"<----- removeController");
		
		memberService = new MemberService();
		
		//실행여부 체크
		boolean check = memberService.removeMember(memberId, memberPw);
		
		if(check) { // 삭제된경우

			System.out.println("삭제 성공");
			response.sendRedirect(request.getContextPath()+"/member/logout");
			/*
			request.getSession().invalidate();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			*/
			
		}else {// 실패한경우
			
			System.out.println("삭제 실패");
			request.getRequestDispatcher("/WEB-INF/view/remove.jsp").forward(request, response);
		
		}
	
	
	}

}
