import java.util.*;

public class Taboo<T> {
	private Map<T, Set<T>> map;

	/**
	 * Constructs a new Taboo using the given rules.
	 */
	public Taboo(List<T> rules) {
		map = new HashMap<>();
		for (int i = 0; i < rules.size() - 1; i++) {
			T first = rules.get(i);
			T second = rules.get(i + 1);
			if (first == null || second == null) continue;

			if (!map.containsKey(first)) {
				map.put(first, new HashSet<>());
			}
			map.get(first).add(second);
		}
	}

	/**
	 * Returns the set of elements which should not follow elem.
	 */
	public Set<T> noFollow(T elem) {
		return map.getOrDefault(elem, Collections.emptySet());
	}

	/**
	 * Removes elements from the list that violate the rules.
	 */
	public void reduce(List<T> list) {
		if (list == null || list.size() < 2) return;

		int i = 0;
		while (i < list.size() - 1) {
			T current = list.get(i);
			T next = list.get(i + 1);
			if (noFollow(current).contains(next)) {
				list.remove(i + 1);
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		List<String> rules = Arrays.asList("a", "c", "a", "b");
		Taboo<String> t = new Taboo<>(rules);

		System.out.println(t.noFollow("a"));
		System.out.println(t.noFollow("c"));
		System.out.println(t.noFollow("b"));

		List<String> test = new ArrayList<>(Arrays.asList("a", "c", "a", "b", "x"));
		t.reduce(test);
		System.out.println(test);
	}
}
