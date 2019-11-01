package com.biz.iolist.service.dept;

import com.biz.iolist.persistence.DeptDTO;

public class DeptServiceV2 extends DeptServiceV1 {

	public void deptMenu() {
		System.out.println("==============================================");
		System.out.println("거래처 장부");
		System.out.println("==============================================");
		System.out.println("1.등록 2.수정 3.삭제 4.검색 0.종료");
		System.out.println("----------------------------------------------");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		try {
			int intMenu = Integer.valueOf(strMenu);
			if (intMenu == 0)
				return;
			if (intMenu == 1) {
				this.deptInsert();
			} else if (intMenu == 2) {
				this.viewNameList();
				this.deptUpdate();
			} else if (intMenu == 3) {
				this.viewNameList();
				this.deptDelete();
			} else if (intMenu == 4) {
				this.viewNameAndCEOList();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void deptDelete() {
		System.out.println("==============================================");
		while (true) {
			System.out.print("삭제할 거래처 코드(0 : 종료) : ");
			String strDCode = scan.nextLine();
			if (strDCode.equals("0"))
				break;
			DeptDTO ddto = dDao.findById(strDCode);
			if (ddto == null) {
				System.out.println("삭제할 코드가 없음");
				continue;
			}

			this.viewDetail(ddto);
			System.out.println("삭제 Enter : 실행");
			String strYesNo = scan.nextLine();
			if (strYesNo.trim().isEmpty()) {
				int ret = dDao.delete(strDCode);
				if (ret > 0) {
					System.out.println("삭제완료");
				} else
					System.out.println("삭제실패");
			}
		}
	}

	public void deptUpdate() {
		System.out.println("==============================================");
		System.out.print("수정할 코드 : ");
		String strDCode = scan.nextLine();
		strDCode = strDCode.toUpperCase();

		DeptDTO ddto = this.viewDetail(strDCode);
		System.out.print("거래처명 : ");
		String strDName = scan.nextLine();
		if (!strDName.trim().isEmpty()) {
			ddto.setD_name(strDName);
			;
		}
		System.out.print("대표자명 : ");
		String strDCEO = scan.nextLine();
		if (!strDCEO.trim().isEmpty()) {
			ddto.setD_ceo(strDCEO);
		}
		System.out.print("전화번호 : ");
		String strTel = scan.nextLine();
		if (!strTel.trim().isEmpty()) {
			ddto.setD_tel(strTel);
		}
		System.out.print("주소 : ");
		String strAddr = scan.nextLine();
		if (!strAddr.trim().isEmpty()) {
			ddto.setD_addr(strAddr);
		}
		int ret = dDao.update(ddto);
		if (ret > 0) {
			System.out.println("데이터변경 완료");
		} else {
			System.out.println("데이터변경 실패");
		}
	}
	
	public void deptInsert() {
		
	}

	protected DeptDTO viewDetail(String strDCode) {
		DeptDTO ddto = dDao.findById(strDCode);
		if (ddto == null)
			return null;
		System.out.println("==============================================");
		System.out.println("상호 : " + ddto.getD_name());
		System.out.println("대표 : " + ddto.getD_ceo());
		System.out.println("전화 : " + ddto.getD_tel());
		System.out.println("주소 : " + ddto.getD_addr());
		System.out.println("업종 : 슈퍼마켓");
		System.out.println("업체 : 도,소매");
		System.out.println("사업자번호 : 409-01-0001");
		System.out.println("담당자 : 홍길동");
		System.out.println("담당자 번호 : 010-4053-9404");
		System.out.println("==============================================");
		return ddto;
	}
}
