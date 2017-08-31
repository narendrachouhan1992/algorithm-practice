package dynamic;

public class LongestPAlendromicSubStringDynamic {
	
	static void lpss(String str)
	{
		int size = str.length();
		boolean[][] dp = new boolean[size][size];
		int maxLength= 1;
		int start=0;
		for(int i=0;i<size-1;i++)
		{
			dp[i][i] = true;
			if(str.charAt(i)==str.charAt(i+1))
			{
				dp[i][i+1]= true;
				maxLength = 2;
				start = i;
			}
		}
		dp[size-1][size-1]= true;
//		for (int i =1;i<size;i++)
//		{
//			for(int j = i+2;j<size;j++)
//			{
//				if(dp[i+1][j-1] && str.charAt(i)== str.charAt(j))
//				{
//					dp[i][j]= true;
//					if(j-i>maxLength)
//					{
//						maxLength = j-i;
//						start = i;
//					}
//				}
//				else
//				{
//					dp[i][j] = false;
//				}
//			}
//		}
		for (int k = 3; k <= size; ++k)
	    {
	        // Fix the starting index
	        for (int i = 0; i < size-k+1 ; ++i)
	        {
	            // Get the ending index of substring from
	            // starting index i and length k
	            int j = i + k - 1;
	 
	            // checking for sub-string from ith index to
	            // jth index iff str[i+1] to str[j-1] is a
	            // palindrome
	            if(dp[i+1][j-1] && str.charAt(i) == str.charAt(j))
	            {
	                dp[i][j] = true;
	 
	                if (k > maxLength)
	                {
	                    start = i;
	                    maxLength = k;
	                }
	            }
	        }
	    }
			
		System.out.println(str.substring(start, start+maxLength));
	}
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		lpss(str);
		
	}
}
