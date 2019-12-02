import java.util.*;
import java.io.*;

public class CarFueling {
//	static int computeMinRefills(int dist, int tank, int[] stops) {
//		if (dist <= tank) {
//			return 0;
//		}
//		int numRefills = 0, currentRefill = 0;
//		int lastRefill = -1;
//		while (currentRefill < stops.length) {
//			lastRefill = currentRefill == 0 ? lastRefill : currentRefill;
//			while (currentRefill + 1 < stops.length
//					&& stops[currentRefill + 1] - (lastRefill != -1 ? stops[lastRefill] : 0) <= tank) {
//				currentRefill++;
//			}
//			if (currentRefill == lastRefill) {
//				return -1;
//			}
//			if (currentRefill < stops.length) {
//				numRefills++;
//				if (currentRefill == stops.length - 1) {// if current is at last stop.
//					if (currentRefill != lastRefill && stops[currentRefill] + tank >= dist) {
//						break;
//					}
//				}
//			}
//
//		}
//		return numRefills;
//	}
	
	static int computeMinRefills(int N, int K, int compulsory[]) {
		int count = 0;
		int i = 0;
		int distCovered = 0;
		int M = compulsory.length;

		// While we complete
		// the whole journey.
		while (distCovered < N) {
			// If must visited petrol pump lie
			// between distCovered and distCovered+K.
			if (i < M && compulsory[i] <= (distCovered + K)) {
				// make last mustVisited
				// as distCovered
				distCovered = compulsory[i];

				// increment the index
				// of compulsory visited.
				i++;
			}

			// if no such must visited
			// pump is there then
			// increment distCovered by K.
			else
				distCovered += K;

			// Counting the number of refill.
			if (distCovered < N)
				count++;
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));
	}
}
