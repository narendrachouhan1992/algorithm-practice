package dynamic;

public class LongestPalendromicSubsequenceDynamic {
	static int lpss(String str)
	{
		int[][] dp = new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++)
		{
			for(int j=i;j<str.length();j++)
			{
				if(i==j)
				{
					dp[i][j]= 1;
				}
				else if(str.charAt(i)==str.charAt(j) && i+1==j)
				{
					dp[i][j]=2;
				}
				else if(str.charAt(i)==str.charAt(j))
				{
					dp[i][j] = 2+dp[i+1][j-1];
				}
				else
				{
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
	return dp[0][str.length()-1];
	}
	 static int lps(String seq)
	    {
	       int n = seq.length();
	       int i, j, cl;
	       int L[][] = new int[n][n];  // Create a table to store results of subproblems
	      
	       // Strings of length 1 are palindrome of lentgh 1
	       for (i = 0; i < n; i++)
	           L[i][i] = 1;
	              
	        // Build the table. Note that the lower diagonal values of table are
	        // useless and not filled in the process. The values are filled in a
	        // manner similar to Matrix Chain Multiplication DP solution (See
	        // http://www.geeksforgeeks.org/archives/15553). cl is length of
	        // substring
	        for (cl=2; cl<=n; cl++)
	        {
	            for (i=0; i<n-cl+1; i++)
	            {
	                j = i+cl-1;
	                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
	                   L[i][j] = 2;
	                else if (seq.charAt(i) == seq.charAt(j))
	                   L[i][j] = L[i+1][j-1] + 2;
	                else
	                   L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
	            }
	        }
	              
	        return L[0][n-1];
	    }
	         
	public static void main(String args[])
    {
        String seq = "GEEKSFORGEEKS";
        System.out.println("The lnegth of the lps is "+ lps(seq));
    }
}
