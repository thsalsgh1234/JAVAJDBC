package com.biz.iolist.dao;

import java.util.List;

import com.biz.iolist.persistence.IolistDTO;

public interface IolistDao {
	
	public List<IolistDTO> selectAll();
	
	public IolistDTO findById(long io_seq);
	
	public void insert(IolistDTO iolistDTO);
	
	public void update(IolistDTO iolistDTO);
	
	public void delete(long io_seq);
}
