import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChangeDP {
	private static int getChange(int m) {
		// write your code here
		List<Integer> coins = Arrays.asList(1, 3, 4);
		List<Integer> minNumCombinations = new ArrayList<>();

		for (int i = 0; i <= m; i++) {
			minNumCombinations.add(i, 0);
			for (Integer coin : coins) {
				if (i < coin)
					continue;
				int num = minNumCombinations.get(i - coin) + 1;
				if (num < minNumCombinations.get(i) || minNumCombinations.get(i) == 0) {
					minNumCombinations.add(i, num);
				}
			}
		}

		return minNumCombinations.get(m);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}
