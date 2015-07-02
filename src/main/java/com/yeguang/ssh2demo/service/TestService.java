package com.yeguang.ssh2demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeguang.ssh2demo.dao.TestDao;

@Service
public class TestService {
	
	@Autowired
	TestDao testDao;
	
    public boolean loginSvc(String name, String pwd){    	
    	return testDao.isVaidUser(name, pwd);
    }
    
    public void signupSvc(String name, String pwd){
    	testDao.insertUser(name, pwd);
    }
    
    public void modifySvc(String name, String pwd){
    	testDao.updatePwd(name, pwd);
    }
}
