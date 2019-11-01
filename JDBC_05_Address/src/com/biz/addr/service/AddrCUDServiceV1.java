package com.biz.addr.service;

import java.util.Scanner;

import com.biz.addr.persistence.dao.AddrDao;

public class AddrCUDServiceV1 {

	private AddrDao addrDao = null;
	private Scanner scanner = null;
	
	public AddrCUDServiceV1() {
		scanner = new Scanner(System.in);
		addrDao = new AddrDaoImp();
	}
	
}
