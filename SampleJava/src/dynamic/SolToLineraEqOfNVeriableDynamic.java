package dynamic;

public class SolToLineraEqOfNVeriableDynamic {
	public static int countSol(int[] coeff, int rhs)
	{
		int length = coeff.length;
		int[] dp = new int[rhs+1];
		dp[0] =1;
		
		for(int i=0;i<length;i++)
			for(int j=coeff[i];j<=rhs;j++)
			{
				dp[j]+= dp[j-coeff[i]];
			}
		return dp[rhs];
	}
	public static void main(String[] args) {
		int coeff[]  = {2, 2, 5};
	    int rhs = 4;
	    System.out.println(countSol(coeff, rhs));
	}
}
