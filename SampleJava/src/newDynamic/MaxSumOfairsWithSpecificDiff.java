package newDynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxSumOfairsWithSpecificDiff {
	static int getMaxSum(int[] arr, int dif)
	{
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		int size = arr.length;
		System.out.println(Arrays.toString(arr));
		int[] dp = new int[size];
		dp[0] = 0;
		for(int i =1;i<size;i++)
		{
			dp[i] = dp[i-1];
			if (arr[i] - arr[i-1] < dif)
			{
				if(i>=2)
				{
					dp[i] = Integer.max(dp[i], (dp[i-2]+arr[i-1])+ arr[i]);
				}
				else
				{
					dp[i]= Integer.max(dp[i], arr[i]+ arr[i]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[size-1];
	}
	public static void main(String[] args) {
		int[] arr = {3, 5, 10, 15, 17, 12, 9};
		System.out.println(getMaxSum(arr, 4));
	}
}
