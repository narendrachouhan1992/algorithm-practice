package mediumPackage;

public class NumberOfPathsInMaze {
	static int getNumberOfPath(int[][] maze){
		int X = maze.length;
		int Y = maze[0].length;
		
		if(maze[0][0]==-1)
			return 0;
		for(int i=0;i<X;i++)
		{
			if(maze[i][0]==0)
			{
				maze[i][0]=1;
			}
			else
			{
				break;
			}
		}
		for(int i=1;i<Y;i++)
		{
			if(maze[0][i]==0)
			{
				maze[0][i]=1;
			}
			else
			{
				break;
			}
		}
		for(int i=1;i<X;i++)
		{
			for(int j=1;j<Y;j++)
			{
				if (maze[i][j] == -1)
	                continue;
	 
				if(maze[i-1][j]>0)
				{
					maze[i][j]+=maze[i-1][j];
				}
				if(maze[i][j-1]>0)
				{
					maze[i][j]+=maze[i][j-1];
				}
			}
		}
		if(maze[X-1][Y-1]<=0)
		{
			return 0;
		}
		else
		{
			return maze[X-1][Y-1];
		}
	}
	public static void main(String[] args) {
		int[][] maze = {{0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
		System.out.println(getNumberOfPath(maze));
	}
}
