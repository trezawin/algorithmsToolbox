import java.util.*;

class EditDistance {
	static int editDist(String str1, String str2, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + min(dp[i][j - 1], // insert
							dp[i - 1][j], // remove
							dp[i - 1][j - 1]); // replace
			}
		}

		return dp[m][n];
	}
    
//	static int editDist(String str1, String str2, int m, int n) {
//		if (m == 0)
//			return n;
//		if (n == 0)
//			return m;
//		if (str1.charAt(m - 1) == str2.charAt(n - 1))
//			return editDist(str1, str2, m - 1, n - 1);
//
//		return 1 + min(editDist(str1, str2, m, n - 1), // Insert
//				editDist(str1, str2, m - 1, n), // Remove
//				editDist(str1, str2, m - 1, n - 1) // Replace
//		);
//	}
	
	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(editDist(s, t, s.length(), t.length()));
		scan.close();
	}

}
