package com.biz.iolist.dao;

import java.util.List;

import com.biz.iolist.persistence.IolistDTO;

public interface IolistDao {

	public List<IolistDTO> selectAll();
	public IolistDTO findById(long io_seq);
	public int insert(IolistDTO idto);
	public int update(IolistDTO idto);
	public int delete(long io_seq);
}
