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
	
	  //Ż�� ������ �̵�
	  request.getRequestDispatcher("/WEB-INF/view/remove.jsp").forward(request, response);
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Ż�� ������ post�� ���� ���
		
		//���̵�, pw ����.
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//�����
		System.out.println(memberId+"<----- removeController \n"+memberPw +"<----- removeController");
		
		memberService = new MemberService();
		
		//���࿩�� üũ
		boolean check = memberService.removeMember(memberId, memberPw);
		
		if(check) { // �����Ȱ��

			System.out.println("���� ����");
			response.sendRedirect(request.getContextPath()+"/member/logout");
			/*
			request.getSession().invalidate();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			*/
			
		}else {// �����Ѱ��
			
			System.out.println("���� ����");
			request.getRequestDispatcher("/WEB-INF/view/remove.jsp").forward(request, response);
		
		}
	
	
	}

}
