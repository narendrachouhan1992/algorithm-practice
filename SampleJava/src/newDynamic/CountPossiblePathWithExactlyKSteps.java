package newDynamic;

public class CountPossiblePathWithExactlyKSteps {
	static int getNumberOfPath(boolean[][] graph,int source,int dest, int K)
	{
		int size = graph.length;
		int[][][] sol = new int[size][size][K+1];
		for(int k =0;k<=K;k++)
		{
			for(int i =0;i<size;i++)
			{
				for(int j =0;j<size;j++)
				{	
					sol[i][j][k] = 0;
					if(k==0 && i==j)
						sol[i][j][k]= 1;
					if(k==1 && graph[i][j])
						sol[i][j][k] = 1;
					
					if(k>1)
					{
						for(int a=0;a<size;a++)
						{
							if(graph[i][a])
							{
								sol[i][j][k] += sol[a][j][k-1];
							}
						}
					}
					
				}
			}
		}
		
		return sol[source][dest][K];
	}
	public static void main(String[] args) {
		boolean[][] graph = { {false,true, true, true},
				                {false, false, false, true},
				                {false, false, false, true},
				                {false, false, false, false}
				              };
		System.out.println(getNumberOfPath(graph, 0, 3, 2
				));
	}
}
