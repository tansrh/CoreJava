package com.wu.ecommerce;
@FunctionalInterface
public interface FunctionalInterfaceDemo {

	public int add(int a, int b);
	
	default void test() {
		System.out.println("test");
	}
	default void test1() {
		System.out.println("test1");
	}
}
class Test{
	public static void getResult(FunctionalInterfaceDemo fi) {
		int res=fi.add(10, 5);
		System.out.println(res);
		fi.test();
		
		
	}
	public static void main(String[] args) {
		getResult((a, b)->a+b);
	}
	
}