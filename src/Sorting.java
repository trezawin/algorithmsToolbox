import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
	private static Random random = new Random();

	private static int[] partition3(int[] a, int l, int r) {
		// write your code here
		int x = a[l];
		int j = l;
		int cur = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] < x) {
				j++;
				swap(a, i, j);
			}
			if (a[i] == x) {
				j++;
				cur++;
				swap(a, i, cur);
			}
		}
		if (cur > l) {

//			Collections.sw
			List<Integer> newList = new ArrayList<>();
			List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
			newList.add(aList.get(j));
			int endCur = cur + 1> a.length? a.length : cur+1;
			newList.addAll(aList.subList(endCur, j));
			newList.addAll(aList.subList(l, endCur));
			newList.addAll(aList.subList(j + l + 1 == a.length ? a.length : j + l + 1, a.length));
			
			
//			List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
//			swapSubList(aList, 0, cur+1, j, j+1);
			for (int i = 0; i < newList.size(); i++) {
				a[i] = newList.get(i);
			}
			System.out.println("");

		} else {
			swap(a, l, j);
		}
		int m1 = j - cur;
		int m2 = j;
		int[] m = { m1, m2 };
		return m;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				swap(a, i, j);
			}
		}
		swap(a, l, j);
		return j;
	}

	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		swap(a, l, k);
		// use partition3
		System.out.println("k =>" + k);

		// int m = partition2(a, l, r);

		int[] m = partition3(a, l, r);

		// System.out.println("m =>" + m);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }

		randomizedQuickSort(a, l, m[0] - 1);
		randomizedQuickSort(a, m[1] + 1, r);

		// randomizedQuickSort(a, l, m - 1);
		// randomizedQuickSort(a, m + 1, r);
	}
	
	private static void quicksort(int[] numbers, int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(numbers, low, j);
        if (i < high)
            quicksort(numbers, i, high);
    }

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
//		randomizedQuickSort(a, 0, n - 1);
		quicksort(a, 0, n-1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
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
