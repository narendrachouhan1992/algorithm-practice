package dynamic;

public class MaximumSizeSubMatrixWithAllOne {
	static void getArraySize(int[][] arr, int l, int b) {
		int[][] maxSq = new int[l][b];
		for(int i=0;i<l;i++)
			maxSq[i][0] = arr[i][0];
		
		for(int j=0;j<b;j++)
				maxSq[0][j]=arr[0][j];
		int max= -1;
		for(int i = 1;i<l;i++)
			for(int j=1;j< b;j++)
			{
				if(arr[i][j] ==1)
				{
					maxSq[i][j] = Math.min(maxSq[i][j-1], Math.min(maxSq[i-1][j], maxSq[i-1][j-1])) + 1;
					if(max<maxSq[i][j])
					{
						max = maxSq[i][j];
					}
				}
				else
				{
					maxSq[i][j]=0;
				}
			}
		System.out.println("max size is "+max);
	}
	public static void main(String[] args) 
	{
		int X = 1;
		int O = 0;
		int[][] M =    {{O, X, X, O, X}, 
							{X, X, O, X, O}, 
							{O, X, X, X, O},
							{X, X, X, X, O},
							{X, X, X, X, X},
							{O, O, O, O, O}};
		getArraySize(M, 6, 5);
		
	}
}
