package newDynamic;

import static java.lang.Integer.*;

public class MaxSumstartingAndAEndingAnyRow {
	static int getMaxSum(int[][] dp,int start_i,int start_j,int end_i,int end_j)
	{
		int X = dp.length;
		int Y = dp[0].length;
		for(int i=end_i-1;i>=start_i;i--)
		{
			for(int j = 0;j<Y;j++)
			{
				 if(j<Y-1 && j>0)
				 {
					 dp[i][j] = max(max(dp[i+1][j], dp[i+1][j+1]), dp[i+1][j-1]);
				 }
				 else if(j==0 )
				 {
					 dp[i][j] = max(dp[i+1][j], dp[i+1][j+1]);
				 }
				 else if (j==Y-1)
				 {
					 dp[i][j] = max(dp[i+1][j], dp[i+1][j-1]);
				 }
			}
		}
		return dp[start_i][start_j];
	}
	public static void main(String[] args) 
	{
		int[][] Mat = { { 4, 2 , 3 , 4 },
		        { 2 , 9 , 1 , 10},
		        { 15, 1 , 3 , 0 },
		        { 16 ,92, 41, 44 }};
		System.out.println(getMaxSum(Mat, 0, 2, 3, 2));	
	}
}
