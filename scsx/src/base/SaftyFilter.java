package base;

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


//@WebFilter("/*")
public class SaftyFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
			
			HttpServletRequest req = (HttpServletRequest) request;
			
			
			//��ȡ�����ַ����ʽ��/loginDo
			String path = req.getServletPath();
			
			
			//�Ź�������֤�ĵ�ַ
			if("/login.html".equals(path) ||  
					"/loginDo".equals(path) || 
					path.startsWith("/resources"))  {
				
				chain.doFilter(request, response);//����ͨ��
				
				return;
				
			}
			//����Ҫ��֤�ĵ�ַ���д���
			HttpSession session = req.getSession();
			if(session.getAttribute("LoginUserID")!=null) {
				chain.doFilter(request, response);//����ͨ��
				return;
			}
			
			
			//δ��¼��ص�¼ҳ!
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/login.html");//���¼ҳ��ת
		// pass the request along the filter chain
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
