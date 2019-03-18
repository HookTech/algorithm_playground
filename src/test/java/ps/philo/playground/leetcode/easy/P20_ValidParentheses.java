package ps.philo.playground.leetcode.easy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * philo
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * # 3/18/19
 */
public class P20_ValidParentheses {
	@Test
	public void test(){
		Assert.assertTrue(isValid("()"));
	}

	public boolean isValid(String s) {
		Stack<Character> innerStack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (classify(cc)) innerStack.push(cc);
			else if (innerStack.size() != 0) {
				char p = innerStack.pop();
				if (!pair(p, cc)) return false;
			} else
				return false;
		}
		return innerStack.size() == 0;
	}

	boolean classify(char cc) {
		return (cc == '(' || cc == '{' || cc == '[');
	}

	boolean pair(char c1, char c2) {
		return (c1 == '(' && c2 == ')')
			|| (c1 == '{' && c2 == '}')
			|| (c1 == '[' && c2 == ']');
	}
}
