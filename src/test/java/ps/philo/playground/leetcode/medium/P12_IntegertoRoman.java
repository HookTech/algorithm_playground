package ps.philo.playground.leetcode.medium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * philo
 * # 1/20/19
 */
public class P12_IntegertoRoman {
	@Test
	public void test(){
		Assert.assertEquals(intToRoman(3),"III");
		Assert.assertEquals(intToRoman(4),"IV");
		Assert.assertEquals(intToRoman(9),"IX");
		Assert.assertEquals(intToRoman(58),"LVIII");
		Assert.assertEquals(intToRoman(1994),"MCMXCIV");
	}

	public String intToRoman(int num) {
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
}
