package dynamic;

public class BinomialcoefficientRecursive {
	static int binomialCoeff(int n, int k) {
		// Base Cases
		if (k == 0 || k == n)
			return 1;
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}

	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.println("Value of C("+n+","+ k+") is "+binomialCoeff(n, k));
	}
}
