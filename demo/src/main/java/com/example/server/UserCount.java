package com.example.server;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCount {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@RequestMapping(value="/getCount",method = RequestMethod.GET)
	public int getUserCount() {
		
		int i= template.selectOne("getUserCount");
		
		System.out.println(i);
		
		return i;
	}
	
	public static void main(String args[]) {
		
		UserCount user=new UserCount();
		user.getUserCount();
		
	}
}
