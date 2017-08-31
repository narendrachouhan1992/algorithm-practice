package dynamic;

public class CarAssemblyProblem {
	static int carAssembly(int[][] a, int[][] t, int[] e, int[] x)
	{ 
		int length = a[1].length;
		int[] T1 = new int[length];
		int[] T2 = new int[length];
		T1[0]= e[0]+ a[0][0];
		T2[0]= e[1]+ a[1][0];
		for(int i=1;i< length;i++)
		{
			T1[i]= Integer.min((T1[i-1]+ a[0][i]), (T2[i-1] + t[1][i]+ a[0][i]));
			T2[i]= Integer.min((T2[i-1]+ a[1][i]), (T1[i-1] + t[0][i]+ a[1][i]));
		}
		
		return Integer.min((T1[length-1]+ x[0]), (T2[length-1]+x[1]));
	}
	public static void main(String[] args) {
		   int[][] a = {{4, 5, 3, 2},
	                {2, 10, 1, 4}};
	    int[][] t = {{0, 7, 4, 5},
	                {0, 9, 2, 8}};
	    int[] e = {10, 12};
	    int x[] = {18, 7};
	 
	    System.out.println(carAssembly(a, t, e, x));
	}
}
