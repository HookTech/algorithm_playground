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
//		String[][] subs = new String[l + 1][l];
    String[] subs = new String[l + 1];
    for (int k = 0; k < l; k++) {
      subs[project(k, k, 0, l)] = s.substring(k, k + 1);
      subs[project(k + 1, k, 0, l)] = "";
    }
    for (int g = 1; g < l; g++) {
      for (int i = 0; i < l - g; i++) {
        int j = i + g;
        if (subs[project(i+1,j-1,g,l)].length() != j - i - 1) {
          String left = subs[i][j - 1];
          String right = subs[i + 1][j];
          subs[i][j] = left.length() >= right.length() ? left : right;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            subs[i][j] = s.substring(i, j + 1);
          } else {
            if (subs[i + 1][j - 1].equals(s.substring(i, i + 1))) {
              subs[i][j] = subs[i][j - 1];
            } else if (subs[i + 1][j - 1].equals(s.substring(j, j + 1))) {
              subs[i][j] = subs[i + 1][j];
            } else if (subs[i + 1][j - 1].equals("")) {
              subs[i][j] = s.substring(i, i + 1);
            } else {
              subs[i][j] = subs[i + 1][j - 1];
            }
          }
        }
      }
    }
    return subs[0][l - 1];
  }

  private int project(int i, int j, int gap, int length) {
    if (i > j) {
      return length - 1;
    } else {
      return i + gap;
    }
  }
}
