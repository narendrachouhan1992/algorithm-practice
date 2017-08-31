package dynamic;

public class MatrixChainMultiplicationDynamic2 {
	static int matrixChainMulti(int[] arr, int n)
	{
		int[][] dp = new int[n+1][n+1];
		int q;
		for(int i=0;i<=n;i++)
		{
			dp[i][i] = 0;
			if(i<n-1)
			dp[i][i+1] = arr[i]*arr[i+1];
		}
		for(int i=1;i<n-1;i++)
		{
			for(int j=i+2;j<n;j++)
			{
				if(j==n)
					continue;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k=i; k<j; k++)
	                {
	                    // q = cost/scalar multiplications
	                    q = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
	                    if (q < dp[i][j])
	                        dp[i][j] = q;
	                }
			}
		}
		
		
		return dp[1][n];
	}
	 public static void main(String args[])
	    {
	        int arr[] = new int[] {1, 2, 3, 4, 3};
	        int n = arr.length;
	 
	        System.out.println("Minimum number of multiplications is "+
	        		matrixChainMulti(arr, 5));
	 
	    }
}

