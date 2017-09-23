package newDynamic;

public class MaximumProfitByBuyingAndSellingShareAtMostTwice {
	static int getMaxProfit(int[] price)
	{
		int[] profit;
		int size = price.length;
		profit = new int[size];
		for (int i = 0; i < profit.length; i++) {
			profit[i] = 0;
		}
		int max_price= price[size-1];
		for(int i =size-2;i>=0;i--)
		{
			if(price[i]>max_price)
			{
				max_price=price[i];
			}
			profit[i] = Integer.max(profit[i+1], max_price-price[i]);
		}
		int min_price= price[0];
		for(int i =1;i<size;i++)
		{
			if(price[i]<min_price)
			{
				min_price=price[i];
			}
			profit[i] = Integer.max(profit[i-1], profit[i]+ price[i]-min_price);
		}
		return profit[size-1];
	}
	public static void main(String[] args) {
		int[] price = {2, 30, 15, 10, 8, 25, 80};
		System.out.println(getMaxProfit(price));
	}
}

