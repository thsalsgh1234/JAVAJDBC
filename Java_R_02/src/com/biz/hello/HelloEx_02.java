package com.biz.hello;

public class HelloEx_02 {

	public static void main(String[] args) {
		
		AddClass addclass;
		addclass = new AddClass();
		
		addclass.add();
		
		AddClass addClass2 = new AddClass();
		
		addClass2.add();
		
		addClass2.add(50,60);
		addClass2.add(1,2);
		
		
	}

}
