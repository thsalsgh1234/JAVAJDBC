package com.biz.iolist.service.pro;

import org.apache.ibatis.session.SqlSession;

import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV3 extends ProductServiceV2 {

	public void menuProduct() {
		System.out.println("==================================");
		System.out.println("대한쇼핑몰 상품관리시스템");
		System.out.println("==================================");
		System.out.println("1.등록 2.수정 3.삭제 4.검색 0.끝");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		if (intMenu == 1) {
			this.insertProduct();
		} else if (intMenu == 2) {
			this.proUpdate();
		} else if (intMenu == 3) {
			this.searchPName();
			this.deleteProduct();
		} else if (intMenu == 4) {
			this.searchPName();
		} else if (intMenu == 0) {

		}
	}

	public void insertProduct() {

		System.out.println("====================================");

		String strPCode;
		while (true) {

			System.out.println("상품코드(Enter : 자동생성), 0 : 종료 ");
			strPCode = scan.nextLine();
			if (strPCode.equals("0"))
				break;
			if (strPCode.trim().isEmpty()) {
				String strTMPCode = pDao.getMaxPCode();
				int intPCode = Integer.valueOf(strTMPCode.substring(1));
				intPCode++;
				strPCode = strTMPCode.substring(0, 1);
				strPCode += String.format("%04d", intPCode);

				System.out.println("생성된 코드 : " + strPCode);
				System.out.println("사용 하려면 Enter");
				String strYesNo = scan.nextLine();
				if (strYesNo.trim().isEmpty())
					break;
				else
					continue;
			}
			if (strPCode.length() != 5) {
				System.out.println("상품코드는 5자리");
				continue;
			}
			strPCode = strPCode.toUpperCase();
			if (strPCode.substring(0, 1).equalsIgnoreCase("P")) {
				System.out.println("상품코드 첫글자 P로 시작");
				continue;
			}
			try {
				Integer.valueOf(strPCode.substring(1));

			} catch (Exception e) {
				System.out.println("상품코드 2번째 이후는 숫자만 가능");
				continue;
			}

			if (pDao.findById(strPCode) != null) {
				System.out.println("이미 등록된 코드");
				continue;
			}
			break;
		}
		if (strPCode.equals("0"))
			return;

		String strPName;
		while (true) {
			System.out.print("상품이름(0 : 종료) : ");
			strPName = scan.nextLine();
			if (strPName.equals("0"))
				break;
			if (strPName.trim().isEmpty()) {
				System.out.println("상품이름 입력");
				continue;
			}
			ProductDTO pdto = pDao.findBySName(strPName);
			if (pdto != null) {
				System.out.println("====================================");
				System.out.println("같은 이름의 상품이 있음");
				System.out.println("------------------------------------");
				System.out.println("상품 코드 : " + pdto.getP_name());
				System.out.println("품목 : ");
				System.out.println("주매입처 : ");
				System.out.println("매입단가 : " + pdto.getP_iprice());
				System.out.println("매출단가 : " + pdto.getP_oprice());
				System.out.println("------------------------------------");
				System.out.println("사용 E/N");
				String yesNo = scan.nextLine();
				if (yesNo.trim().isEmpty())
					break;
				continue;
			}
		}
	}

	public void deleteProduct() {
		System.out.println("====================================");
		System.out.print("삭제할 상품 코드(종료(0) : ");
		String strcode = scan.nextLine();

		ProductDTO pdto = this.viewPDetail(strcode);
		if (pdto == null) {
			System.out.println("상품코드가 없음");
			return;
		}
		pDao.delete(strcode);
		int ret = pDao.delete(strcode);
		if (ret > 0) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
