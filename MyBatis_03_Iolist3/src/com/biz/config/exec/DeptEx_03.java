package com.biz.config.exec;

import com.biz.iolist.service.dept.DeptServiceV3;

public class DeptEx_03 {

	public static void main(String[] args) {
		DeptServiceV3 ds = new DeptServiceV3();
		
	//	ds.viewNameList();
	//	ds.viewNameAndCEOList();
		ds.deptMenu();
	}
	
}
