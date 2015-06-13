package com.yeguang.ssh2demo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class checkLogin implements Interceptor {
	public void destroy() {
		System.out.println("------CheckLogin.destroy------");
	}

	public void init() {
		System.out.println("------CheckLogin.init------");

	}

	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("------CheckLogin.intercept------");		
		
		return arg0.invoke();
	}

}
