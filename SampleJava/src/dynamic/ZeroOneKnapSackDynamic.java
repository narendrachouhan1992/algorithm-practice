package dynamic;

public class ZeroOneKnapSackDynamic {
	static int knapSack(int W, int[] w,int[] v,int n)
	{
		int[][] dp= new int[n+1][W+1]; 
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				if(j==0 || i==0)
				{
					dp[i][j] = 0;
				}
				else if(w[i-1]>W)
				{
					dp[i][j] = dp[i-1][j]; 
				}
				else
				{
					dp[i][j] = Math.min((v[i-1]+ dp[i-1][j-w[i-1]]), dp[i-1][j]);
				}
			}
		}
		return dp[n][W];
	}
	static int knapSack1(int W, int wt[], int val[], int n)
	{
		int i, w;
	int K[][] = new int[n+1][W+1];
	
	// Build table K[][] in bottom up manner
	for (i = 0; i <= n; i++)
		{
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
	return K[n][W];
	}
	public static void main(String args[])
	{
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack1(W, wt, val, n));
    }
}
