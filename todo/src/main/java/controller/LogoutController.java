package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태에서만 요청할수 있도록 필터링. -> 필터를 사용(LoginFilter)
		
		/*
		HttpSession session =request.getSession(); //방어코드
		if(session.getAttribute("loginMember") == null){ // 이미 로그인 되어있는 상태다.
			
			response.sendRedirect(request.getContextPath()+"/login");
			return;
			
		}
		필터 사용해서 필요 없는 코드*/
		
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

}
