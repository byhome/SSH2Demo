package com.yeguang.ssh2demo.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.yeguang.ssh2demo.service.TestService;


@ParentPackage("testPackage")
public class TestAction {
    
	private String name;
	private String pwd;
	
	private String result;  
    private String type; 
    
    @Autowired
    TestService testSvc;
	
	@Action(value = "strust2Test", interceptorRefs={@InterceptorRef(value = "myInterceptor")},
			         results = {@Result(name="success", type = "json", params = {"includeProperties", "result,type"})})
	public String test() {
		System.out.println("进入TestAction");
		setType("json");
		setResult("ok");

		JSONObject jsonObject = new JSONObject();
		
		// 返回一个JSONArray对象
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1, "another jsonArray value");
        jsonObject.element("jsonArray", jsonArray);
        //在jsonObject后面住家一个jsonArray
        JSONArray array = jsonObject.getJSONArray("jsonArray");
        System.out.println(jsonObject);
		
		return "success";
	}
	
	@Action(value = "login", results = {@Result(name="success", location = "/modifypwd.jsp", type="redirect"),
			@Result(name="failed", location = "/failed.jsp")})
	public String login() {
		System.out.println("登录");
		try {
			if(testSvc.loginSvc(name, pwd)){
				Map session = ActionContext.getContext().getSession();
				session.put("user.name", name); 
				return "success";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "failed";
	}
	
	@Action(value = "signup", results = {@Result(name="success", location = "/index.jsp", type="redirect"),
			@Result(name="failed", location = "/failed.jsp")})
	public String singup() {
		System.out.println("注册");
		
		try {
			testSvc.signupSvc(name, pwd);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}		
	}
	
	@Action(value = "modifypwd", results = {@Result(name="success", location = "/success.jsp", type="redirect"),
			@Result(name="failed", location = "/failed.jsp", type="redirect")})
	public String modifypwd() {
		System.out.println("修改密码");
		
		try {
			name = (String) ActionContext.getContext().getSession().get("user.name");
			testSvc.modifySvc(name, pwd);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}  
}
