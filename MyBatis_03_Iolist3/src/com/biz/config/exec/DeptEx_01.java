package com.biz.config.exec;

import com.biz.iolist.service.dept.DeptServiceV1;

public class DeptEx_01 {

	public static void main(String[] args) {
		DeptServiceV1 ds = new DeptServiceV1();
		
	//	ds.viewNameList();
		ds.viewNameAndCEOList();
	}
	
}
