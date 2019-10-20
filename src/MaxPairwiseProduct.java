import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(int[] numbers) {
		// long max1 = numbers[0];
		// long max2 = numbers[1];
		// for (int i = 2; i < numbers.length; i++) {
		// int value = numbers[i];
		// if(value>max1) {
		// max1 = value;
		// }
		// }
		//
		// return max1 * max2;

		Pair max1 = new Pair(0, numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			int value = numbers[i];
			if (value > max1.value) {
				max1 = new Pair(i, value);
			}
		}

		Pair max2 = null;
		for (int i = 0; i < numbers.length; i++) {
			int value = numbers[i];
			if (i == max1.index) {
				continue;
			}

			if (max2 == null || value > max2.value) {
				max2 = new Pair(i, value);
			}
		}
		return max1.value * max2.value;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	static class Pair {
		int index;
		long value;

		public Pair(int i, long v) {
			index = i;
			value = v;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public long getValue() {
			return value;
		}

		public void setValue(long value) {
			this.value = value;
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}