package com.biz.cbt.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class CbtDTO {

	
	private long cb_seq;//	NUMBER
	private String cb_questions;//	nVARCHAR2(1000)
	private String cb_qnum1;//	nVARCHAR2(1000)
	private String cb_qnum2;//	nVARCHAR2(1000)
	private String cb_qnum3;//	nVARCHAR2(1000)
	private String cb_qnum4;//	nVARCHAR2(1000)
	private String cb_answer;//	nVARCHAR2(1000)

}
