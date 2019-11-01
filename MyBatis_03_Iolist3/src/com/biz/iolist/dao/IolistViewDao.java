package com.biz.iolist.dao;

import java.util.List;

import com.biz.iolist.persistence.IolistVO;

public interface IolistViewDao {

		public List<IolistVO> selectAll();
		public IolistVO findById(long io_seq);
		
		public List<IolistVO> findByDCode(String io_dcode);
		public List<IolistVO> findByPCode(String io_pcode);
		public List<IolistVO> findByDname(String d_name);
		public IolistVO findByDdname(String d_name);
		public List<IolistVO> findByPName(String p_name);
}
