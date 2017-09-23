package newDynamic;

class Node
{
	int val;
	int covered= 0;
	Node left;
	Node right;
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}
}
public class VertexCoverProblem {
	static int getNodeCoveredValue(Node start)
	{
		if(start == null || (start.left == null && start.right==null))
			return 0;
		
		if(start.covered!=0)
			return start.covered;
		
		
		
		int inc = 1 + getNodeCoveredValue(start.left)+ getNodeCoveredValue(start.right);
		int exc=0;
		if(start.left!=null)
		{
			exc+= 1+ getNodeCoveredValue(start.left.left) + getNodeCoveredValue(start.left.right);
		}
		if(start.right!=null)
		{
			exc+= 1+ getNodeCoveredValue(start.right.left) + getNodeCoveredValue(start.right.right);
		}
		start.covered =  (inc>exc)?exc:inc;
		return start.covered;
	}
	public static void main(String[] args) {
		Node root = new Node();
		root.left                = new Node(8);
	    root.left.left          = new Node(4);
	    root.left.right         = new Node(12);
	    root.left.right.left   = new Node(10);
	    root.left.right.right  = new Node(14);
	    root.right               = new Node(22);
	    root.right.right        = new Node(25);
	    System.out.println(getNodeCoveredValue(root));
	}
}
