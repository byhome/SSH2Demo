package com.yeguang.ssh2demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.yeguang.ssh2demo.model.User;

@Repository
public class TestDao extends HibernateDaoSupport{
	
	@Autowired  
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	} 
	
	public void insertUser(String name, String pwd){
		User user = new User();
		user.setName(name);
		user.setPassword(pwd);
		this.getHibernateTemplate().save(user);	
	}
	
	public boolean isVaidUser(String name, String pwd){
		User user = new User();
		user.setName(name);
		user.setPassword(pwd);
		List<User> users = this.getHibernateTemplate().findByExample(user);
		return (users.size() > 0);
	}
	
	public void updatePwd(String name, String pwd){
		String hql="update User user set user.password=? where user.name=?";
		this.getHibernateTemplate().bulkUpdate(hql, pwd, name);
	}
}
