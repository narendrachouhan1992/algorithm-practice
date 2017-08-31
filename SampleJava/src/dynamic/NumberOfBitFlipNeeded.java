package dynamic;

public class NumberOfBitFlipNeeded {
	void getCount(int a, int b)
	{
		int x = a^b;
		String p = Integer.toBinaryString(x);
		System.out.println(p);
		System.out.println(Integer.bitCount(x));
	}
	public static void main(String[] args) {
		int a= 123;
		System.out.println(Integer.toBinaryString(a));
		int b= 231;
		System.out.println(Integer.toBinaryString(b));
		NumberOfBitFlipNeeded obj= new NumberOfBitFlipNeeded();
		obj.getCount(a, b);
	}
}
