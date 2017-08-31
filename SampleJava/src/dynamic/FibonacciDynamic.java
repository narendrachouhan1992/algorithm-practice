package dynamic;

import java.util.Scanner;

public class FibonacciDynamic {
	int fibonacci(int n)
	{
		int[] sol = new int[n+1];
		sol[0]= 1;
		sol[1]= 1;
		for(int i=2;i<=n;i++)
		{
			sol[i]= sol[i-1]+sol[i-2];
		}
		return sol[n];
	}
	public static void main(String[] args) {
		FibonacciDynamic fd = new FibonacciDynamic();
		System.out.println("enter the number");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("fibonacci of "+n+" is "+ fd.fibonacci(n));
		sc.close();
	}
}
