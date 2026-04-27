import java.util.*;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int fib(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return fibReal(n, map);
	}
	
	public static int fibReal(int n, HashMap<Integer, Integer> map) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		int a;
		int b;
		if (map.containsKey(n-1)) {
			a = map.get(n-1);
		} 
		else {
			a = fibReal(n-1, map);
			map.put(n-1, a);
		}
		if (map.containsKey(n-2)) {
			b = map.get(n-2);
		} 
		else {
			b = fibReal(n-2, map);
			map.put(n-2, b);
		}
		return a+b;
	}

	public static int minCostClimbingStairs(int[] steps) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (steps.length == 0) {
			return 0;
		}
		if (steps.length == 1) {
			return steps[0];
		}
		return realStairCost(steps, map, steps.length);
	}
	public static int realStairCost(int[] steps, HashMap<Integer, Integer> map, int index) {
		if (index == 0 || index == 1) {
			return 0;
		}
		int a;
		int b;
		if (map.containsKey(index-1)) {
			a = map.get(index-1);
		} 
		else {
			a = realStairCost(steps, map, index-1);
			map.put(index-1, a);
		}
		if (map.containsKey(index-2)) {
			b = map.get(index-2);
		}
		else {
			b = realStairCost(steps, map, index-2);
			map.put(index-2, b);
		}
		return Math.min(a + steps[index-1], b + steps[index-2]);
	}
}
