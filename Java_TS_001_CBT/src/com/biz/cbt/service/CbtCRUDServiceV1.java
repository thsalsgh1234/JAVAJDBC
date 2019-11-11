package com.biz.cbt.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.CbtDao;
import com.biz.cbt.persistence.CbtDTO;
import com.biz.cbt.persistence.CbtVO;

public class CbtCRUDServiceV1 {

	Scanner scan;
	protected CbtDao cDao;
	
	
	public CbtCRUDServiceV1() {
		
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
	
	

	public void inputMenu() {
		System.out.println("==================================");
		System.out.println("정보처리기사문제");
		System.out.println("==================================");
		System.out.println("1.문제등록 2.문제수정 3.문제삭제 0.종료");
		System.out.print("선택하세요 >>");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			this.cbtInsert();
		} else if (intMenu == 2) {
			this.cbtupdate();
		} else if (intMenu == 3) {
			this.cbtDelete();
		} else if (intMenu == 0) {

		}
		
		
	}
	
	public void cbtInsert() {
		
		CbtDTO cdto = new CbtDTO();
		
		System.out.println("===============================");
		String strCcode;
		while(true) {
			System.out.println("시험코드(Enter : 자동생성), 0:종료");
		strCcode = scan.nextLine();
		if(strCcode.equals("0")) break;
		if(strCcode.trim().isEmpty()) {
			String strTMPcode = cDao.getMaxCCCode();
			int intCcode = Integer.valueOf(strTMPcode);
			intCcode++;
			
			strCcode += String.format("%d", intCcode);
			
			System.out.println("생성된 코드 : " + strCcode);
			System.out.println("사용 하려면 Enter를 누르세요");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				cdto.setCb_seq(intCcode);
				break;
			}
			else continue;
		}	
		if(cDao.findById(strCcode) != null) {
			System.out.println("이미 등록된 코드입니다.");
			continue;
		}
		break;
		
		}
		if(strCcode.equals("0")) return;
		String strque;
		while(true) {
			System.out.print("시험문제(0 : 종료) :");
			strque = scan.nextLine();
			if(strque.equals(0)) break;
			if(strque.trim().isEmpty()) {
				System.out.println("시험문제 입력");
				continue;
			}
			cdto.setCb_questions(strque);
			break;
		}
		
		while(true) {
			System.out.print("보기 1번 > : ");
			String qnum1 = scan.nextLine();
			if (qnum1.equals(0)) break;
			if(qnum1.trim().isEmpty()) {
				System.out.println("입력을 꼭해주세요");
				continue;
			}
			cdto.setCb_qnum1(qnum1);
			break;
		}
		
