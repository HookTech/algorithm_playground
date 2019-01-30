package ps.philo.playground.module;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class JavaForkJoin {
  @Test
  public void test() {
    ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    int[] testCase = generateRandomIntArray(1000);
    System.out.print(Arrays.toString(testCase));
    forkJoinPool.invoke(new SortTask(testCase,0, testCase.length));
    System.out.print(Arrays.toString(testCase));
  }

  class SortTask extends RecursiveAction {
    final int[] array;
    final int lo;
    final int hi;

    SortTask(int[] array, int lo, int hi) {
      this.array = array;
      this.lo = lo;
      this.hi = hi;
    }

    protected void compute() {
      if (hi - lo < 20)
        Arrays.sort(array, lo, hi);
      else {
        int mid = (lo + hi) >>> 1;
        invokeAll(new SortTask(array, lo, mid),
          new SortTask(array, mid, hi));
        merge(array, lo, mid, hi);
      }
    }

    private void merge(int[] arr, int start, int mid, int end) {
      //stores the starting position of both parts in temporary variables.
      int p = start, q = mid + 1;

      int k = 0;
      int[] copy = new int[end - start + 1];

      for (int i = start; i <= end; i++) {
        if (p > mid)      //checks if first part comes to an end or not .
          copy[k++] = arr[q++];
        else if (q > end)   //checks if second part comes to an end or not
          copy[k++] = arr[p++];
        else if (arr[p] < arr[q])     //checks which part has smaller element.
          copy[k++] = arr[p++];
        else
          copy[k++] = arr[q++];
      }
      for (int l = 0; l < k; l++) {
      /* Now the real array has elements in sorted manner including both
        parts.*/
        arr[start++] = copy[l];
      }
    }
  }

  public static int[] generateRandomIntArray(int n){
    int[] x = new int[n];
    for(int i = 0; i < n; i++)
    {
      x[i] = i;
    }
    Random r = new Random();
    for(int i = 0; i < n; i++)
    {
      int in = r.nextInt(n - i) + i;
      int t = x[in];
      x[in] = x[i];
      x[i] = t;
    }
    return x;
  }

}
