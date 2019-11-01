package com.biz.dbms.dao;

import java.util.List;

import com.biz.dbms.config.persistence.BBsDTO;

public interface BBsDao {
	
	public List<BBsDTO> selectAll();
	
	public BBsDTO findById(long bs_id);
	
	public int insert(BBsDTO bbsDTO);
	
	public int update(BBsDTO bbsDTO);
	
	public int delete(long bs_id); //delete는 fundByid랑 매개변수를 같이함
	
	
	
	

}
