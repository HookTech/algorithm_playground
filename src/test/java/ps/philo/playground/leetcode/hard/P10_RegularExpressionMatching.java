package ps.philo.playground.leetcode.hard;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * philo
 * # 1/16/19
 */
public class P10_RegularExpressionMatching {
	@Test
	public void test() {
		Assert.assertEquals(isMatchV1("aa", "a"), false);
		Assert.assertEquals(isMatchV1("aa", "a*"), true);
		Assert.assertEquals(isMatchV1("ab",".*"),true);
		Assert.assertEquals(isMatchV1("aab","c*a*b*"),true);
		Assert.assertEquals(isMatchV1("mississippi","mis*is*p*."),false);
	}

	public boolean isMatchV1(String text, String pattern) {//Recursion approach
		if (pattern.isEmpty()) return text.isEmpty();
		boolean first_match = (!text.isEmpty() &&
			(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatchV1(text, pattern.substring(2)) ||
				(first_match && isMatchV1(text.substring(1), pattern)));
		} else {
			return first_match && isMatchV1(text.substring(1), pattern.substring(1));
		}
	}
	public boolean isMatchV2(String text, String pattern) {//Dynamic Programming approach
		
	}
}
