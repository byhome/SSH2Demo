package com.yeguang.ssh2demo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


@ParentPackage("testPackage")
public class TestAction {
    
	private String result;  
    private String type; 	 
	
	@Action(value = "strust2Test", interceptorRefs={@InterceptorRef(value = "myInterceptor")},
			         results = {@Result(name="success", type = "json")})
	public String test() {
		System.out.println("进入TestAction");
		setType("json");
		setResult("ok");
		return "success";
	}
	
	public String getResult() {  
        return result;  
    }  
  
    public void setResult(String result) {  
        this.result = result;  
    }  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
}
