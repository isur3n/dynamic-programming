package me.suren.dp.memoization;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Title - GridWalker
 *
 * Problem -
 *  * Given a grid of "m" rows & "n" columns
 *  * Person needs to start from "top-left" cell and reach to "bottom-right" cell
 *  * Person can only go one cell to right or down at a time
 *  * Find out number of ways person can travel.
 *
 * Implementation -
 *  * Brute force
 *  * Memoization
 */
public class GridWalker {

  private final boolean isBruteForce;

  public GridWalker() {
    this.isBruteForce = true;
  }

  public GridWalker(boolean isBruteForce) {
    this.isBruteForce = isBruteForce;
  }

  public static void main(String[] args) {
    /*System.out.println("############### Brute Force");
    GridWalker g1 = new GridWalker();
    g1.perform(1, 1);
    g1.perform(2, 3);
    g1.perform(3, 2);
    g1.perform(3, 3);
    g1.perform(18, 18);*/

    System.out.println("############### Optimized");
    GridWalker g2 = new GridWalker(false);
    g2.perform(1, 1);
    g2.perform(2, 3);
    g2.perform(3, 2);
    g2.perform(3, 3);
    g2.perform(18, 18);
  }

  public void perform(int m, int n) {
    Instant start = Instant.now();
    long fib = isBruteForce ? bruteForce(m, n) : memoized(m, n, new HashMap<>());
    Instant end = Instant.now();
    System.out.println("For grid of size " + m + "x" + n + " GridWalker can take " + fib + " ways, Took " + Duration
        .between(start, end).toMillis() + " msecs.");
  }

  protected long bruteForce(int m, int n) {
    if(m == 1 && n == 1) return 1;
    if(m == 0 || n == 0) return 0;

    return bruteForce(m-1, n) + bruteForce(m, n-1);
  }

  protected long memoized(int m, int n, Map<String, Long> memo) {
    String keys = StringUtils.join(m, ",", n);
    Long fib = memo.get(keys);
    if(fib != null) {
      return fib;
    }

    if(m == 1 && n == 1) return 1L;
    if(m == 0 || n == 0) return 0L;

    fib = memoized(m-1, n, memo) + memoized(m, n-1, memo);
    memo.put(keys, fib);
    return fib;
  }
}
