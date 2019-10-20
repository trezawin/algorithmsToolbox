import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    List<Integer> fibs = new ArrayList<>();
    fibs.add(0);
    fibs.add(1);
    for (int i = 2; i <= n; i++) {
    	fibs.add(fibs.get(i-1) + fibs.get(i-2));
	}
    
    return fibs.get(fibs.size()-1);
//    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
