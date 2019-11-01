package com.biz.addr.service;

import java.util.List;
import java.util.Scanner;

import com.biz.addr.persistence.AddrDTO;
import com.biz.addr.persistence.dao.AddrDao;

public class AddrServiceV1 {

	AddrDao addrDao = null;
	Scanner scanner = null;
	
	
	public AddrServiceV1(){
		
		scanner = new Scanner(System.in);
		addrDao = new AddrDaoImp();
		
	}
	
	public void viewAddrList() {
		
		List<AddrDTO> addrList = addrDao.selectAll();	
		
		this.viewList(addrList);
		
	}
	
	private void viewList(List<AddrDTO> addrList) {
		System.out.println("================================");
		System.out.println("전체 주소 리스트 V1");
		System.out.println("================================");
		System.out.println("아이디\t이름\t전화번호\t관계");
		System.out.println("--------------------------------");
		
		for(AddrDTO dto : addrList) {
			System.out.printf("%d\t",dto.getId());
			System.out.printf("%s\t",dto.getName());
			System.out.printf("%s\t",dto.getTel());
			System.out.printf("%s\n",dto.getChain());
		}
		System.out.println("================================");
	}
	
	public void searchAddrName(boolean bconti) {
		while(true) {
			if(this.searchAddrName() != null) break;
		}
	}
	public String searchAddrName() {
		System.out.println("===============================");
		System.out.println("이름검색");
		System.out.println("이름(-Q:quit) >> ");
		String strName = scanner.nextLine();
		if(strName.equals("-Q ")) return "-Q";
		this.searchAddrName(strName);
		return strName;
		
	}
	public boolean searchAddrName(String strName) {
		List<AddrDTO> addrList
		= addrDao.findByName(strName);
		if(addrList == null || addrList.size() < 1) {
			System.out.println("찾는 이름이 없음!!");
			
		}
		
		this.viewList(addrList);
		return true;
	}
	
}

