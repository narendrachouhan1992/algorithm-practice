package dynamic;

public class MinCostPathRecursive {
	static int minCostPath(int[][] cost, int m,int n)
	{
		
		if(m<0 || n<0)
			return Integer.MAX_VALUE;
		else if(m==0 && n==0)
			return cost[0][0];
		else{
			return cost[m][n]+ Math.min(Math.min(minCostPath(cost, m-1, n-1),minCostPath(cost, m, n-1)), minCostPath(cost, m-1, n));
		}
	}
	public static void main(String[] args) {
		int[][] cost = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		System.out.println(minCostPath(cost, 2, 2));
	}
}
