package com.biz.hello;

public class HelloEx_02 {

	/*
	 * mian() method
	 * 이클립스 도구에서 Run(실행, Ctrl + F11)을 눌러서
	 * 어떤 명령문들의 실행을 시켜볼수 있도록 만든 기본 method
	 */
	public static void main(String[] args) {
			
		add();
		add(30,40);
		add(40,50);
		add(50,60);
		add(60,70);
		add(70,80);
		add(80,90);
	}
	
	public static void add() {
		
		
		
		
	}
	
	public static void add(int n1, int n2) {
		int sum = n1+n2;
		System.out.println(sum);
	}
	

}
