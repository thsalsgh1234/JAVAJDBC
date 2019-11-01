package com.biz.rent.service;

import java.util.Scanner;

import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.BookDao;
import com.biz.rent.dao.UserDao;

public class RentBookServiceV1 {

	
	Scanner scan;
	protected BookDao bDao;
	protected UserDao udao;
	
	public RentBookServiceV1() {
		
		bDao = DBConnection.getSqlSessionFactory().openSession(true)
				.getMapper(BookDao.class);
		scan = new Scanner(System.in);
		
		
		
	}
	
	public void RentBookMenu() {
	System.out.println("===========================");
	System.out.println("도서관");
	System.out.println("===========================");
	System.out.println("1.도서검색 2.회원검색 3.대출 4.반납  0.종료");
	System.out.println("업무선택");
	String strMenu = scan.nextLine();
	int intMenu = Integer.valueOf(strMenu);
	if (intMenu == 1) {
		
	} else if (intMenu == 2) {
		
	} else if (intMenu == 3) {
		
		
	} else if (intMenu == 4) {
		
	} else if (intMenu == 0) {

	  }
	}
	public void RentBookSearch() {
		
		
}
}

