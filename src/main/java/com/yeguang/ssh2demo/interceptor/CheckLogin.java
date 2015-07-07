package com.yeguang.ssh2demo.interceptor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLogin implements Interceptor {
	public void destroy() {
		System.out.println("------CheckLogin.destroy------");
	}

	public void init() {
		System.out.println("------CheckLogin.init------");

	}

	public String intercept(ActionInvocation aInvocation) throws Exception {
		
		System.out.println("------CheckLogin.intercept------");	
		
		/*Map parameters = ActionContext.getContext().getSession();
		
		String user = (String) parameters.get("user.name");
		
		if(user == null){
			return "failed";
		}*/
		
		return aInvocation.invoke();
	}

}
