import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
    	Arrays.sort(a, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {				
				String S1 = o1+o2;
				String S2 = o2+o1;
				if (S1.equals(S2)) {
					return 0;
				}
				return S1.compareTo(S2) > 0? -1 : 1;
			}
		});
    	
		
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

