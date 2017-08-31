package sampleTree;

class Node {

	int value;
	Node left, right;

	public Node(int item) {
		value = item;
		left = right = null;
	}
}

class MaxSumOfSeries {
	int max_till_now = Integer.MIN_VALUE;
	Node root;

	int findMaxSumOfSeriesFor(Node node) {

		if (node == null)
			return 0;

		int lmax = findMaxSumOfSeriesFor(node.left);
		int emax = findMaxSumOfSeriesFor(node.right);

		int maxPassingToTop = Math.max(Math.max(lmax, emax) + node.value, node.value);

		int maxSoFar = Math.max(maxPassingToTop, lmax + emax + node.value);

		max_till_now = Math.max(max_till_now, maxSoFar);

		return maxPassingToTop;
	}

	int findMaxSumOfSeries(Node node) {

		findMaxSumOfSeriesFor(node);
		return max_till_now;
	}

	public static void main(String args[]) {
		MaxSumOfSeries tree = new MaxSumOfSeries();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(50);
		tree.root.left.right = new Node(90);
		tree.root.right.left = new Node(-20);
		tree.root.right.right = new Node(-30);
		
		System.out.println("maximum path sum is : " + tree.findMaxSumOfSeries(tree.root));
	}
}