package dynamic;

public class SolToLineraEqOfNVeriableRec {
    static int countSol(int[] coeff, int start, int end, int rhs)
    {
    	if(rhs==0)
    		return 1;
    	int sol = 0;
    	
    	for(int i= start; i<=end;i++)
    	{
    		if(coeff[i]<= rhs)
    		{
    			sol+=countSol(coeff, i, end, rhs-coeff[i]);
    		}
    	}
    	return sol;
    }
	public static void main(String[] args) {
		int coeff[]  = {2, 2, 5};
	    int rhs = 4;
	    System.out.println(countSol(coeff, 0, coeff.length-1, rhs));
	}
}
