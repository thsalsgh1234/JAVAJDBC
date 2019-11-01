package com.biz.config.exec;

import com.biz.iolist.service.pro.ProductServiceV3;

public class ProEx_03 {

	public static void main(String[] args) {
		
		ProductServiceV3 ps = new ProductServiceV3();
		ps.searchPName();
		//ps.proUpdate();
		ps.deleteProduct();
	}
}
