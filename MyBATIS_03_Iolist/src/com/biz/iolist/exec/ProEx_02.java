package com.biz.iolist.exec;

import com.biz.iolist.config.service.ProductServiceV2;

public class ProEx_02 {

	public static void main(String[] args) {
		
		ProductServiceV2 ps = new ProductServiceV2();
		
		ps.searchPNmae();
		ps.proUpdate();
	}
}
