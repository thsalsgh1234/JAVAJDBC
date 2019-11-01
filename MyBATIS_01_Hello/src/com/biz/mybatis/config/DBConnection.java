package com.biz.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	/*
	 * SqlSession을 필요에 따라
	 * 생성, 삭제등을 관리할 클래스
	 */
	private static SqlSessionFactory SqlSessionFactory;
	
	static {
		
		String configFile = "com/biz/mybatis/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			if(SqlSessionFactory == null) {
				SqlSessionFactory = builder.build(inputStream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	public static SqlSessionFactory getSqlSessionFactory() {
		return SqlSessionFactory;
		
		
		
	}
	
	
	
}
