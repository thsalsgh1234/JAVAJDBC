package com.biz.cbt.persistence;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CbtVO {

	
	private long cb_seq;		//	number
	private String cb_questions;//	nvarchar2(1000 char)
	private List<String> cb_qnums ;
	private List<String> answers;
	private String cho;
	private String collect;
}
