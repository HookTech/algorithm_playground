package ps.philo.playground.play;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.test.TestUtil;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * philo
 * # 3/12/19
 */
public class QuickTest {

	@Test
	public void test() {
		int[] a = new int[]{14, -1, 3, 4, 9, 7, 3, 2};
		int i = 100;
		while (i-- > 0) {
			TestUtil.assertEqualArray(new int[]{-1, 2, 3, 3, 4}, miniK(a, 5));
		}
		TestUtil.assertEqualArray(new int[]{-1, 2, 3, 3}, miniK2(a, 4));
	}

	public int[] miniK(int[] input, int k) {
		StdRandom.shuffle(input);
		quickSort(input, 0, input.length - 1);
		int[] mini = new int[k];
		for (int i = 0; i < k; i++) {
			mini[i] = input[i];
		}
		return mini;
	}

	public int[] miniK2(int[] input, int k) {
		Queue<Integer> pquene = new PriorityQueue<>();
		for (int item : input) {
			pquene.offer(item);
		}
		int[] mini = new int[k];
		for (int i = 0; i < k; i++) {
			mini[i] = pquene.poll();
		}
		return mini;
	}

	public void quickSort(int[] a, int low, int high) {
		if (low >= high) return;
		int splitPoint = partition(a, low, high);
		quickSort(a, low, splitPoint - 1);
		quickSort(a, splitPoint + 1, high);
	}

	public int partition(int[] a, int low, int high) {
		int split = a[low];
		int i = low, j = high + 1;
		while (true) {
			while (a[++i] < split) if (i == high) break;
			while (a[--j] > split) if (j == low) break;
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, j, low);
		return j;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
