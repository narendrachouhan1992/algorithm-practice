package greedy;

public class Huffman {
	MinHeap heap = new MinHeap();
	class MinHeapNode
	{
	    char data;  // One of the input characters
	    int freq;  // Frequency of the character
	    MinHeapNode left, right; // Left and right child of this node
	}
	 
	// A Min Heap:  Collection of min heap (or Hufmman tree) nodes
	class MinHeap
	{
	    int size;    // Current size of min heap
	    int capacity;   // capacity of min heap
	    MinHeapNode[] array;  // Attay of minheap node pointers
	}
	 
	// A utility function allocate a new min heap node with given character
	// and frequency of the character
	MinHeapNode newNode(char data, int freq)
	{
	    MinHeapNode temp = new MinHeapNode();
	    temp.left = temp.right = null;
	    temp.data = data;
	    temp.freq = freq;
	    return temp;
	}
	 
	// A utility function to create a min heap of given capacity
	MinHeap createMinHeap(int capacity)
	{
	    MinHeap minHeap = new MinHeap();
	    minHeap.size = 0;  // current size is 0
	    minHeap.capacity = capacity;
	    minHeap.array = new MinHeapNode[capacity];
	    return minHeap;
	}
	public void addToHeaploc(MinHeap tmpH, MinHeapNode node)
	{
		
	}
	public void addToHeap(int x, char y)
	{
		MinHeapNode tempNode = new MinHeapNode();
		tempNode.data = y;
		tempNode.freq = x;
		tempNode.left = null;
		tempNode.right = null;
		addToHeaploc(heap, tempNode);
	}
	public void huffmanCodes(char[] arr, int[] freq, int size)
	{
		for(int i=0;i<size;i++)
		{
			addToHeap(freq[i],arr[i]);
		}
	}
	public static void main(String[] args)
	{
		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
	    int[] freq = {5, 9, 12, 13, 16, 45};
	    Huffman hm = new Huffman();
	    hm.huffmanCodes(arr, freq, arr.length);
	}
	
}
