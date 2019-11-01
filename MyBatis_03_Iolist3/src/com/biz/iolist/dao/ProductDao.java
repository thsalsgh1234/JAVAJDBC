package com.biz.iolist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.persistence.ProductDTO;

public interface ProductDao {

	
	public String getMaxPCode();
	
	public List<ProductDTO> selectAll();
	public ProductDTO findById(String p_code);
	
	public List<ProductDTO> findByName(String p_name);
	public ProductDTO findBySName(String p_name);

	public int insert(ProductDTO pdto);
	public int update(ProductDTO pdto);
	public int delete(String p_code);
	public List<ProductDTO> findByprice(
			@Param("sprice") int sprice,
			@Param("eprice") int eprice); 
}
