	package dynamic;

	import java.util.Arrays;

	public class LongestCommonSubString {
		static int lcs( char[] X, char[] Y, int m, int n )
		{
			int[][] DP = new int[m][n];
			int result=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==0 || j==0)
					{
						DP[i][j] = 0;
					}
					else if(X[i]==Y[j])
					{
						DP[i][j]= DP[i-1][j-1]+1;
						result = Integer.max(DP[i][j], result);
					}
					else
					{
						DP[i][j]= 0;
					}
				}
			}
		   return result;
		}
		public static void main(String[] args) 
		{
			char X[] = "OldSite:GeeksforGeeks.org".toCharArray();
			char Y[] = "NewSite:GeeksQuiz.com".toCharArray();
			int m = X.length;
			int n = Y.length;
		 
		  System.out.println("Length of LCS is "+ lcs( X, Y, m, n ) ); 
		}
	}
