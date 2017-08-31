package dynamic;

public class ZeroOneKnapSackRecursive {
	static int knapSack(int W, int[] w,int[] v,int n)
	{
		if(W==0 || n==0)
		{
			return 0;
		}
		else if(w[n-1]>W)
		{
			return knapSack(W, w, v, n-1);
		}
		else
		{
			return Math.max((v[n-1] +knapSack(W-w[n-1], w, v, n-1)), knapSack(W, w, v, n-1));		
		}
	}
	public static void main(String args[])
	{
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
    }
}
