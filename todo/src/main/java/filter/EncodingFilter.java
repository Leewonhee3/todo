package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청전 필터
		request.setCharacterEncoding("utf-8");
		System.out.println("EncodingFilter.doFilter() 실행");
		
		chain.doFilter(request, response); //사용자 요청한 컨트롤 메소드
		
		// 요청 후 필터
	}
}
