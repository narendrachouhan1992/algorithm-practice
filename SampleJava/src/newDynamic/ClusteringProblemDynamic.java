package newDynamic;

public class ClusteringProblemDynamic {
	static int getMax(int[] arr, int num)
	{
		int size = arr.length;
		int[][] dp = new int[size+1][num+1];
		for(int i =0;i<=size;i++)
			for(int j = 0;j<=num;j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
				
			}
		dp[0][0] = 0;
		for(int i =1;i<size;i++)
		{
			for(int j = 1;j<num;j++)
			{
				for(int m = i-1;m>=0;m--)
				{
					dp[i][j] = Integer.min(dp[i][j], dp[m][j-1]+(arr[i-1]- arr[m])*(arr[i-1]- arr[m]));
				}
			}
		}
		return dp[size-1][num-1];		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 8, 10};
		System.out.println(getMax(arr, 2));
	}
}
