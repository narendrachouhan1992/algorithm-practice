package newDynamic;

public class CountDecodingDyn {
	static int getNumberOfDecoding(char[] num)
	{
		int n = num.length;
		if(n==1|| n==0)
		{
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0]= 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++)
		{
			int count = 0;
			if(num[i-1]>'0')
			{
				count+= dp[i-1];
			}
			if((num[i-2]=='1' || num[i-2]=='2') && num[i-1]<'7')
			{
				count += dp[i-2];
			}
			dp[i] = count;
		}
			return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(getNumberOfDecoding("1234".toCharArray()
				));
	}
}
