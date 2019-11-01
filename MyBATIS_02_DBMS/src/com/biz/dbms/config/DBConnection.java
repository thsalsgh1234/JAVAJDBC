package com.biz.dbms.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		// *-config.xml 파일을 읽어서 
		// mybatis 초기 설정값을 가져오기
		String configFile = "com/biz/dbms/config/mybatis-config.xml";
		InputStream is = null;
		
		try {
			// configFile을 읽어오는 절차
			is = Resources.getResourceAsStream(configFile);
			
			// sqlSession을 싱글톤으로 생성하기 위한 절차
			SqlSessionFactoryBuilder builder 
			= new SqlSessionFactoryBuilder();
			/*
			 * sqlSessionFactory를 null인가를 검사하는 이유
			 * multi thread 환경에서 singletone을 보장하기 위해서
			 */
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} // end static
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
}
