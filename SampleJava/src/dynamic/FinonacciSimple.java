package dynamic;

import java.io.Console;
import java.util.Scanner;

public class FinonacciSimple {
	int fibonacci(int n) {
		if (n <= 1)
			return 1;
		else {
			System.out.println((n - 1) + " " + (n - 2));
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FinonacciSimple f = new FinonacciSimple();
		System.out.println("enter the number ");
		System.out.println("fibonacci number is " + f.fibonacci(sc.nextInt()));
		sc.close();
	}
}
