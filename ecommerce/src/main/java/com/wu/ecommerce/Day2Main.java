package com.wu.ecommerce;

public class Day2Main {

	public static void main(String [] args) {
		
		int a=0;
		try {
			a=10/0;
			System.out.println("inside try");
			System.out.println(a);
		}
		catch (Throwable e){
			a=10/2;
			System.out.println("inside catch : " + e.getLocalizedMessage());
			
		}
		

		finally {
			System.out.println(a);
		}
		
		
	}
	
	
}
