package com.biz.config.exec;

import com.biz.iolist.service.pro.ProductServiceV1;
import com.biz.iolist.service.pro.ProductServiceV2;

public class ProEx_02 {

	public static void main(String[] args) {
		
		ProductServiceV2 ps = new ProductServiceV2();
		ps.searchPName();
		ps.proUpdate();
	}
}
