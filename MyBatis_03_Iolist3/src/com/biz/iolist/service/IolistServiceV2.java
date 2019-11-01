package com.biz.iolist.service;

import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.persistence.DeptDTO;
import com.biz.iolist.persistence.IolistVO;

public class IolistServiceV2 extends IolistServiceV1 {


	
	public void iolitInsert() {
		
		while(true) {
			System.out.print("거래처 검색(종료 : 0) : ");
			String strDName = scan.nextLine();
			if(strDName.equals("0"))
				break;
			System.out.print("거래처 코드(종료 : 0)  : ");
			String strDCode = scan.nextLine();
			if(strDCode.equals("0")) break;
			if(strDCode.trim().isEmpty()) {
				String strTMDCode = strDCode;
			}
		}
	}
	public void viewIDetail(IolistVO vo) {
		System.out.println("===========================================");
		System.out.println("같은 이름의 상품이 있음");
		System.out.println("-------------------------------------------");
		System.out.println("거래처이름 : " + vo.getD_name());
		System.out.println("거래처코드 : "+ vo.getIo_dcode());
		System.out.println("상품이름 : " + vo.getP_name());
		System.out.println("상품코드 : " + vo.getIo_pcode());
		System.out.println("가격 : " + vo.getIo_price());
		System.out.println("매입단가 : " + vo.getP_iprice());
		System.out.println("매출단가 : "+ vo.getP_oprice());
		System.out.println("날짜 : " + vo.getIo_date());
		System.out.println("===========================================");
		
	}
}
