package me.suren.dp.memoization;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci series implementation -
 *  * Brute force
 *  * Memoization
 */
public class Fibonacci extends BaseSolution<Long, Long> {

  public Fibonacci() {
    super(true);
  }

  public Fibonacci(boolean isBruteForce) {
    super(isBruteForce);
  }

  public static void main(String[] args) {
    System.out.println("############### Brute Force");
    Fibonacci f1 = new Fibonacci();
    f1.perform(1L);
    f1.perform(10L);
    f1.perform(42L);

    System.out.println("############### Optimized");
    Fibonacci f2 = new Fibonacci(false);
    f2.perform(1L);
    f2.perform(10L);
    f2.perform(42L);
  }

  @Override
  public Long bruteForce(Long n) {
    if(n <= 1) return 1L;
    return bruteForce(n-1) + bruteForce(n-2);
  }

  @Override
  public Long memoized(Long n, Map<Long, Long> memo) {
    Long value = memo.get(n);
    if(value != null) return value;

    if(n <= 1) return 1L;
    Long fib = memoized(n-1, memo) + memoized(n-2, memo);
    memo.put(n, fib);
    return fib;
  }
}
