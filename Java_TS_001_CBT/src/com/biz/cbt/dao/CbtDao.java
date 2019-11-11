package com.biz.cbt.dao;

import java.util.List;

import com.biz.cbt.persistence.CbtDTO;



public interface CbtDao {

	
	public CbtDTO findById(String StrCcode);

	public List<CbtDTO> selectAll();

	public String getMaxCCCode();
	
	public int insert(CbtDTO cdto);
	public int update(CbtDTO cdto);
	public int delete(String StrCcode);
}
