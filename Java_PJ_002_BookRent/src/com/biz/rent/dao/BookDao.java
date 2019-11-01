package com.biz.rent.dao;





import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.rent.persistence.BookDTO;



public interface BookDao {
	
	
	public String getMaxBCode();
	
	public List<BookDTO> selectAll();
	public BookDTO findById(String b_code);
	
	public List<BookDTO> findByName(String b_name);
	public BookDTO findBySName(String b_name);
	public List<BookDTO> findByAuther(String b_auther);
	
	public List<BookDTO> findByAndAuther(
			@Param("b_name") String b_name,
			@Param("b_auther") String b_auther);
	
	
	public int insert(BookDTO bdto);
	public int update(BookDTO bdto);
	public int delete(String b_code);
	public List<BookDTO> findByprice(
			@Param("iprice") int iprice,
			@Param("rprice") int rprice); 
}
