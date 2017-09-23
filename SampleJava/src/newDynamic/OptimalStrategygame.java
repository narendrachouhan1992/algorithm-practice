package newDynamic;

public class OptimalStrategygame {
	static int getMaxPoints(int[] arr)
	{
		int size = arr.length;
		int[][] dp = new int[size][size];
		
		for(int gap=0;gap<size;gap++)
		{
			for(int i=0, j =gap;j<size;j++,i++)
			{
				int x = (i+2)<=j ? dp[i+2][j] : 0;
				int y = (i+1)<=j-1? dp[i+1][j-1] : 0;
				int z = i<=j-2 ? dp[i][j-2] : 0;
				dp[i][j] = Integer.max(arr[i]+Integer.min(x, y), arr[j]+Integer.min(y, z));
			}
		}
		return dp[0][size-1];
	}
	public static void main(String[] args) {
		int[] arr1 = {8, 15, 3, 7};
		int[] arr2 = {2, 2, 2, 2};
		int[] arr3 = {20, 30, 2, 2, 2, 10};
		System.out.println(getMaxPoints(arr1));
		System.out.println(getMaxPoints(arr2));
		System.out.println(getMaxPoints(arr3));
	}	
}
