package com.biz.iolist.service.pro;

import java.util.List;
import java.util.Scanner;

import com.biz.config.DBConnection;
import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV1 {

	protected ProductDao pDao;
	Scanner scan;

	public ProductServiceV1() {

		this.pDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(ProductDao.class);
		scan = new Scanner(System.in);
	}

	protected ProductDTO viewPDetail(String strPCode) {
		ProductDTO pdto = pDao.findById(strPCode);
		
		if(pdto == null ) return null;
		
		System.out.println("===============================================");
		System.out.printf("상품코드 : %s\n", pdto.getP_code());
		System.out.printf("상품이름 : %s\n", pdto.getP_name());
		System.out.printf("매입단가 : %d\n", pdto.getP_iprice());
		System.out.printf("매출단가 : %d\n", pdto.getP_oprice());
		String strVAT = pdto.getP_vat().equals("1") ? "과세" : "면세";
		System.out.printf("과세여부(1.과세,2.면세 : %s)\n", strVAT);
		System.out.println("===============================================");
		
		return pdto;
	}
	
	public void proUpdate() {
//		List<ProductDTO> proList = pDao.selectAll();
//		for (ProductDTO dto : proList) {
//			System.out.println(dto.toString());
//		}
		System.out.println("===============================================");
		System.out.print("수정할 상품코드 : ");
		String strPCode = scan.nextLine();
		strPCode = strPCode.toUpperCase();
		
		ProductDTO pdto = this.viewPDetail(strPCode);
				
		System.out.printf("상품명(%s) : ",pdto.getP_name());
		String strName = scan.nextLine();
		if (!strName.trim().isEmpty()) {
			pdto.setP_name(strName);
		}
		System.out.printf("매입단가(%d) : ",pdto.getP_iprice());
		String strIPrice = scan.nextLine();
		try {
			pdto.setP_iprice(Integer.valueOf(strIPrice));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.printf("매출단가(%d) : ",pdto.getP_oprice());
		String stOIPrice = scan.nextLine();
		try {
			pdto.setP_oprice(Integer.valueOf(stOIPrice));
		} catch (Exception e) {
			// TODO: handle exception
		}
		int ret = pDao.update(pdto);
		if(ret>0) {
			System.out.println("데이터변경 완료");
		}else {
			System.out.println("데이터변경 실패");
		}
		System.out.println(pDao.findById(strPCode).toString());
	}
}
