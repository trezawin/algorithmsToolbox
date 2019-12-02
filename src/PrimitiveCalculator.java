import java.util.*;

public class PrimitiveCalculator {
	private static List<Integer> optimal_sequence(int n) {	
		
/*		if (m%3 == 0) {
			c.get(i).addAll(m, c.get(m/3));
		} else if(m-1%3 == 0) {
			c.get(i).addAll(m, m-1, c.get(m-1/3));
			continue;
		}
		if(m%2 == 0) {
			c.get(i).addAll(m, c.get(m/2));
		}else if(m-1%2 == 0) {
			secondArr= [m, m-1, c.get(m-1/2)];
			if(c.get(i).size() < secondArr.size())
			c.get(i).addAll(secondArr);
		}*/
		
		List<List<Integer>> c = new ArrayList<>();
		if (n <= 1) {
			c.add(Arrays.asList(1));
			return c.get(0);
		}
		c.add(0, Arrays.asList(1));
		c.add(1, Arrays.asList(1));
		for (int i = 2; i <= n; i++) {
			c.add(i, new ArrayList<>());
			List<Integer> cur = c.get(i);
			cur.add(i);
			
			cal(c, i, cur, false);
			if (i % 3 != 0 || i % 2 != 0) {
				int minusOne = i - 1;
				cal(c, minusOne, cur, true);
			}
		}
	
		List<Integer> finalN = c.get(c.size()-1);
		Collections.reverse(finalN);
		return finalN;
//
//		List<List<Integer>> c = new ArrayList<>();
//		if (n <= 1) {
//			c.add(Arrays.asList(1));
//			return c.get(0);
//		}
//		c.add(0, Arrays.asList(1));
//		c.add(1, Arrays.asList(1));
//		for (int i = 2; i <= n; i++) {
//			c.add(i, new ArrayList<>());
//			List<Integer> cur = c.get(i);
//			cur.add(i);
//
//			int minusOne = i - 1;
//			if (i % 3 == 0) {
//				cur.addAll(c.get(i / 3));
//				if(i*3 == 0) {
//					cur.add(0, n); break;
//				}
//			} else if (minusOne % 3 == 0) {
//				cur.add(minusOne);
//				cur.addAll(c.get(minusOne / 3));
//					if(minusOne*3 == n) {
//						cur.add(0,n); break;
//					}
//			}
//			List<Integer> s = new ArrayList<>();
//			if (i % 2 == 0) {
//				s.add(i);
//				s.addAll(c.get(i / 2));
//				if (s.size() < cur.size() || cur.size() == 1) {
//					cur.clear();
//					cur.addAll(s);
//					if(i*2 == 0) {
//						cur.add(0, n); break;
//					}
//				}
//			} else if (minusOne % 2 == 0) {
//				s.add(i);
//				s.add(minusOne);
//				s.addAll(c.get(minusOne / 2));
//				if (s.size() < cur.size() || cur.size() == 1) {
//					cur.clear();
//					cur.addAll(s);
//					if(minusOne*2 == n) {
//						cur.add(0,n); break;
//					}
//				}
//			}
//		}
//		
//		
//		List<Integer> finalN = c.get(c.size()-1);
//		Collections.reverse(finalN);
//		return finalN;
	
	
//		List<Integer> sequence = new ArrayList<Integer>();
//		while (n >= 1) {
//			sequence.add(n);
//			if (n % 3 == 0) {
//				n /= 3;
//			} else if ((n - 1) % 3 == 0) {
//				n -= 1;
//				if (n != 0) {
//					sequence.add(n);
//				}
//				n /= 3;
//			} else if (n % 2 == 0) {
//				n /= 2;
//			} else if ((n - 1) % 2 == 0) {
//				n -= 1;
//				if (n != 0) {
//					sequence.add(n);
//				}
//				n /= 2;
//			}
//		}
		
//		List<Integer> sequence = new ArrayList<Integer>();
//		while (n >= 1) {
//			sequence.add(n);
//			if (n % 3 == 0) {
//				n /= 3;
//			} else if (n % 2 == 0) {
//				n /= 2;
//			} else {
//				n -= 1;
//			}
//		}
//		Collections.reverse(sequence);
//		return sequence;
	}
	
	private static void cal(List<List<Integer>> c, int i, List<Integer> cur, boolean fromNonDivisible) {
		List<Integer> s = new ArrayList<>();
		int[] divider = new int[]{3, 2};
		for (int d : divider) {
			if(i%d == 0) {
				if (fromNonDivisible) {
					s.add(i+1);
				}
				s.add(i);
				s.addAll(c.get(i / d));
				if (s.size() < cur.size() || cur.size() == 1) {
					cur.clear();
					cur.addAll(s);
					s.clear();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
		scanner.close();
	}
}
