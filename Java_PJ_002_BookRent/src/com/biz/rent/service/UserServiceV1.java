package com.biz.rent.service;

import java.util.List;
import java.util.Scanner;

import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.UserDao;
import com.biz.rent.persistence.BookDTO;
import com.biz.rent.persistence.UserDTO;

public class UserServiceV1 {

	Scanner scan;
	protected UserDao uDao;
	
	public UserServiceV1() {
		
		uDao = DBConnection.getSqlSessionFactory().openSession(true)
				.getMapper(UserDao.class);
		scan = new Scanner(System.in);
	}
	
	public void viewAllList() {
		List<UserDTO> uList = uDao.selectAll();
		if(uList == null || uList.size() < 1) {
			System.out.println("리스트가 없음");
			}else {
				this.viewList(uList);
			}		
	}
	protected void viewList(UserDTO udto) {
		System.out.print(udto.getU_code() + "\t");
		System.out.print(udto.getU_name() + "\t");
		System.out.print(udto.getU_tel() + "\t");
		System.out.print(udto.getU_addr() + "\n");
		
		
	}
	protected void viewList(List<UserDTO> uList) {

	      System.out.println("============================================================");
	      System.out.println("회원정보리스트");
	      System.out.println("============================================================");
	      System.out.println("회원코드\t회원명\t전화번호\t주소\t");
	      System.out.println("------------------------------------------------------------");
	      for (UserDTO udto : uList) {
	         this.viewList(udto);
	      }
	      System.out.println("============================================================");
	   }
	
	public void viewUser() {
		
		System.out.println("=============================================");
		System.out.print("회원명 : ");
		String strUName = scan.nextLine();

		System.out.print("전화번호 : ");
		String strTel = scan.nextLine();
		
		List<UserDTO> uList = null;
		if(strUName.trim().isEmpty() && strTel.trim().isEmpty()) {
			uList = uDao.selectAll();
		} else if (strTel.trim().isEmpty()) {
			uList = uDao.findByName(strUName);
		} else if (strUName.trim().isEmpty()) {
			uList = uDao.findByTel(strTel);
		} else {
			uList = uDao.findBynametel(strUName, strTel);
		}
		this.viewList(uList);
		
	}
	
	
	
	
	public void menuUser() {
		System.out.println("==================================");
		System.out.println("유저 정보 관리");
		System.out.println("==================================");
		System.out.println("1.등록 2.수정 3.삭제 4.검색 0.끝");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			this.UserInsert();
		} else if (intMenu == 2) {
			this.UserUpdate();
		} else if (intMenu == 3) {
			this.UserDelete();
			
		} else if (intMenu == 4) {
			this.viewUser();
		} else if (intMenu == 0) {

		}
	}
	
	public void UserInsert() {
		UserDTO udto = new UserDTO();
		System.out.println("==============================");
		String strUcode;
		while(true) {
			System.out.println("유저코드(Enter : 자동생성), 0 : 종료");
		strUcode = scan.nextLine();
		if(strUcode.equals("0")) break;
		if(strUcode.trim().isEmpty()) {
			String strTMPCode = uDao.getMaxUCode();
			int intUcode = Integer.valueOf(strTMPCode.substring(1));
			intUcode++;
			strUcode = strTMPCode.substring(0, 1);
			strUcode += String.format("%04d", intUcode);
			
			System.out.println("생성된 코드 : " + strUcode);
			System.out.println("사용 하려면 Enter를 누르세요");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				udto.setU_code(strUcode);
			break;
			}
			else continue;
			
		}
			if(strUcode.length() != 6) {
				System.out.println("유저코드는 6자리");
				continue;
			}
			strUcode = strUcode.toUpperCase();
			if(strUcode.substring(0, 1).equalsIgnoreCase("S")) {
			System.out.println("상품코드는 S로 시작");
			continue;
				
		}
		try {
			Integer.valueOf(strUcode.substring(1));
		} catch (Exception e) {
			System.out.println("상품코드 2번째 이후는 숫자만가능");
			continue;
			// TODO: handle exception
		}
		
		if(uDao.findById(strUcode) != null) {
			System.out.println("이미 등록된 코드");
			continue;
		}
			break;
			
		}
		if(strUcode.equals("0")) return;
		
		String strUName;
		while(true) {
			System.out.print("회원명(0 : 종료) : ");
			strUName = scan.nextLine();
			if (strUName.equals(0)) break;
			if(strUName.trim().isEmpty()) {
				System.out.println("회원이름 입력");
				continue;
			}
			udto.setU_name(strUName);
			break;
		}
		String strTel;
		
		while(true) {
			System.out.print("전화번호(0 : 종료) : ");
			strTel = scan.nextLine();
			if (strTel.equals(0)) break;
			if(strTel.trim().isEmpty()) {
				System.out.println("전화번호 입력");
				continue;
			}
			
			
			udto.setU_tel(strTel);
			break;
			
		}
		String strAddr;
		while(true) {
			System.out.print("주소(0 : 종료) : ");
			strAddr = scan.nextLine();
			if (strAddr.equals(0)) break;
			if(strAddr.trim().isEmpty()) {
				System.out.println("주소 입력");
				continue;
			}
			udto.setU_addr(strAddr);
			break;
		}
		
		
		
		
		
		
		while(true) {	
		
			if(udto != null) {
			

			System.out.println("-----------------------------------");
			System.out.print("회원코드 : "+ udto.getU_code()+"\n");
			System.out.print("회원명 : "+ udto.getU_name()+"\n");
			System.out.print("전화번호 : "+ udto.getU_tel()+"\n");
			System.out.print("주소 : "+ udto.getU_addr()+"\n");
			System.out.println("------------------------------------");
			System.out.println("사용 E/N");
			String yesNo = scan.nextLine();
			if(yesNo.trim().isEmpty())break;
			
			continue;	
		}		
	}
		int ret = uDao.insert(udto);
		if(ret > 0 ) {
			System.out.println("데이터 등록성공");
			
		}else {
			System.out.println("데이터 등록실패");
		}
	}
	
	protected void UserDetail(UserDTO udto) {
		
		System.out.println("==========================");
		System.out.print("유저코드 : "+ udto.getU_code());
		System.out.print("회원명 : "+ udto.getU_name());
		System.out.print("전화번호 : "+ udto.getU_tel());
		System.out.print("주소 : "+ udto.getU_addr());
		System.out.println("------------------------------");
	}
	
