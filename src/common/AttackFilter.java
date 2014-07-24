package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AttackFilter
 */
public class AttackFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AttackFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
//		if(req.getRequestURL().toString().indexOf("admin")<0 && req.getRequestURL().toString().indexOf("photo/")<0){//后台的不过滤
//			XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
//			(HttpServletRequest) request);
//			chain.doFilter(xssRequest, response);		
//		}
//		else {
//			chain.doFilter(request, response);
//		}	
		if(req.getRequestURL().toString().indexOf(".jsp")>0){
			return;//防止通过jsp模板攻击
		}
		AttackHttpServletRequestWrapper xssRequest = new AttackHttpServletRequestWrapper(req);
		chain.doFilter(xssRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
