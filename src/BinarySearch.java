import java.io.*;
import java.util.*;

public class BinarySearch {

	static int binarySearch(int[] a, int x) {
		int left = 0;
		int right = a.length - 1;
		return BS_recursion(a, left, right, x);
		// return BS_iterative(a, x);
	}

	static int BS_iterative(int[] a, int key) {
		int left = 0;
		int right = a.length - 1;

		while (left <= right) {
			int mid = left + right >>> 1;
			int midValue = a[mid];

			if (midValue < key) {
				left = mid + 1;
			} else if (midValue > key) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	static int BS_recursion(int[] a, int startIndex, int endIndex, int key) {
		if (endIndex < startIndex) {
			return -1;
		}
		int midIndex = startIndex + (endIndex - startIndex) / 2;
		if (key == a[midIndex]) {
			return midIndex;
		}

		if (a[midIndex] < key) {
			return BS_recursion(a, midIndex + 1, endIndex, key);
		}
		return BS_recursion(a, startIndex, midIndex - 1, key);
	}

	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}
		for (int i = 0; i < m; i++) {
			// replace with the call to binarySearch when implemented
			System.out.print(binarySearch(a, b[i]) + " ");
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
