package test;

public class TestInteger {
	public static void main(String[] args) {
		int x = Integer.MAX_VALUE;
		System.out.println(x);
		System.out.println(Integer.toBinaryString(x));
		x++;
		System.out.println(x);
		System.out.println(Integer.toBinaryString(x));
		
	}
}
