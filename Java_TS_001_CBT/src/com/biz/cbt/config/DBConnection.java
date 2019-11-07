package com.biz.cbt.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;





public class DBConnection {

	private static SqlSessionFactory SqlSessionFacyory;
	
	
	static {
		
		String configFile = "com/biz/cbt/config/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

			if (SqlSessionFacyory == null) {
				SqlSessionFacyory = builder.build(inputStream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static SqlSessionFactory getSqlSessionFactory() {
		
		return SqlSessionFacyory;
	}
	
	
}
