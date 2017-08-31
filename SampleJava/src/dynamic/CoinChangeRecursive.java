package dynamic;

public class CoinChangeRecursive {
	static int coinChange(int[] arr, int m,int n)
	{
		// If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 // If there are no coins and n is greater than 0, then no solution exist 
	    if (m <=0 && n >= 1)
	        return 0;
	    
//	     count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return coinChange( arr, m - 1, n ) + coinChange( arr, m, n-arr[m-1] );
	}
	public static void main(String args[])
    {
        int arr[] = {1, 2, 5, 10};
        int m = arr.length;
        int n = 100;
        System.out.println(coinChange(arr, m, n));
    }
}
