package test;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		Map<String, ArrayList<Double>> data = new HashMap<String, ArrayList<Double>>();
		@Override
		public void putNewPrice(String symbol, double price) {
			ArrayList<Double> values = data.get(symbol);
			if(values!=null && !values.isEmpty())
			{
				values.add(price);
				data.put(symbol, values);
			}
			else
			{
				values = new ArrayList<Double>();
				values.add(price);
				data.put(symbol, values);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			ArrayList<Double> values = data.get(symbol);
			if(values!=null && !values.isEmpty())
			{
				double sum=0;
				double count =0;
				for (Double double1 : values) {
					sum+=double1;
					count++;
				}
				return (sum/count);
			}
			else
			{
				return 0;
			}
		// YOUR CODE HERE
		}

		@Override
		public int getTickCount(String symbol) {
			ArrayList<Double> values = data.get(symbol);
			if(values!=null && !values.isEmpty())
			{
				return values.size();
			}
			else
			{
				return 0;
			}
		// YOUR CODE HERE
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}