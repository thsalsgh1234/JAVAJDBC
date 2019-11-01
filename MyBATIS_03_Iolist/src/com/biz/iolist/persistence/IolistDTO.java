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
public class IolistDTO {

	private long IO_SEQ;
	private String IO_DATE;
	private String IO_INOUT;
	private int IO_QTY;
	private int IO_PRICE;
	private int IO_TOTAL;
	private String IO_PCODE;
	private String IO_DCODE;
	
}
