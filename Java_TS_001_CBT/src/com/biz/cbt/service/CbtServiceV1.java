package com.biz.cbt.service;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.CbtDao;
import com.biz.cbt.persistence.CbtDTO;
import com.biz.cbt.persistence.CbtVO;

public class CbtServiceV1 {

	Scanner scan;
	protected CbtDao cDao;
	
	
	public CbtServiceV1() {
		
		cDao = DBConnection.getSqlSessionFactory()
				.openSession(true)
				.getMapper(CbtDao.class);
		scan = new Scanner(System.in);
	}
	
	public void viewAllList() {
		List<CbtDTO> cbtList = cDao.selectAll();
		for(CbtDTO dto : cbtList) {
			System.out.println(dto);
		}
	}
	
	public void viewQandA() {
		
		List<CbtDTO> cbtList = cDao.selectAll();
		List<CbtVO> qandAList = new ArrayList<CbtVO>();
			
		System.out.println("==========================");
		System.out.println("정보처리기사기출문제");
		System.out.println("==========================");
		
		for(CbtDTO dto : cbtList) {
			
			CbtVO cbtVO = CbtVO.builder()
					.cb_questions(dto.getCb_questions())
					.cb_seq(dto.getCb_seq())
					.cb_qnums(new ArrayList<String>()).build();
			
			cbtVO.getCb_qnums().add(dto.getCb_qnum1());
			cbtVO.getCb_qnums().add(dto.getCb_qnum2());
			cbtVO.getCb_qnums().add(dto.getCb_qnum3());
			cbtVO.getCb_qnums().add(dto.getCb_qnum4());
			
			qandAList.add(cbtVO);
		}
		
		Collections.shuffle(qandAList);

		int nums = 1;
		for(CbtVO vo : qandAList) {
			System.out.print(nums++ + "번 ");
			System.out.println(vo.getCb_questions());
			Collections.shuffle(vo.getCb_qnums());
	
			int aNums = 1;
			for(String s : vo.getCb_qnums()) {
				System.out.print(aNums++ + ". ");
				System.out.println(s);
			}
			
		}
		
	}
	public void menucbt() {
		System.out.println("정보처리기사기출문제");
		System.out.println("==================================");
		System.out.println("1.문제입력 2.문제풀이 3.문제종료" );
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			
		} else if (intMenu == 2) {
			
		} else if (intMenu == 3) {
		
		
	}
	
}
	public void inputMenu() {
		System.out.println("==================================");
		System.out.println("도서 정보 관리");
		System.out.println("==================================");
		System.out.println("1.문제등록 2.문제수정 3.문제삭제 0.종료");
		System.out.print("선택하세요 >>");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			
		} else if (intMenu == 2) {
			
		} else if (intMenu == 3) {
			
		} else if (intMenu == 0) {

		}
	}
}