package newDynamic;

public class PowerArea {
	static int a1 = 3;
	static int b1 = 2;
	static int a2 = -5;
	static int b2 = -10;
	static int a3 = -20;
	static int b3 = 5;
	static int[][][] memory;
	
	public static int getMax(int A, int B, int Current)
	{
		if(A<=0 || B<=0)
			return 0;
		if(memory[A][B][Current]!=-1)
		{
			return memory[A][B][Current];
		}
		int temp;
		if(Current==1)
			temp = Integer.max(getMax(A+a2, B+b2, 2), getMax(A+a3, B+b3, 3));
		else if(Current ==2)
			temp = Integer.max(getMax(A+a1, B+b1, 1), getMax(A+a3, B+b3, 3));
		else
			temp = Integer.max(getMax(A+a1, B+b1, 1), getMax(A+a2, B+b2, 2));
		memory[A][B][Current] = temp+1;
		return memory[A][B][Current];
	}
	public static void printMaxStep(int A, int B) {
		for(int i=1;i<=3*A;i++)
			for(int j=1;j<=3*B;j++)
				for(int k = 1;k<=3;k++)
					memory[i][j][k] = -1;
		int temp = Integer.max(Integer.max(getMax(A+a1, B+b1, 1), getMax(A+a2, B+b2, 2)), getMax(A+a3, B+b3, 3));
		System.out.println(temp);
	}

	public static void main(String[] args) {
		int A = 20;
		int B = 8;
		memory = new int[3*A + 1][3*B + 1][4];
		printMaxStep(A, B);
	}
}
