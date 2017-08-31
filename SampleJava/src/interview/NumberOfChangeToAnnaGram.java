package interview;

import java.util.HashMap;
import java.util.Map;

public class NumberOfChangeToAnnaGram {
	static int[] getNumberOfChangesRequired(String[] data1, String[] data2)
	{
		int size = data1.length;
		 int[] sol = new int[size];
		for(int i =0; i<size;i++)
		{
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			int count=0;
			if(data1[i].length() != data2[i].length())
			{
				sol[i]= -1;
			}
			else
			{
				for(int j=0;j<data1[i].length();j++)
				{
					if(map.containsKey(data1[i].charAt(j)))
					{
						map.put(data1[i].charAt(j), map.get(data1[i].charAt(j))+1);
						count++;
					}
					else
					{
						map.put(data1[i].charAt(j), 1);
						count++;
					}
				}
				for(int j=0;j<data1[i].length();j++)
				{
					if(map.containsKey(data2[i].charAt(j)) && map.get(data2[i].charAt(j))!=1)
					{
						map.put(data2[i].charAt(j), map.get(data2[i].charAt(j))-1);
						count--;
					}
					else if(map.containsKey(data2[i].charAt(j)) && map.get(data2[i].charAt(j))==1)
					{
						map.remove(data2[i].charAt(j));
						count--;
					}
					else
					{
						
					}
				}
			}
			sol[i] = count;
		}
		return sol;
	}
	public static void main(String[] args) {
		String[] data1 = {"qwe","asd", "asdfff", "abcd"};
		String[] data2 = {"ewq","dsa", "asffff", "cd"};
		int[] sol =getNumberOfChangesRequired(data1, data2);
		for (int i : sol) {
			System.out.println(i);
		}
	}
}
