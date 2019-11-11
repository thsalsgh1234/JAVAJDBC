package com.biz.cbt.service;

import java.util.Scanner;

import com.biz.cbt.persistence.TestVO;

public class CbtTestServiceV1 {
		
	private TestVO testVO;
	
	private CbtCRUDServiceV1 crud;
	
	Scanner scanner = new Scanner(System.in);
	
	public CbtTestServiceV1()  {
		
		
		
		
		
	}
	public void takeTestMenu() {
		while (true) {
		System.out.println("=================================================");
		System.out.println("1.문제 입력!\t2.문제풀이!\t0.종료");
		System.out.print("선택 >>>> ");
		String strMenu=scanner.nextLine();
		if(strMenu.equalsIgnoreCase("1")) {
				
			}
		else if(strMenu.equalsIgnoreCase("2")) {
				
			}
		else if(strMenu.equalsIgnoreCase("0")) {
			System.out.println("프로그램 종료");
			return;
			}
		else {
				System.out.println("메뉴선택을 잘못하셨습니다");
			}
		   }
	   }
	
	
}
