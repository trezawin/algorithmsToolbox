import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
		// write your code here
		List<ValuePerUnit> valuePerUnits = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			// find value per each unit
			ValuePerUnit valuePerUnit = new ValuePerUnit(i, ((double) values[i] / weights[i]));
			valuePerUnits.add(valuePerUnit);
		}
		Collections.sort(valuePerUnits, new Comparator<ValuePerUnit>() {

			@Override
			public int compare(ValuePerUnit o1, ValuePerUnit o2) {
				return o2.getValuePerUnit().compareTo(o1.getValuePerUnit());
			}
		});

		for (int j = 0; j < weights.length; j++) {
			int index = valuePerUnits.get(j).getIndex();
			while (weights[index] > 0) {
				if (capacity == 0) {
					return value;
				}
				int a = Math.min(capacity, weights[index]);
				value += a * (valuePerUnits.get(j).getValuePerUnit());
				capacity -= a;
				weights[index] -= a;
			}
		}
		
		return value;
	}

	static class ValuePerUnit {
		int index;
		Double valuePerUnit;

		public ValuePerUnit(int index, double valuePerUnit) {
			super();
			this.index = index;
			this.valuePerUnit = valuePerUnit;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public Double getValuePerUnit() {
			return valuePerUnit;
		}

		public void setValuePerUnit(double valuePerUnit) {
			this.valuePerUnit = valuePerUnit;
		}

	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		DecimalFormat df = new DecimalFormat("#.####");
		System.out.println(df.format(getOptimalValue(capacity, values, weights)));
	}
}
