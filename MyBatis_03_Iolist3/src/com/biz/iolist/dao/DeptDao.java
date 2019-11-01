package com.biz.iolist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.persistence.DeptDTO;

public interface DeptDao {

	public String getMaxDCode();
	
	public List<DeptDTO> selectAll();
	public DeptDTO findById(String d_code);
	public List<DeptDTO> findByName(String d_name);
	public DeptDTO findByDName(String d_name);
	public List<DeptDTO> findByCEO(String d_ceo);
	public DeptDTO findByDCEO(String d_ceo);
	
	public List<DeptDTO> findByAndCEO(
			@Param("d_name") String d_name,
			@Param("d_ceo") String d_ceo);
	public int insert(DeptDTO ddto);
	public int update(DeptDTO ddto);
	public int delete(String d_code);
}
