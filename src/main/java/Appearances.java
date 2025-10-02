import java.util.*;

public class Appearances {

	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections.
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> freqA = new HashMap<>();
		Map<T, Integer> freqB = new HashMap<>();

		for (T x : a) {
			freqA.put(x, freqA.getOrDefault(x, 0) + 1);
		}

		for (T x : b) {
			freqB.put(x, freqB.getOrDefault(x, 0) + 1);
		}

		int count = 0;
		Set<T> allKeys = new HashSet<>();
		allKeys.addAll(freqA.keySet());
		allKeys.addAll(freqB.keySet());

		for (T key : allKeys) {
			int fa = freqA.getOrDefault(key, 0);
			int fb = freqB.getOrDefault(key, 0);
			if (fa > 0 && fa == fb) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("a", "b", "b", "c", "c", "c");
		List<String> list2 = Arrays.asList("b", "b", "d", "c", "c", "c");

		System.out.println(sameCount(list1, list2)); // 2 (b=2, c=3)
	}
}
