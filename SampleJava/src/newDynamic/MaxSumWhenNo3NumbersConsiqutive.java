package newDynamic;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class MaxSumWhenNo3NumbersConsiqutive {
	static int getSum(int[] arr)
	{
		int size = arr.length;
		int[] dp = new int[size];
		dp[0] = arr[0];
		dp[1] = arr[0]+arr[1];
		dp[2] = Integer.max(Integer.max(dp[1], arr[0]+arr[2]), arr[1]+ arr[2]);
		for(int i=3;i<size;i++)
		{
			dp[i] = Integer.max(Integer.max(dp[i-1]
					, dp[i-2]+arr[i]), 
					dp[i-3]+ arr[i-1]+ arr[i]);
			
		}
		System.out.println("mymethod "+Arrays.toString(dp));
		return dp[size-1];
	}
	static int newmethod(int[] arr)
	{
		int n = arr.length;
		int[] sum= new int[n];
		 
	    // Base cases (process first three elements)
	    sum[0] = arr[0];
	    sum[1] = arr[0] + arr[1];
	    sum[2] = Integer.max(sum[1], arr[1] + arr[2]);
	 
	    // Process rest of the elements
	    // We have three cases
	    // 1) Exclude arr[i],  i.e.,  sum[i] = sum[i-1]
	    // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
	    // 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1]
	    for (int i=3; i<n; i++)
	        sum[i] = Integer.max(Integer.max(sum[i-1], sum[i-2] + arr[i]),
	                     arr[i] + arr[i-1] + sum[i-3]);

	    System.out.println("gfg method "+ Arrays.toString(sum));
	    return sum[n-1];
	}
	public static void main(String[] args) {
		int[] arr = {100, 1000, 100, 1000, 1};
		System.out.println(newmethod(arr));
		System.out.println(getSum(arr));
	}
}
