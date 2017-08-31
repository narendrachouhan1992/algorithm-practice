package dynamic;

//If n is even then k = n/2:
//F(n) = [2*F(k-1) + F(k)]*F(k)
//
//If n is odd then k = (n + 1)/2
//F(n) = F(k)*F(k) + F(k-1)*F(k-1)

public class FibonacciFormula {
	static int getFibonacci(int n)
	{
		if(n%2 == 0)
		{
			int k = n/2;
			return (2*getFibonacci(k -1) + getFibonacci(k))*getFibonacci(k);
		}
		else
		{
			int k= (n+1)/2;
			return getFibonacci(k)*getFibonacci(k) + getFibonacci(k-1)*getFibonacci(k-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(getFibonacci(10));
	}
}
