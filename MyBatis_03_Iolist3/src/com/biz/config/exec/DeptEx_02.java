package com.biz.config.exec;

import com.biz.iolist.service.dept.DeptServiceV2;

public class DeptEx_02 {

	public static void main(String[] args) {
		DeptServiceV2 ds = new DeptServiceV2();
		
	//	ds.viewNameList();
	//	ds.viewNameAndCEOList();
		ds.deptMenu();
	}
	
}
