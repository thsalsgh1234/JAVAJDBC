package com.biz.iolist.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IolistVO {
	private long io_seq;		// number
	private String io_date;	//	varchar2(10)
	private String io_inout;	//	nvarchar2(2)
	private String io_dcode;	//	varchar2(5)
	private String d_name;		//	nvarchar2(50)
	private String d_ceo;		//	nvarchar2(50)
	private String d_tel;		//	varchar2(50)
	private String d_addr;		//	nvarchar2(125)
	private String io_pcode;	//	varchar2(5)
	private String p_name;		//	nvarchar2(50)
	private int p_iprice;	//	number
	private int p_oprice;	//	number
	private String p_vat;		//	varchar2(5)
	private int io_qty;		//	number
	private int io_price;	//	number
	private int io_total;	//	number
}
