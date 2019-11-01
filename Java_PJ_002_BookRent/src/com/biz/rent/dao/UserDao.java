package com.biz.rent.dao;



import java.util.List;

import com.biz.rent.persistence.UserDTO;

public interface UserDao {
	
	
public String getMaxPCode();
	
	public List<UserDTO> selectAll();
	public UserDTO findById(String u_code);
	
	public List<UserDTO> findByName(String u_name);
	public List<UserDTO>findByTel(String u_tel);
	public UserDTO findByAddr(String u_addr);

	public int insert(UserDTO udto);
	public int update(UserDTO udto);
	public int delete(String u_code);

	public String getMaxUCode();

	public List<UserDTO> findBynametel(String strUName, String strTel);
	 
}
