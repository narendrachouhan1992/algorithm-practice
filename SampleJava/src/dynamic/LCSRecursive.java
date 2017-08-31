package dynamic;

public class LCSRecursive {
	static int lcs(char[] X, char[] Y,int m, int n)
	{
		if(n==0 || m==0)
		{
			return 0;
		}
		else
		{
			if(X[m-1] == Y[n-1])
			{
				return (1+ lcs(X,Y,m-1,n-1));
			}
			else
			{
				return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
			}
		}
	}
	public static void main(String[] args) 
	{
		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		int m = X.length;
		int n = Y.length;
	 
	  System.out.println("Length of LCS is "+ lcs( X, Y, m, n ) ); 
	}
}
