package dynamic;

public class NumberOfEdit {
	
	public static int numberOfOperation(String str1, String str2)
	{
		int l1 = str1.length();
		int l2 = str2.length();
		int[][] dp = new int[l1+1][l2+1];
		
		for(int i=0;i<=l1;i++)
			for(int j=0;j<=l2;j++)
			{
				if(i==0)
				{
					dp[i][j] = j;
				}
				else if (j==0)
				{
					dp[i][j] = i;
				}
				else if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = 1+ Integer.min(dp[i-1][j], Integer.min(dp[i-1][j-1], dp[i][j-1]));
				}
			}
		return dp[l1][l2];
	}
	public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("number of operation " +numberOfOperation( str1 , str2) );
    }
}
