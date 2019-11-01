package com.biz.addr.persistence.dao;

import java.sql.Connection;
import java.util.List;

import com.biz.addr.config.DBConnection;
import com.biz.addr.persistence.AddrDTO;

public abstract class AddrDao {

	
	protected Connection dbConn = null;
	
	public AddrDao() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	public abstract List<AddrDTO> selectAll();
	
	public abstract AddrDTO findByid(long id);
	
	public abstract List<AddrDTO> findByName(String name);
	public abstract List<AddrDTO> findByTel(String tel);
	public abstract List<AddrDTO> findByChain(String chain);
	
	public abstract int insert(AddrDTO addrDTO);
	public abstract int update(AddrDTO addrDTO);
	public abstract int delete(String id);
	
	/*
	 * dbConnection 부분
  selectAll();
  findByid(long id);
  findByName(String name);
  findByTel(String tel);
  findByChain(String chain);
	 */
}
	

