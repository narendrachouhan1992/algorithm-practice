package dynamic;

public class WordWrap {
	int printSolution (int p[], int n)
    {
        int k;
        if (p[n] == 1)
        k = 1;
        else
        k = printSolution (p, p[n]-1) + 1;
        System.out.println("Line number" + " " + k + ": " + 
                    "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }
	void wordWrap(int[] words, int lineSize)
	{
		int size = words.length;
		int[][] extraSpaces = new int[size+1][size+1];
		int[][] lineCost = new int[size+1][size+1];
		int[] cost = new int[size+1];
		int[] printArray = new int[size+1];
		final int MAX = Integer.MAX_VALUE;
		for(int i=1;i<=size;i++)
		{
			extraSpaces[i][i] = lineSize-words[i-1];
			for(int j=i+1;j<=size;j++)
			{
				extraSpaces[i][j]= extraSpaces[i][j-1] - words[j-1]-1;
			}
		}
		for(int i=1;i<=size;i++)
		{
			for(int j=i;j<=size;j++)
			{
				if(extraSpaces[i][j]<0)
				{
					lineCost[i][j] = MAX;
				}
				if(j==size && extraSpaces[i][j]>=0)
				{
					lineCost[i][j] = 0;
				}
				else
				{
					lineCost[i][j] = extraSpaces[i][j]*extraSpaces[i][j];
				}
			}
		}
		// Calculate minimum cost and find minimum cost arrangement.
        // The value c[j] indicates optimized cost to arrange words
        // from word number 1 to j.
		cost[0] = 0;
		for(int j=1;j<=size;j++)
		{
			cost[j]= MAX;
			for(int i=1;i<=j;i++)
			{
				if(cost[i-1]!=MAX && lineCost[i][j]!=MAX && (cost[i-1]+lineCost[i][j]<cost[i]))
				{
					cost[i] = cost[i-1]+ lineCost[i][j];
					printArray[j]= i;
				}
			}
		}
		
		printSolution(printArray, size);
	}
	 public static void main(String args[])
    {
        WordWrap w = new WordWrap();
        int l[] = {3, 2, 2, 5};
        int M = 6;
        w.wordWrap (l, M);
    }

}
