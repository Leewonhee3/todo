package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/member/*")
public class LoginFilter implements Filter {

   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// �α��� ���¿����� ��û�Ҽ� �ֵ��� ���͸�.
		
		System.out.println("LoginFilter.doFilter ����");
		
		HttpSession session = ((HttpServletRequest)request).getSession(); //����ڵ�
		if(session.getAttribute("loginMember") == null){ // �α��� �ȵȰ��.
			
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/login");
			return;
			
		}
		
		chain.doFilter(request, response);
	}

}
