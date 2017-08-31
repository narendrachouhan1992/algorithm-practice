package dynamic;

public class MaximumLengthChainOfPairs {
	static class Pair
	{
		int a;
		int b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	static int getlengthOfPairs(Pair[] arr)
	{
		int size = arr.length;
		int[] dp = new int[size];
		for(int i=0;i<size;i++)
		{
			dp[i]= 1;
		}
		for(int i=1;i<size;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j].b<=arr[i].a && dp[j]+1>dp[i])
				{
					dp[i]=dp[j]+1;
				}
			}
		}
		int max=1;
		for (int i = 0; i < size; i++ )
		      if ( max < dp[i] )
		         max = dp[i];
		return max;
	}
	public static void main(String[] args) {
		
		Pair[] arr = new Pair[4];
		arr[0] = new Pair(5, 24);
		arr[1] = new Pair(15, 25);
		arr[2] = new Pair(27, 40);
		arr[3] = new Pair(50, 60);
		System.out.println("Length of maximum size chain is "+ getlengthOfPairs(arr));
	}
}
