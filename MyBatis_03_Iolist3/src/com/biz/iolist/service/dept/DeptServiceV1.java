package com.biz.iolist.service.dept;

import java.util.List;
import java.util.Scanner;

import com.biz.config.DBConnection;
import com.biz.iolist.dao.DeptDao;
import com.biz.iolist.persistence.DeptDTO;

public class DeptServiceV1 {

	protected DeptDao dDao;
	Scanner scan;

	public DeptServiceV1() {

		dDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(DeptDao.class);
		scan = new Scanner(System.in);
	}

	public void viewAllList() {
		List<DeptDTO> dList = dDao.selectAll();
		if (dList == null || dList.size() < 1) {
			System.out.println("리스트가 없음");
		} else {
			this.viewList(dList);
		}
	}

	public void viewNameList() {
		System.out.println("=============================================");
		System.out.print("거래처명 : ");
		String strDName = scan.nextLine();
		List<DeptDTO> dList = null;
		if (strDName.trim().isEmpty()) {
			dList = dDao.selectAll();
		} else {
			dList = dDao.findByName(strDName);
		}
		this.viewList(dList);
	}

	public void viewNameAndCEOList() {
		System.out.println("=============================================");
		System.out.print("거래처명 : ");
		String strDName = scan.nextLine();

		System.out.print("대표자명 : ");
		String strCeo = scan.nextLine();

		List<DeptDTO> dList = null;
		if (strDName.trim().isEmpty() && strCeo.trim().isEmpty()) {
			dList = dDao.selectAll();
		} else if (strDName.trim().isEmpty()) {
			dList = dDao.findByCEO(strCeo);
		} else if (strCeo.trim().isEmpty()) {
			dList = dDao.findByName(strDName);
		} else {
			dList = dDao.findByAndCEO(strDName, strCeo);
		}
		this.viewList(dList);
	}

	protected void viewList(DeptDTO dto) {
		System.out.print(dto.getD_code() + "\t");
		System.out.print(dto.getD_name() + "\t");
		System.out.print(dto.getD_ceo() + "\t");
		System.out.print(dto.getD_tel() + "\t");
		System.out.print(dto.getD_addr() + "\n");
		return;
	}

	protected void viewList(List<DeptDTO> dList) {

		System.out.println("=============================================");
		System.out.println("거래처 장부");
		System.out.println("=============================================");
		System.out.println("코드\t거래처명\t대표자\t전화번호\t주소");
		System.out.println("---------------------------------------------");
		for (DeptDTO dto : dList) {
			this.viewList(dto);
		}
		System.out.println("=============================================");
	}

	protected void viewDetail(DeptDTO ddto) {

		System.out.println("==============================================");
		System.out.print("상호 : " + ddto.getD_name());
		System.out.print("대표 : " + ddto.getD_ceo());
		System.out.print("전화 : " + ddto.getD_tel());
		System.out.print("주소 : " + ddto.getD_addr());
		System.out.print("업종 : 슈퍼마켓");
		System.out.print("업체 : 도,소매");
		System.out.print("사업자번호 : 409-01-0001");
		System.out.print("담당자 : 홍길동");
		System.out.print("담당자 번호 : 010-4053-9404");
		System.out.println("==============================================");

	}
}
