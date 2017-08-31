package amazone;

public class Replace0With5 {
	public int replace(int num)
	{
		if(num==0)
		{
			return 0;
		}
		else
		{
			int digit = num%10;
			if(digit ==0)
			{
				digit = 5;
			}
				return (replace(num/10)*10 + digit);
		}
	}
	public static void main(String[] args) {
		int num = 100501;
		Replace0With5 obj = new Replace0With5();
		System.out.println(obj.replace(num));
	}
}
