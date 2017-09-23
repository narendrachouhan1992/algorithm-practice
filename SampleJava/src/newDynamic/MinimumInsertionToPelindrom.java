package newDynamic;

public class MinimumInsertionToPelindrom {
	static int getMinimumInsertion(char[] str)
	{
		int size = str.length;
		int dp[][] = new int[size][size];
		for (int gap = 1; gap < size; ++gap)
	        for (int l = 0, h = gap; h < size; ++l, ++h)
	            dp[l][h] = (str[l] == str[h])?
	                           dp[l+1][h-1] :
	                          (Integer.min(dp[l][h-1],
	                                 dp[l+1][h]) + 1);
	return dp[0][size-1];
	}
	public static void main(String[] args) {
		 String str = "geeks";
	     System.out.println(
	     getMinimumInsertion(str.toCharArray()));
	}	
}
