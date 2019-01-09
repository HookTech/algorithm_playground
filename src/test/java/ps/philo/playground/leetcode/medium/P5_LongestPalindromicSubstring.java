package ps.philo.playground.leetcode.medium;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * philo
 * # 1/5/19
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class P5_LongestPalindromicSubstring {
	@Test
	public void test() {
		Assert.assertEquals(longestPalindrome("babad"), "aba");
		Assert.assertEquals(longestPalindrome("cbbd"), "bb");
		Assert.assertEquals(longestPalindrome("abcda"), "b");
		Assert.assertEquals(longestPalindrome("abcaa"), "aa");
	}

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) return "";
		int l = s.length();
		String[] compress = new String[2 * l];
		for (int k = 0; k < l; k++) {
			compress[2 * k] = s.substring(k, k + 1);
			compress[2 * k + 1] = "";
		}
		for (int g = 1; g < l; g++) {
			for (int i = 0; i < l - g; i++) {
				int j = i + g;
				if (compress[2 * i + 1].length() != j - i - 1) {
					String left = compress[2 * i];
					String right = compress[2 * i + 2];
					compress[2 * i] = left.length() >= right.length() ? left : right;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						compress[2 * i] = s.substring(i, j + 1);
					} else {
						if (compress[2 * i + 1].equals(s.substring(i, i + 1))) {
							compress[2 * i] = compress[2 * i];
						} else if (compress[2 * i + 1].equals(s.substring(j, j + 1))) {
							compress[2 * i] = compress[2 * i + 2];
						} else if (compress[2 * i + 1].equals("")) {
							compress[2 * i] = s.substring(i, i + 1);
						} else {
							compress[2 * i] = compress[2 * i + 1];
						}
					}
				}
				compress[2 * i + 1] = compress[2 * i + 2];
			}
		}
		return compress[0];
	}
}
