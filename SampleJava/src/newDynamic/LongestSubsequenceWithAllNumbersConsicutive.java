package newDynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubsequenceWithAllNumbersConsicutive {
	static int getLength(int[] arr)
	{
		int size = arr.length;
		int dp[] = new int[size];
		for(int i=0;i<size;i++)
		{
			dp[i] = 1;
		}
		for(int i=1;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(arr[i]== arr[j]+1 ||
						arr[i]+1 == arr[j])
				{
					dp[i] = Integer.max(dp[i], arr[j]+1);
				}
			}
		}
		int max = 1;
		for (int i = 0; i < size; i++) {
			if(max<dp[i])
				max = dp[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 3, 2};
		System.out.println(getLength(arr));
	}
}
