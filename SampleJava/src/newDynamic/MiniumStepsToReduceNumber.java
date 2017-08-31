package newDynamic;

public class MiniumStepsToReduceNumber {
	static int getMinimumSteps(int n)
	{
		if(n==1)
			return 0;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		for(int i= 2;i<=n;i++)
		{
			if(i%2 ==0 & i%3==0 )
			{
				dp[i] = 1+ Integer.min(Integer.min(dp[i-1], dp[i/2]), dp[i/3]);
			}
			else if(i%2 ==0)
			{
				dp[i] = 1+ Integer.min(dp[i-1], dp[i/2]);
			}
			else if(i%3 == 0)
			{
				dp[i] = 1+ Integer.min(dp[i-1], dp[i/3]);
			}
			else
				dp[i] = 1+ dp[i-1];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(getMinimumSteps(10));
	}
}