		while(true) {
			System.out.print("보기 2번 > : ");
			String qnum2 = scan.nextLine();
			if (qnum2.equals(0)) break;
			if(qnum2.trim().isEmpty()) {
				System.out.println("입력을 꼭해주세요");
				continue;
			}
			cdto.setCb_qnum2(qnum2);
			break;
		}
		while(true) {
			System.out.print("보기 3번 > : ");
			String qnum3 = scan.nextLine();
			if (qnum3.equals(0)) break;
			if(qnum3.trim().isEmpty()) {
				System.out.println("입력을 꼭해주세요");
				continue;
			}
			cdto.setCb_qnum3(qnum3);
			break;
		}
		while(true) {
			System.out.print("보기 4번 > : ");
			String qnum4 = scan.nextLine();
			if (qnum4.equals(0)) break;
			if(qnum4.trim().isEmpty()) {
				System.out.println("입력을 꼭해주세요");
				continue;
			}
			cdto.setCb_qnum4(qnum4);
			break;
		}
		while(true) {
			System.out.print("답안 > : ");
			String answer = scan.nextLine();
			if (answer.equals(0)) break;
			if(answer.trim().isEmpty()) {
				System.out.println("입력을 꼭해주세요");
				continue;
			}
			cdto.setCb_answer(answer);
			break;
		}
		int ret = cDao.insert(cdto);
		if(ret > 0) {
			System.out.println("데이터 등록성공!!!!");
			
		}else {
			System.out.println("데이터 등록 실패 ㅠㅠ");
		}
		
		
		
	}
	
	protected void viewDetail(CbtDTO cdto) {
		
		System.out.println("=========================");
		System.out.println("시험코드 : " + cdto.getCb_seq());
		System.out.println("시험문제 : " + cdto.getCb_questions());
		System.out.println("1번문제 : " + cdto.getCb_qnum1());
		System.out.println("2번문제 : " + cdto.getCb_qnum2());
		System.out.println("3번문제 : " + cdto.getCb_qnum3());
		System.out.println("4번문제 : " + cdto.getCb_qnum4());
		System.out.println("답안 : " + cdto.getCb_answer());
		System.out.println("----------------------------");
		
	}
	protected CbtDTO viewDetail(String strCcode) {
		CbtDTO cdto = cDao.findById(strCcode);
		if( cdto == null)
			return null;
		
		System.out.println("=========================");
		System.out.println("시험코드 : " + cdto.getCb_seq());
		System.out.println("시험문제 : " + cdto.getCb_questions());
		System.out.println("1번문제 : " + cdto.getCb_qnum1());
		System.out.println("2번문제 : " + cdto.getCb_qnum2());
		System.out.println("3번문제 : " + cdto.getCb_qnum3());
		System.out.println("4번문제 : " + cdto.getCb_qnum4());
		System.out.println("답안 : " + cdto.getCb_answer());
		System.out.println("----------------------------");
		
		return cdto;
	}
	
	
	public void cbtupdate() {
		
		System.out.println("===================");
		System.out.print("수정할 코드를 입력해주세요 : ");
		String strCcode = scan.nextLine();
		
		CbtDTO cdto = this.viewDetail(strCcode);
		System.out.println("수정할 문제를 입력해주세요 : ");
		String strque = scan.nextLine();
		if(!strque.trim().isEmpty()) {
			cdto.setCb_questions(strque);
			
		}
		System.out.println("수정할 보기1번 : ");
		String strqnum1 = scan.nextLine();
		if(!strqnum1.trim().isEmpty()) {
			cdto.setCb_qnum1(strqnum1);
			
		}
		
		System.out.println("수정할 보기2번 : ");
		String strqnum2 = scan.nextLine();
		if(!strqnum2.trim().isEmpty()) {
			cdto.setCb_qnum2(strqnum2);
			
		}
		
		System.out.println("수정할 보기3번 : ");
		String strqnum3 = scan.nextLine();
		if(!strqnum3.trim().isEmpty()) {
			cdto.setCb_qnum3(strqnum3);
			
		}
		
		System.out.println("수정할 보기4번 : ");
		String strqnum4 = scan.nextLine();
		if(!strqnum4.trim().isEmpty()) {
			cdto.setCb_qnum4(strqnum4);
			
		}
		
		System.out.println("수정할 답을 입력해주세요 : ");
		String stranswer = scan.nextLine();
		if(!stranswer.trim().isEmpty()) {
			cdto.setCb_answer(stranswer);
			
		}
		int ret = cDao.update(cdto);
		if(ret > 0) {
			System.out.println("데이버 변경완료!!!");
		} else {
			System.out.println("데이터변경실패 ㅠㅠ");
		}
		
		
		
		
		
	}
	
	public void cbtDelete() {
		
		System.out.println("=======================");
		while(true) {
			System.out.print("삭제할 문제코드(0 : 종료) : ");
			String strCCode = scan.nextLine();
			if(strCCode.equals("0")) break;
			
			CbtDTO cdto = cDao.findById(strCCode);
			if(cdto == null) {
				System.out.println("삭제할 코드가 없음");
				continue;
			}
			this.viewDetail(cdto);
			System.out.println("삭제 Enter : 실행");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				int ret = cDao.delete(strCCode);
				if( ret > 0) {
					System.out.println("삭제완료!!");
				}else
					System.out.println("삭제실패 ㅠㅠ");
			}
		}
		
	}
	
	
	
	
	
}