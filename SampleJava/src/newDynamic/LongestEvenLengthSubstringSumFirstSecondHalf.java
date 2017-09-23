package newDynamic;

public class LongestEvenLengthSubstringSumFirstSecondHalf {
	static int getLength(String str)
	{
		char[] strAr = str.toCharArray();
		int size = str.length();
		int maxLen=0;
		
		if(size <=1)
		{
			return 0;
		}
		int[][] sum = new int[size][size];
		for (int i =0; i<size; i++)
	        sum[i][i] = strAr[i]-'0';
		
		for(int len=2;len<size;len++)
		{
			for(int i=0;i<size-len+1;i++)
			{
				int j = i+len-1;
				int k = len/2;
				sum[i][j] = sum[i][j-k]+ sum[j-k+1][j];
				if((len%2==0) && sum[i][j-k]==sum[j-k+1][j] && maxLen<len)
				{
					maxLen = len;
				}
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		String str = "153803";
		System.out.println(getLength(str));
	}
}
