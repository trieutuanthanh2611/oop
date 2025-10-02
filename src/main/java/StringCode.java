import java.util.HashSet;
import java.util.Set;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A run is a series of adjacent chars that are the same.
	 */
	public static int maxRun(String str) {
		if (str == null || str.length() == 0) return 0;

		int max = 1;
		int current = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				current++;
				if (current > max) {
					max = current;
				}
			} else {
				current = 1;
			}
		}
		return max;
	}

	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following.
	 * Example: "a3tx2z" -> "attttxzzz".
	 */
	public static String blowup(String str) {
		if (str == null || str.length() == 0) return "";

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isDigit(ch)) {
				int num = ch - '0';
				// Nếu có ký tự phía sau thì nhân lên
				if (i + 1 < str.length()) {
					char next = str.charAt(i + 1);
					for (int j = 0; j < num; j++) {
						result.append(next);
					}
				}
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (a == null || b == null || len <= 0) return false;
		if (a.length() < len || b.length() < len) return false;

		Set<String> set = new HashSet<>();

		for (int i = 0; i <= a.length() - len; i++) {
			set.add(a.substring(i, i + len));
		}

		for (int i = 0; i <= b.length() - len; i++) {
			if (set.contains(b.substring(i, i + len))) {
				return true;
			}
		}
		return false;
	}
}
