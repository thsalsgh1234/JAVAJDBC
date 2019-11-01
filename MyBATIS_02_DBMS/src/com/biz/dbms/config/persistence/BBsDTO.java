package com.biz.dbms.config.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// AllArg.., Getter , Setter, method들이 없으면
// mybatis가 제데로 작동하지 않는다.
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class BBsDTO {

	/*
	 * DTO, VO를 생성할때
	 * 필드(멤버변수)이름은 TABLE의 칼럼 이름과 같게 설정
	 * mybatis 자동 setter, getter 호출 기능이 잘 작동한다.
	 */
	private long bs_idpk; //	NUMBER
	private String bs_date;//	VARCHAR2(10 BYTE)
	private String bs_time;//	VARCHAR2(10 BYTE)
	private String bs_writer;//	NVARCHAR2(20 CHAR)
	private String bs_subject;//	NVARCHAR2(125 CHAR)
	private String bs_text;//	NVARCHAR2(1000 CHAR)
	private int bs_count;//	NUMBER
}
