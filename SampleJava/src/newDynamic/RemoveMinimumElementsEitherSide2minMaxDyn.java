package newDynamic;

public class RemoveMinimumElementsEitherSide2minMaxDyn {
	static int min(int arr[], int l, int h)
	{
	    int mn = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mn > arr[i])
	         mn = arr[i];
	    return mn;
	}
	 
	// A utility function to find maximum in arr[l..h]
	static int max(int arr[], int l, int h)
	{
	    int mx = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mx < arr[i])
	         mx = arr[i];
	    return mx;
	}
	static int getNumberOfChanges(int[] arr)
	{
		if(arr == null || arr.length<2)
		{
			return 0;
		}
		int size = arr.length;
		int[][] table = new int[size][size];
		int gap, i, j, mn, mx;
		 
	    // Fill table using above recursive formula. Note that the table
	    // is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
	    // from diagonal elements to table[0][n-1] which is the result.
	    for (gap = 0; gap < size; ++gap)
	    {
	        for (i = 0, j = gap; j < size; ++i, ++j)
	        {
	            mn = min(arr, i, j);
	            mx = max(arr, i, j);
	            table[i][j] = (2*mn > mx)? 0: Integer.min(table[i][j-1]+1,
	                                              table[i+1][j]+1);
	        }
	    }
	    return table[0][size-1];
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println(getNumberOfChanges(arr
				));
	}
}
