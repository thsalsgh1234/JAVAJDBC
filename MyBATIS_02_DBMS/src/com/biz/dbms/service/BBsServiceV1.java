package com.biz.dbms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.dbms.config.DBConnection;
import com.biz.dbms.config.persistence.BBsDTO;
import com.biz.dbms.dao.BBsDao;

public class BBsServiceV1 {
	
	SqlSession sqlSession = null;
	Scanner scanner = null;
	
	
	public BBsServiceV1() {
		sqlSession = DBConnection.getSqlSessionFactory()
					.openSession(true);
		
		scanner = new Scanner(System.in);
	}

	
	public void writeBBS() {
		
		
		/*
		 * 작성자, 제목, 내용을 입력하지 않으면
		 * 메시지를 보여주고 다시 입력을 받도록 하자
		 * 왜 bs_writer , bs_subject, bs_text 는 NO NULL
		 */
		while(true) {
			
			System.out.println("작성자(-Q:작성중단) >> ");
			String strWriter = scanner.nextLine();
			if(strWriter.equals("-Q")) break;
			
			if(strWriter.trim().length() < 1) {
				System.out.println("작성자는 반드시 입력해야 합니다.");
				continue;
			}
			
			System.out.println("제목 >> ");
			String strSubject = scanner.nextLine();
			if(strSubject.equals("-Q")) break;	
			if(strSubject.trim().length() < 1) {
				System.out.println("작성자는 반드시 입력해야 합니다.");
				continue;
			}
			
			System.out.println("내용 >> ");
			String strText = scanner.nextLine();
			if(strText.equals("-Q")) break;	
			if(strText.trim().length() < 1) {
				System.out.println("작성자는 반드시 입력해야 합니다.");
				continue;
			}
			
			
			/*
			 * 작성일자, 작성시각은 컴퓨터 시간을 참조하여
			 * 자동 생성을 하자.
			 */
			
			//java 1.7 이하의 코드작성
			
			// 컴퓨터의 현재 시각가져오기
			
			Date date = new Date(System.currentTimeMillis());
			
			//date 날짜형 값을 " 2019-10-24:의 문자열형으로 변환
			SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
			
			//date 날짜형 값을 " 14:00:00" 의 문자열형으로 변환
			SimpleDateFormat tf = new SimpleDateFormat("HH:MM:SS");
			
			String curDate = df.format(date);
			String curTime = df.format(date);
			
			// 입력받은 데이터와 날짜, 시각을 DTO에 담기
			BBsDTO bbsDTO = BBsDTO.builder()
					.bs_date(curDate)
					.bs_time(curTime)
					.bs_writer(strWriter)
					.bs_subject(strSubject)
					.bs_text(strText)
					.build();
		
		
		BBsDao bbsDao = sqlSession.getMapper(BBsDao.class);
		int ret = bbsDao.insert(bbsDTO);
		
		if(ret > 0) {
			System.out.println("게시판 작성완료!!");
			
		}else {
			System.out.println("게시판 작성 실패!!");
		}
		System.out.print("계속작성 ? (Yes/No)");
		String yesNo = scanner.nextLine();
		if(yesNo.equals("N") || yesNo.equalsIgnoreCase("NO")) {
			break;
		}
		
		
		
	}

	}
	public void viewBBsList() {
		
		BBsDao bbsdao = sqlSession.getMapper(BBsDao.class);
		List<BBsDTO> bbsList = bbsdao.selectAll();
		
		System.out.println("====================");
		System.out.println("슈퍼 BBS v1");
		System.out.println("====================");
		System.out.println("작성자\t시각\t작성자\t제목");
		
		
		for(BBsDTO bbs : bbsList) {
			System.out.print(bbs.getBs_date() + "\t");
			System.out.print(bbs.getBs_time() + "\t");
			System.out.print(bbs.getBs_writer() + "\t");
			
		}
		
	}

}
