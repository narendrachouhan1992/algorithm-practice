package newDynamic;

public class CountDecodingRecursive {
	static int getNumberOfDecoding(char[] num, int n)
	{
		if(n==0 || n==1)
		{
			return 1;
		}
		int count=0;
		if(num[n-1]>'0')
		{
			count+=getNumberOfDecoding(num, n-1);
		}
		
		if((num[n-2]=='1' || num[n-2]=='2') && num[n-1]<'7')
		{
			count+= getNumberOfDecoding(num, n-2);
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(getNumberOfDecoding("1234".toCharArray(), 4));
	}
}
