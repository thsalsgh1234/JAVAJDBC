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

public class ProductDTO {

	private String p_code;
	private String p_name;
	private int p_iprice;
	private int p_oprice;
	private String p_vat;
	
}
