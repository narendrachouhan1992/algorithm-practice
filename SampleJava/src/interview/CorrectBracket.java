package interview;

public class CorrectBracket {
	static boolean isCorrect(String str)
	{
		
		int size = str.length();
		int[] arr = new int[size];
		int pos=-1;
		for(int i=0;i<size;i++)
		{
			if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[')
			{
				arr[++pos] = str.charAt(i);
			}
			else
			{
				if(pos==-1)
				{
					return false;
				}
				else if(arr[pos]== '[' && str.charAt(i) == ']')
				{
					pos--;
				}
				else if(arr[pos]== '{' && str.charAt(i) == '}')
				{
					pos--;
				}
				else if(arr[pos]== '(' && str.charAt(i) == ')')
				{
					pos--;
				}
				else
				{
					return false;
				}
			}
		}
		if(pos == -1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String str = "[{()()[]}]";
		String str1 = "[][][{]}";
		if(isCorrect(str))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}
		if(isCorrect(str1))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}
	}
}