protected UserDTO UserDetail(String strUcode) {
	UserDTO udto = uDao.findById(strUcode);
	if( udto == null)
		return null;
	
		
		System.out.println("==========================");
		System.out.print("회원코드 : "+ udto.getU_code());
		System.out.print("회원명 : "+ udto.getU_name());
		System.out.print("전화번호 : "+ udto.getU_tel());
		System.out.print("주소 : "+ udto.getU_addr());
		System.out.println("------------------------------");
		
		return udto;
	}
	
	
	public void UserUpdate() {
		
		System.out.println("=======================");
		System.out.print("수정할 코드 : ");
		String strUCode = scan.nextLine();
		strUCode = strUCode.toUpperCase();
		
		UserDTO udto = this.UserDetail(strUCode);
		System.out.print("수정할 회원명 : \n");
		String strUName = scan.nextLine();
		if(!strUName.trim().isEmpty()) {
			udto.setU_name(strUName);
			
		}
		System.out.print("전화번호 : \n");
		String strTel = scan.nextLine();
		if (!strTel.trim().isEmpty()) {
			udto.setU_tel(strTel);
		}
		System.out.print("주소 : \n");
		String strAddr = scan.nextLine();
		if (!strAddr.trim().isEmpty()) {
			udto.setU_addr(strAddr);
		}
		
		int ret = uDao.update(udto);
		if (ret > 0) {
			System.out.println("데이터변경 완료");
		} else {
			System.out.println("데이터변경 실패");
		}
		
	}
		
		
	public void UserDelete() {	
		System.out.println("==============================================");
		while (true) {
			System.out.print("삭제할 회원코드(0 : 종료) : ");
			String strBCode = scan.nextLine();
			if (strBCode.equals("0"))
				break;
			UserDTO udto = uDao.findById(strBCode);
			if(udto == null) {
				System.out.println("삭제할 코드가 없음");
				continue;
			}
			this.UserDetail(udto);
			System.out.println("삭제 Enther : 실행");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				int ret = uDao.delete(strBCode);
				if (ret > 0) {
					System.out.println("삭제완료");
					
				}else
					System.out.println("삭제실패");
						
			}							
	}
		
}
	
}
	
