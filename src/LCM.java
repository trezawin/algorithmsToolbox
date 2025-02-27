import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  
  private static long lcm_efficient(int a, int b) {
	  return ((long)a*b)/euclideanAlgorithm(a,b);  
  }
  
  private static int euclideanAlgorithm(int a, int b) {
	  if (b==0) {
		  return a;
	  }
	  
	  int c = a%b;
	  
	  return euclideanAlgorithm(b, c);  
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_efficient(a, b));
  }
}
