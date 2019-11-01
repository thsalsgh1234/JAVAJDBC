package com.biz.addr.config;



public class DBContract {

	public static class SQL {
		
		public static final String SELECT_ADDR
			= " SELECT ID," +
		      " NAME, " +
              " TEL, " +
		      " CHAIN " +
              " FROM tbl_addr ";
			
	}
}
