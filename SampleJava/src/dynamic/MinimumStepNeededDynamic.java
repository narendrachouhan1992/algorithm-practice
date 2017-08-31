package dynamic;

public class MinimumStepNeededDynamic {
	public static int getMinStep(int[] arr)
	{
		int n= arr.length;
		int[] jump = new int[n];
		jump[n-1] = 0;
		
		
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]==0)
				jump[i] = Integer.MAX_VALUE;
		    
	        else if (arr[i] >= n - i - 1)
	            jump[i] = 1;
	        else
	        {
	        	 int min = Integer.MAX_VALUE;
	        	 
	             // following loop checks with all reachable points and
	             // takes the minimum
	             for (int j = i+1; j < n && j <= arr[i] + i; j++)
	             {
	                 if (min > jump[j])
	                     min = jump[j];
	             }      
	  
	             // Handle overflow 
	             if (min != Integer.MAX_VALUE)
	               jump[i] = min + 1;
	             else
	               jump[i] = min; // or INT_MAX
	        }
		}
		return jump[0];
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println("Minimum number of jumps to reach end is "+getMinStep(arr));
	}
}
