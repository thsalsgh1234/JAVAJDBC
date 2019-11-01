package com.biz.rent.service;

import java.util.List;
import java.util.Scanner;


import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.BookDao;
import com.biz.rent.persistence.BookDTO;

public class BookServiceV1 {

	Scanner scan;
	protected BookDao bDao;
	
	public BookServiceV1() {
		
		bDao = DBConnection.getSqlSessionFactory().openSession(true)
				.getMapper(BookDao.class);
		scan = new Scanner(System.in);
	}
	
	public void viewAllList() {
		List<BookDTO> bList = bDao.selectAll();
		if(bList == null || bList.size() < 1) {
			System.out.println("리스트가 없음");
			}else {
				this.viewList(bList);
			}		
	}
	protected void viewList(BookDTO bto) {
		System.out.print(bto.getB_code() + "\t");
		System.out.print(bto.getB_name() + "\t");
		System.out.print(bto.getB_auther() + "\t");
		System.out.print(bto.getB_comp() + "\t");
		System.out.print(bto.getB_year() + "\t");
		System.out.print(bto.getB_iprice() + "\t");
		System.out.print(bto.getB_rprice() + "\n");
		
	}
	protected void viewList(List<BookDTO> bList) {

	      System.out.println("============================================================");
	      System.out.println("도서정보리스트");
	      System.out.println("============================================================");
	      System.out.println("도서코드\t도서명\t저자\t출판사\t구입연도\t구입가격\t대여가격");
	      System.out.println("------------------------------------------------------------");
	      for (BookDTO bto : bList) {
	         this.viewList(bto);
	      }
	      System.out.println("============================================================");
	   }
	
	public void viewbookAndAther() {
		
		System.out.println("=============================================");
		System.out.print("도서명 : ");
		String strBName = scan.nextLine();

		System.out.print("저자명 : ");
		String strAther = scan.nextLine();
		
		List<BookDTO> bList = null;
		if(strBName.trim().isEmpty() && strAther.trim().isEmpty()) {
			bList = bDao.selectAll();
		} else if (strBName.trim().isEmpty()) {
			bList = bDao.findByAuther(strAther);
		} else if (strAther.trim().isEmpty()) {
			bList = bDao.findByName(strBName);
		} else {
			bList = bDao.findByAndAuther(strBName, strAther);
		}
		this.viewList(bList);
		
	}
	
	
	
	
	public void menuBook() {
		System.out.println("==================================");
		System.out.println("도서 정보 관리");
		System.out.println("==================================");
		System.out.println("1.등록 2.수정 3.삭제 4.검색 0.끝");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			this.bookInsert();
		} else if (intMenu == 2) {
			this.bookUpdate();
		} else if (intMenu == 3) {
			this.bookDelete();
			
		} else if (intMenu == 4) {
			this.viewbookAndAther();
		} else if (intMenu == 0) {

		}
	}
	
	public void bookInsert() {
		BookDTO bdto = new BookDTO();
		System.out.println("==============================");
		String strBcode;
		while(true) {
			System.out.println("도서코드(Enter : 자동생성), 0 : 종료");
		strBcode = scan.nextLine();
		if(strBcode.equals("0")) break;
		if(strBcode.trim().isEmpty()) {
			String strTMPCode = bDao.getMaxBCode();
			int intBcode = Integer.valueOf(strTMPCode.substring(2));
			intBcode++;
			strBcode = strTMPCode.substring(0, 2);
			strBcode += String.format("%04d", intBcode);
			
			System.out.println("생성된 코드 : " + strBcode);
			System.out.println("사용 하려면 Enter를 누르세요");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				bdto.setB_code(strBcode);
			break;
			}
			else continue;
			
		}
			if(strBcode.length() != 6) {
				System.out.println("상품코드는 6자리");
				continue;
			}
			strBcode = strBcode.toUpperCase();
			if(strBcode.substring(0, 2).equalsIgnoreCase("BK")) {
			System.out.println("상품코드는 BK로 시작");
			continue;
				
		}
		try {
			Integer.valueOf(strBcode.substring(2));
		} catch (Exception e) {
			System.out.println("상품코드 3번째 이후는 숫자만가능");
			continue;
			// TODO: handle exception
		}
		
		if(bDao.findById(strBcode) != null) {
			System.out.println("이미 등록된 코드");
			continue;
		}
			break;
			
		}
		if(strBcode.equals("0")) return;
		
		String strBName;
		while(true) {
			System.out.print("도서명(0 : 종료) : ");
			strBName = scan.nextLine();
			if (strBName.equals(0)) break;
			if(strBName.trim().isEmpty()) {
				System.out.println("도서이름 입력");
				continue;
			}
			bdto.setB_name(strBName);
			break;
		}
		String strauther;
		while(true) {
			System.out.print("저자(0 : 종료) : ");
			strauther = scan.nextLine();
			if (strauther.equals(0)) break;
			if(strauther.trim().isEmpty()) {
				System.out.println("저자 입력");
				continue;
			}
			bdto.setB_auther(strauther);
			break;
		}
		String strcomp;
		while(true) {
			System.out.print("출판사(0 : 종료) : ");
			strcomp = scan.nextLine();
			if (strcomp.equals(0)) break;
			if(strcomp.trim().isEmpty()) {
				System.out.println("출판사 입력");
				continue;
			}
			bdto.setB_comp(strcomp);
			break;
		}
		String stryear;
		int intyear;
		while(true) {
			System.out.print("구입연도(0 : 종료) : ");
			stryear = scan.nextLine();
			if (stryear.equals(0)) break;
			if(stryear.trim().isEmpty()) {
				System.out.println("구입연도 입력");
				continue;
			}
			
			intyear = Integer.valueOf(stryear);
			bdto.setB_year(intyear);
			break;
		}
		
		String striprice;
		int intiprice;
		while(true) {
			System.out.print("구입가격(0 : 종료) : ");
			striprice = scan.nextLine();
			if (striprice.equals(0)) break;
			if(striprice.trim().isEmpty()) {
				System.out.println("구입가격입력 ");
				continue;
			}
			intiprice = Integer.valueOf(striprice);
			bdto.setB_iprice(intiprice);
			break;
		}
		
		String strrprice;
		int intrprice;
		while(true) {
			System.out.print("대여가격(0 : 종료) : ");
			strrprice = scan.nextLine();
			if (strrprice.equals(0)) break;
			if(strrprice.trim().isEmpty()) {
				System.out.println("대여가격 입력");
				continue;
			}
			intrprice = Integer.valueOf(strrprice);
			bdto.setB_rprice(intrprice);
			break;
		}
		while(true) {	
		
			if(bdto != null) {
			

			System.out.println("-----------------------------------");
			System.out.print("도서코드 : "+ bdto.getB_code()+"\n");
			System.out.print("도서명 : "+ bdto.getB_name()+"\n");
			System.out.print("저자 : "+ bdto.getB_auther()+"\n");
			
			System.out.print("출판사 : "+ bdto.getB_comp()+"\n");
			System.out.print("구입연도 : "+ bdto.getB_year()+"\n");
			System.out.print("구입가격 : "+ bdto.getB_iprice()+"\n");
			System.out.print("대여가격 : "+ bdto.getB_rprice()+"\n");
			System.out.println("------------------------------------");
			System.out.println("사용 E/N");
			String yesNo = scan.nextLine();
			if(yesNo.trim().isEmpty())break;
			
			continue;	
		}		
	}
		int ret = bDao.insert(bdto);
		if(ret > 0 ) {
			System.out.println("데이터 등록성공");
			
		}else {
			System.out.println("데이터 등록실패");
		}
	}
	
	protected void viewDetail(BookDTO bdto) {
		
		System.out.println("==========================");
		System.out.print("도서코드 : "+ bdto.getB_code());
		System.out.print("도서명 : "+ bdto.getB_name());
		System.out.print("저자 : "+ bdto.getB_auther());
		
		System.out.print("출판사 : "+ bdto.getB_comp());
		System.out.print("구입연도 : "+ bdto.getB_year());
		System.out.print("구입가격 : "+ bdto.getB_iprice());
		System.out.print("대여가격 : "+ bdto.getB_rprice());
		System.out.println("------------------------------");
	}
	
