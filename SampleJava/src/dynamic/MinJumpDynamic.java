package dynamic;

public class MinJumpDynamic {
	static int numOfJump(int[] arr)
	{
		if(arr.length==0 || arr[0]==0)
			return Integer.MAX_VALUE;
		
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 0;
		for(int i=1;i<n;i++)
		{
			dp[i]= Integer.MAX_VALUE; 
			for(int j=0;j<i;j++)
			{
				if(i<= j+arr[j]  && dp[j]!= Integer.MAX_VALUE)
				{
					dp[i] = Integer.min(dp[i], (dp[j]+1));
					break;
				}
			}
		}
			
		return dp[n-1];
	}
	
	public static void main(String[] args) {
	    int[] arr = {1, 3, 6, 1, 0, 9};
	    System.out.println("Minimum number of jumps to reach end is "+numOfJump(arr));
	}
}
