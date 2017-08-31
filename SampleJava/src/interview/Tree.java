package interview;

import java.util.ArrayList;

public class Tree {
	static class Node
    {
        Integer p;
        Integer q;
        
    }
	static ArrayList<Node> dp = new ArrayList<Node>();
	static Node getNodeVal(int n)
	{
		if(dp.get(n)!=null)
		{
			return dp.get(n);
		}
		if(n==1)
		{
			Node temp1 = new Node();
			temp1.p = 1;
			temp1.q = 1;
			dp.add(1, temp1);
			return temp1;
		}
		else
		{
			if(n%2 == 0)
			{
				Node temp = getNodeVal(n/2);
				Node res = new Node();
				res.p = temp.p+temp.q;
				res.q = temp.q;
				dp.add(n, res);
				return res;
			}
			else
			{
				Node temp = getNodeVal(n/2);
				Node res = new Node();
				res.p = temp.p;
				res.q = temp.q+temp.q;
				dp.add(n, res);
				return res;
			}
		}
		
	}
	static String getValueAt(int n)
	{
		Node temp = getNodeVal(n);
		return (temp.p.toString() +'/'+temp.q.toString());
	}
    static String evaluateTree(String inputLine) 
    {
    	
    	String result = "";
        	String[] data = inputLine.split(" "); 
        	if("N".equals(data[0]))
        	{
        		result =  getValueAt(Integer.parseInt(data[1]));
        	}
        	else if("P".equals(data[0])) 
        	{
        		
        	}
        
        return result;
    }
	public static void main(String[] args) {
		Node node = new Node();
		System.out.println(evaluateTree("N 5"));
	}
}
