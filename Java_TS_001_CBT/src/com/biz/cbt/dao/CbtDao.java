package com.biz.cbt.dao;

import java.util.List;

import com.biz.cbt.persistence.CbtDTO;

public interface CbtDao {

	
	public List<CbtDTO> selectAll();
}
