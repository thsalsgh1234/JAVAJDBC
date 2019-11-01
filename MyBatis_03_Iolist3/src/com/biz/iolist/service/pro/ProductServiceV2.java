package com.biz.iolist.service.pro;

import java.util.List;

import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV2 extends ProductServiceV1 {

	public void searchPName() {
		System.out.print("상품명(Enter) : ");
		String strName = scan.nextLine();

		List<ProductDTO> proList = null;
		if (strName.trim().isEmpty()) {
			proList = pDao.selectAll();
		} else {
			proList = pDao.findByName(strName);
		}
		for (ProductDTO dto : proList) {
			System.out.println(dto.toString());
		}
	}
}
