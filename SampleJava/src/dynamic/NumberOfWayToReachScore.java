package dynamic;

public class NumberOfWayToReachScore {
	static int numberOfWays(int n, int[] options)
	{
		int[] ways = new int[n+1];
		ways[0] = 1;
		
		for(int i=0;i<options.length;i++)
		{
			for(int j =options[i];j<=n;j++)
			{
				ways[j]+=ways[j-options[i]];
			}
		}
		return ways[n];
	}
	public static void main(String[] args) {
		int[] run = {3,5,10};
		System.out.println(numberOfWays(20, run));
	}
}
