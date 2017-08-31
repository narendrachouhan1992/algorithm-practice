package dynamic;

public class NumberOfSolutionLinerEquationRecursive {
	static int countSol(int coeff[], int start, int end, int rhs)
	{
	    // Base case
	    if (rhs == 0)
	       return 1;
	 
	    int result = 0;  // Initialize count of solutions
	 
	    // One by subtract all smaller or equal coefficiants and recur
	    for (int i=start; i<=end; i++)
	      if (coeff[i] <= rhs)
	        result += countSol(coeff, i, end, rhs-coeff[i]);
	 
	    return result;
	}
	public static void main(String[] args) {
		int[] coeff  = {2, 2, 5, 7};
	    int rhs = 10;
	    int n = coeff.length;
		System.out.println(countSol(coeff, 0, n-1, rhs));
	}
}
