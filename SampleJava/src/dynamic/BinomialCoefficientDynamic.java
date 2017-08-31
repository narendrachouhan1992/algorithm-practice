package dynamic;

public class BinomialCoefficientDynamic {
	static int binomialCoeff(int n,int k)
	{
		int[][] dp= new int[n+1][k+1];
		
		for (int i = 0; i <= n; i++)
	    {
	        for (int j = 0; j <= Math.min(i, k); j++)
	        {
	            // Base Cases
	            if (j == 0 || j == i)
	                dp[i][j] = 1;
	      
	            // Calculate value using previosly stored values
	            else
	                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	          }
	     }
	 return dp[n][k];     
	}
	 public static void main(String args[])
	    {
	    int n = 5, k = 2;
	    System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k));
	    }
}
