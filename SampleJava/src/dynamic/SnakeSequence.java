package dynamic;

public class SnakeSequence {
	static void printSnake(int[][] arr, int m, int n)
	{
		if(n==0 && m==0)
			return ;
		int[][] sol = new int[m][n];
		int max_i = 0;
		int max_j = 0;
		int max = 0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 && j==0)
				{
					sol[i][j] = 1;
				}
				else if(i==0 && j!=0)
				{
					if(arr[i][j]+1 == arr[i][j-1] || arr[i][j] == arr[i][j-1]+1)
					{
						sol[i][j] = sol[i][j-1]+1;
 					}
					else
					{
						sol[i][j] = 1;
					}
				}
				else if(j==0 && i!=0)
				{
					if(arr[i][j]+1 == arr[i-1][j] || arr[i][j] == arr[i-1][j]+1)
					{
						sol[i][j] = sol[i-1][j]+1;
 					}
					else
					{
						sol[i][j] = 1;
					}
				}
				else
				{
					if((arr[i][j]+1 == arr[i-1][j] || arr[i][j] == arr[i-1][j]+1) && (arr[i][j]+1 == arr[i][j-1] || arr[i][j] == arr[i][j-1]+1))
					{
						sol[i][j] = Integer.max((sol[i-1][j]+1), (sol[i][j-1]+1));
 					}
					else if(arr[i][j]+1 == arr[i][j-1] || arr[i][j] == arr[i][j-1]+1)
					{
						sol[i][j] = sol[i][j-1]+1;
 					}
					else if(arr[i][j]+1 == arr[i-1][j] || arr[i][j] == arr[i-1][j]+1)
					{
						sol[i][j] = sol[i-1][j]+1;
 					}
					else
					{
						sol[i][j] = 1;
					}
				}
				if(max<sol[i][j])
				{
					max=sol[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		int curr = sol[max_i][max_j];
		System.out.println(arr[max_i][max_j]);
		while(curr!=1)
		{
			if(max_i!=0 && sol[max_i-1][max_j] == curr-1)
			{
				curr--;
				max_i = max_i-1;
			}
			else
			{
				curr--;
				max_j = max_j-1;
				
			}
			System.out.println(arr[max_i][max_j]);
			
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		int[][] mat =
		    {
		        {9, 6, 5, 2},
		        {8, 7, 6, 5},
		        {7, 3, 1, 6},
		        {1, 1, 1, 7},
		    };
		printSnake(mat, 4, 4);
	}
}
