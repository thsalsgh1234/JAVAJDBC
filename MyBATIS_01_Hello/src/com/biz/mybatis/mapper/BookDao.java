package com.biz.mybatis.mapper;

import java.util.List;

import com.biz.mybatis.persistence.BookDTO;

public interface BookDao {

	public List<BookDTO> selectAll();
	
	public BookDTO findByID(String b_code);
	
	public int insert(BookDTO bookDTO);
	
	public int update(BookDTO bookDTO);
	
	
}