protected BookDTO viewDetail(String strBCode) {
	BookDTO bdto = bDao.findById(strBCode);
	if( bdto == null)
		return null;
	
		
		System.out.println("==========================");
		System.out.print("도서코드 : "+ bdto.getB_code());
		System.out.print("도서명 : "+ bdto.getB_name());
		System.out.print("저자 : "+ bdto.getB_auther());
		
		System.out.print("출판사 : "+ bdto.getB_comp());
		System.out.print("구입연도 : "+ bdto.getB_year());
		System.out.print("구입가격 : "+ bdto.getB_iprice());
		System.out.print("대여가격 : "+ bdto.getB_rprice());
		System.out.println("------------------------------");
		
		return bdto;
	}
	
	
	public void bookUpdate() {
		
		System.out.println("=======================");
		System.out.print("수정할 코드 : ");
		String strBCode = scan.nextLine();
		strBCode = strBCode.toUpperCase();
		
		BookDTO bdto = this.viewDetail(strBCode);
		System.out.print("수정할 도서명 : ");
		String strBName = scan.nextLine();
		if(!strBName.trim().isEmpty()) {
			bdto.setB_name(strBName);
			
		}
		System.out.print("저자명 : ");
		String strBather = scan.nextLine();
		if (!strBather.trim().isEmpty()) {
			bdto.setB_auther(strBather);
		}
		System.out.print("출판사 : ");
		String strComp = scan.nextLine();
		if (!strComp.trim().isEmpty()) {
			bdto.setB_comp(strComp);
		}
		System.out.print(" 구입연도 : ");
		String stryear = scan.nextLine();
		if (!stryear.trim().isEmpty()) {
		int intyear = Integer.valueOf(stryear);
		bdto.setB_year(intyear);
			
		}
		System.out.print("구입가격: ");
		String striprice = scan.nextLine();
		if (!striprice.trim().isEmpty()) {
		int intiprice = Integer.valueOf(striprice);
		bdto.setB_iprice(intiprice);
		}
		System.out.print(" 대여가격 : ");
		String strrprice = scan.nextLine();
		if (!strrprice.trim().isEmpty()) {
		int intrprice = Integer.valueOf(stryear);
		bdto.setB_rprice(intrprice);
		}
		int ret = bDao.update(bdto);
		if (ret > 0) {
			System.out.println("데이터변경 완료");
		} else {
			System.out.println("데이터변경 실패");
		}
		
	}
		
		
	public void bookDelete() {	
		System.out.println("==============================================");
		while (true) {
			System.out.print("삭제할 도서코드(0 : 종료) : ");
			String strBCode = scan.nextLine();
			if (strBCode.equals("0"))
				break;
			BookDTO bdto = bDao.findById(strBCode);
			if(bdto == null) {
				System.out.println("삭제할 코드가 없음");
				continue;
			}
			this.viewDetail(bdto);
			System.out.println("삭제 Enther : 실행");
			String strYesNo = scan.nextLine();
			if(strYesNo.trim().isEmpty()) {
				int ret = bDao.delete(strBCode);
				if (ret > 0) {
					System.out.println("삭제완료");
					
				}else
					System.out.println("삭제실패");
						
			}							
	}
		
}
	
}
	
