package com.biz.iolist.service.dept;

import com.biz.iolist.persistence.DeptDTO;
import com.biz.iolist.persistence.ProductDTO;

public class DeptServiceV3 extends DeptServiceV2 {

	public void deptInsert() {
		System.out.println("==============================================");
		String strDCode;
		while (true) {
			System.out.println("거래코드(Enter : 자동생성), 0: 종료");
			strDCode = scan.nextLine();
			if (strDCode.equals("0"))
				break;
			if (strDCode.trim().isEmpty()) {
				String strTMDCode = dDao.getMaxDCode();
				int intDCode = Integer.valueOf(strTMDCode.substring(1));
				intDCode++;
				strDCode = strTMDCode.substring(0, 1);
				strDCode += String.format("%04d", intDCode);

				System.out.println("생성된 코드 : " + strDCode);
				System.out.println("사용하려면 Enter");
				String strYesNo = scan.nextLine();
				if (strYesNo.trim().isEmpty())
					break;
				else
					continue;
			}
			if (strDCode.length() != 5) {
				System.out.println("상품코드 5자리");
				continue;
			}
			strDCode = strDCode.toUpperCase();
			if (strDCode.substring(0, 1).equalsIgnoreCase("D")) {
				System.out.println("상품 첫코드 D");
				continue;
			}
			try {
				Integer.valueOf(strDCode.substring(1));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("상품코드 두번째 코드 숫자");
				continue;
			}
			if (dDao.findById(strDCode) != null) {
				System.out.println("이미 등록됨");
				continue;
			}
			break;

		}
		if (strDCode.equals("0"))
			return;
	
		String strDName;
		while (true) {
			System.out.print("거래명(0 : 종료) : ");
			strDName = scan.nextLine();
			if (strDName.equals("0"))
				break;
			if (strDName.trim().isEmpty()) {
				System.out.println("거래 입력");
				continue;
			}
			DeptDTO ddto = dDao.findByDName(strDName);
			if (ddto != null) {
				this.viewDetail(ddto);
				System.out.println("사용 E/N");
				String yesNo = scan.nextLine();
				if (yesNo.trim().isEmpty())
					break;
				continue;
			}
			break;
		}
		
		String strDCEO;
		while (true) {
			System.out.print("대표자명(0 : 종료) : ");
			strDCEO = scan.nextLine();
			if (strDCEO.equals("0"))
				break;
			if (strDCEO.trim().isEmpty()) {
				System.out.println("대표자명 입력");
				continue;
			}
			DeptDTO ddto = dDao.findByDCEO(strDCEO);
			if (ddto != null) {
				this.viewDetail(ddto);
				System.out.println("사용 E/N");
				String yesNo = scan.nextLine();
				if (yesNo.trim().isEmpty())
					break;
				continue;
			}
			break;
		}
		
		while (true) {
					
			System.out.print("전화번호 : ");
			String strDTel = scan.nextLine();
			if (strDTel.equals("0"))
				break;
			if (strDTel.trim().isEmpty()) {
				System.out.println("전화번호 입력");
				continue;
			}
			System.out.print("주소 : ");
			String strDAddr = scan.nextLine();
			if (strDAddr.equals("0"))
				break;
			if (strDAddr.trim().isEmpty()) {
				System.out.println("전화번호 입력");
				continue;
			}
			DeptDTO ddto = DeptDTO.builder().d_code(strDCode).d_name(strDName).d_ceo(strDCEO).d_tel(strDTel)
					.d_addr(strDAddr).build();
			int ret = dDao.insert(ddto);
			if (ret > 0) {
				System.out.println("입력완료");
			} else {
				System.out.println("입력실패");
			}
			break;
		}

	}

}
