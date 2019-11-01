package com.biz.iolist.persistence;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DeptDTO {

	
	private String d_code;
	private String d_name;
	private String d_ceo;
	private String d_tel;
	private String d_addr;
}
