package amazone;

class Node1 {

	int data;
	Node1 left, right;

	public Node1(int item) {
		data = item;
		left = right = null;
	}
}

// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
	public int val;
}

class FinalQuestion {

	Node1 root;
	static int max_till_now = Integer.MIN_VALUE;
	int findMax(Node1 node) 
	{

		if (node == null)
			return 0;

		int lmax = findMax(node.left);
		int rmax = findMax(node.right);

		int max_single = Math.max(Math.max(lmax, rmax) + node.data, node.data);

		int max_top = Math.max(max_single, lmax + rmax + node.data);

		max_till_now = Math.max(max_till_now, max_top);

		return max_single;
	}


	/* Driver program to test above functions */
	public static void main(String args[]) {
		FinalQuestion tree = new FinalQuestion();
		tree.root = new Node1(10);
		tree.root.left = new Node1(2);
		tree.root.right = new Node1(10);
		tree.root.left.left = new Node1(20);
		tree.root.left.right = new Node1(1);
		tree.root.right.right = new Node1(25);
		tree.root.right.right.left = new Node1(3);
		tree.root.right.right.right = new Node1(4);
		tree.findMax(tree.root);
		System.out.println("maximum path sum is : " + FinalQuestion.max_till_now);
	}
}