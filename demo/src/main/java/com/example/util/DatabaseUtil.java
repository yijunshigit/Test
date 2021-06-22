package com.example.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseUtil {
	
	public static SqlSession getSqlSession() throws IOException {
		Reader reader=Resources.getResourceAsReader("databaseConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession(true);		
		return session;
	} 

}
