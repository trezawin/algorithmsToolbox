import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
    	List<Integer> requiredCoins = new ArrayList<>();
    	while(m >= 10) {
    		requiredCoins.add(10);
    		m = m-10;
    	}
    	
    	while(m>=5) {
    		requiredCoins.add(5);
    		m = m-5;
    	}
    	
    	while(m>=1) {
    		requiredCoins.add(1);
    		m = m-1;
    	}
    	    	
        return requiredCoins.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

