package com.yeguang.ssh2demo.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpServletResponseWrapper;

import com.opensymphony.xwork2.ActionContext;


public class RequestFilter implements Filter {
	
	private FilterConfig config; // 这个东西好，可以从配置文件里面读，就是读的filter里面那个参数 

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("listener destory");  
	    config = null; 
	}
	
	public static boolean isContains(String container, String[] regx) {  
        boolean result = false;  
  
        for (int i = 0; i < regx.length; i++) {  
            if (container.indexOf(regx[i]) != -1) {  
                return true;  
            }  
        }  
        return result;  
    } 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest)request;  
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);  
          
        String logonStrings = config.getInitParameter("logonStrings");   
        String includeStrings = config.getInitParameter("includeStrings");  
        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath"); 
        String disabletestfilter = config.getInitParameter("disabletestfilter");
          
        if (disabletestfilter.toUpperCase().equals("Y")) {   
            chain.doFilter(request, response);  
            return;  
        }  
        String[] logonList = logonStrings.split(";");  
        String[] includeList = includeStrings.split(";");  
          
        if (!this.isContains(hrequest.getRequestURI(), includeList)) {
            chain.doFilter(request, response);  
            return;  
        }  
          
        if (this.isContains(hrequest.getRequestURI(), logonList)) {
            chain.doFilter(request, response);  
            return;  
        }     
          
        String user = ( String ) hrequest.getSession().getAttribute("user.name");
        if (user == null) {  
            wrapper.sendRedirect(redirectPath);  
            return;  
        }else {  
            chain.doFilter(request, response);  
            return;  
        }  
    }

	public void init(FilterConfig paramFilterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = paramFilterConfig;
	}
}
