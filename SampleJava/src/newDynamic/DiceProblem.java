package newDynamic;

public class DiceProblem {
	static int getNumberOfWays(int m, int n, int X)
	{
		int[][] sol = new int[n+1][X+1];
		
		for(int i =1;i<=m && i<=X;i++)
		{
			sol[1][i] = 1;
		}
		
		for(int i =2;i<=n;i++)
		{
			for(int j=1;j<=X;j++)
			{
				for(int k=1;k<=m &&  k < j;k++)
				{
					sol[i][j]+=sol[i-1][j-k];
				}
			}
		}
		
		return sol[n][X];
	}
	public static void main(String[] args) {
		System.out.println(getNumberOfWays(4, 2, 1));
	    System.out.println(getNumberOfWays(2, 2, 3));
	    System.out.println(getNumberOfWays(6, 3, 8));
	    System.out.println(getNumberOfWays(4, 2, 5));
	    System.out.println(getNumberOfWays(4, 3, 5));
	}
}
