package com.biz.rent.dao;

import java.util.List;

import com.biz.rent.persistence.RentBookDTO;

public interface RentBookDao {

	

	
	public List<RentBookDTO> selectAll();
	
	
	public List<RentBookDTO> findByName(String rb_name);
	

	public int insert(RentBookDTO RBDTO);
	public int update(RentBookDTO RBDTO);
	public int delete(long rent_seq);
	
}
