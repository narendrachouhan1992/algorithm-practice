package LinkedList;

import java.util.Currency;
import java.util.Scanner;

import javax.xml.transform.Templates;

public class LinkedListMain {
	Node head = null;
	
	public void insert(int n, Node curr)
	{
		if(head == null)
		{
			head =  new Node(n);
		}
		else
		{
			if(head.val>n)
			{
				Node temp = new Node(n);
				temp.next = head.next;
				head = temp;
			}
			else if(curr.val<=n && curr.next == null)
			{
				curr.next = new Node(n);
			}
			else if(curr.val <= n && n < curr.next.val )
			{
				Node temp= new Node(n);
				temp.next=curr.next;
				curr.next=temp;
			}
			else
			{
				insert(n, curr.next);			
			}
		}
	}
	public void delete(int n, Node curr)
	{
		if(curr==null)
		{
			System.out.println("element not found");
			return;
		}
		else
		{
			if(curr.val == n)
			{
				Node temp = head;
				head = head.next;
				temp.next = null;
			}
			else
			{
				if(curr.val>n )
				{
					System.out.println("value not found");
				}
				else if(curr.next!=null && curr.next.val ==n)
				{
					Node temp = curr.next;
					curr.next = temp.next;
					temp.next = null;
							
				}
				else
				{
					delete(n, curr.next);
				}
			}
		}
	}
	public void display(Node curr)
	{
		if(curr==null)
		{
			return;
		}
		else
		{
			System.out.println(curr.val);
			display(curr.next);
		}
	}
	
	public static void main(String[] args)
	{
		LinkedListMain ll = new LinkedListMain();
		while(true)
		{
			System.out.println("1 for insert");
			System.out.println("2 for display");
			System.out.println("3 for Delete");
			Scanner sc = new Scanner(System.in);
			int x= sc.nextInt();
			switch (x) {
			case 1:
				System.out.println("enter the value to insert");
				x = sc.nextInt();
				ll.insert(x, ll.head);
				break;
			case 2:
				ll.display(ll.head);
				break;
			case 3:
				System.out.println("enter the value you want to delete");
				x = sc.nextInt();
				ll.delete(x, ll.head);
				break;
			default:
				System.out.println("wrong input, please try again");
				break;
			}
		}
	}
}
