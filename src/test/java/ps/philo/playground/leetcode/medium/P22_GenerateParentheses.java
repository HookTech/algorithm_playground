package ps.philo.playground.leetcode.medium;

import edu.princeton.cs.test.TestUtil;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * philo
 * # 1/29/19
 */
public class P22_GenerateParentheses {

	@Test
	public void test(){
		TestUtil.printCollections(generateParenthesisV1(2));
	}

	public List<String> generateParenthesisV1(int n) {//Brute Force
		return generateStr(n);
	}

	private List<String> generateStr(int n){
		if(n == 0){
			return Arrays.asList("");
		}
		List<String> candidates = new ArrayList<>();
		List<String> sub_candidates = generateStr(n - 1);
		for (String ss : sub_candidates){
			candidates.add("(" + ss + "(");
			candidates.add("(" + ss + ")");
			candidates.add(")" + ss + ")");
			candidates.add(")" + ss + "(");
		}
		return candidates;
	}
}
