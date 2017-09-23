package newDynamic;

import java.util.Arrays;

class Pair implements Comparable<Pair> 
{
	int north;
	int south;
	public Pair(int north,int south) {
		this.south = south;
		this.north = north;
	}
	public Pair() {
	}
	@Override
	public int compareTo(Pair o) {
		if(this.south == o.south)
		{
			if(this.north>=o.north)
			{
				return 1;
			} 
			else
			{
				return -1;
			}
		}
		else
		{
			if(this.south>o.south)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
	
}
public class NumberOfBridge {
	static int getMaxNumberOfBridge(Pair[] arr)
	{
		int size = arr.length;
		int dp[] = new int[size];
		Arrays.sort(arr);
		for(int i =0;i<size;i++)
		{
			dp[i]= 1;
		}
		for(int i =1;i<size;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i].north>arr[j].north && (dp[j]+1>dp[i]))
				{
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = dp[0];
	    for (int i=1; i<size; i++)
	        if (max < dp[i])
	            max = dp[i];
		
		
		return max;
	}
	public static void main(String[] args) {
		Pair[] arr = {new Pair(6, 2), new Pair(4, 3), new Pair(2, 6), new Pair(1, 5)};
		System.out.println(getMaxNumberOfBridge(arr));
	}
}
