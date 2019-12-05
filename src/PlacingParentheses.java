import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
    	char[] charArray = exp.toCharArray();
    	int length = charArray.length;
    	List<Character> ops = new ArrayList<>();
    	List<Character> arr = new ArrayList<>();
    	for (int i = 0; i < length; i++) {
    		char c = charArray[i];
    		if(i%2 == 0) {// even number
    			arr.add(c);
    		}else {
    			ops.add(c);
    		}
    	}
    	int n = arr.size();
    	long[][] m = new long[n][n];
    	long[][] M = new long[n][n];
    	
    	for (int i = 0; i < n; i++) {
			m[i][i] = Long.parseLong(arr.get(i).toString());
			M[i][i] = Long.parseLong(arr.get(i).toString());
		}
//    	for (long[] ls : M) {
//    		for (long l : ls) {
//    			System.out.print(l + " ");
//			}
//    		System.out.println();
//		}
//    	System.out.println("=========");
		for (int s = 0; s < n; s++) {
			for (int i = 0; i < n - s; i++) {
				int j = i + s;
		    	long min = m[i][j], max = M[i][j];
		    	for (int k = i; k <= j-1; k++) {
					long a = eval(M[i][k], M[k+1][j], ops.get(k));
					long b = eval(M[i][k], m[k+1][j], ops.get(k));
					long c = eval(m[i][k], M[k+1][j], ops.get(k));
					long d = eval(m[i][k], m[k+1][j], ops.get(k));
					min = min(a, a, b, c, d);
					max = max(a, a, b, c, d);
				}
				m[i][j] = min;
				M[i][j] = max;
			}
		}
    	for (long[] ls : m) {
    		for (long l : ls) {
    			System.out.print(l + " ");
			}
    		System.out.println();
		}
//    	https://towardsdatascience.com/course-1-algorithmic-toolbox-part-4-dynamic-programming-223ffc01984a
    	System.out.println("========");
    	for (long[] ls : M) {
    		for (long l : ls) {
    			System.out.print(l + " ");
			}
    		System.out.println();
		}
      return M[0][n-1];
    }
    
    private static long min(long a, long b, long c, long d, long e) {
    	return Math.min(Math.min(Math.min(Math.min(a, b), c), d), e);
    }
    
    private static long max(long a, long b, long c, long d, long e) {
    	return Math.max(Math.max(Math.max(Math.max(a, b), c), d), e);
    }
    
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

