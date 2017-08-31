package dynamic;

public class LongestPalendromicSubsequenceRecursive {
	static int lpss(String str, int m,int n)
	{
		if(m==n)
		{
			return 1;
		}
		else if(str.charAt(m)==str.charAt(n) && m+1==n)
			return 2;
		else if(str.charAt(m)==str.charAt(n))
		{
			return (2+lpss(str, m+1, n-1));
		}
		else
		{
			return Math.max(lpss(str, m+1, n), lpss(str, m, n-1));
		}
	}
	public static void main(String args[])
    {
        String seq = "GEEKSFORGEEKS";
        System.out.println("The lnegth of the lps is "+ lpss(seq,0,seq.length()-1));
    }
}
