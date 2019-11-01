package com.biz.iolist.service;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.config.DBConnection;
import com.biz.iolist.dao.DeptDao;
import com.biz.iolist.dao.IolistDao;
import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.IolistVO;

public class IolistServiceV1 {

	protected IolistDao iDao;
	protected DeptDao dDao;
	protected ProductDao pDao;
	protected IolistViewDao vDao;
	Scanner scan;
	
	public IolistServiceV1() {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		this.iDao = sqlSession.getMapper(IolistDao.class);
		this.pDao = sqlSession.getMapper(ProductDao.class);
		this.dDao = sqlSession.getMapper(DeptDao.class);
		this.vDao = sqlSession.getMapper(IolistViewDao.class);
		
		scan = new Scanner(System.in);
	}
	public void viewAllList() {
		List<IolistVO> iolist = vDao.selectAll();
		for(IolistVO vo : iolist) {
			System.out.println(vo.toString());
		}
	}
}
