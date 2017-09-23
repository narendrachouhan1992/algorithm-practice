package newDynamic;

public class NumberOfBinaryStringWithNoConsicutivesZero {
	 static int getNumberOfStrings(int n)
	 {
		 int[] a = new int[n+1];  //number of string with no consicutive 1 ending at 0
		 int[] b = new int[n+1]; //number of string with no consicutive 1 ending at 1
		 
		 a[1] = 1;
		 b[1] = 1;
		 
		 for(int i =2;i<=n;i++)
		 {
			 a[i] = a[i-1]+b[i-1];
			 b[i] = a[i-1];
		 }
		 return (a[n]+b[n]);
	 }
	 public static void main(String[] args) {
		System.out.println(getNumberOfStrings(3));
		
	}
}
