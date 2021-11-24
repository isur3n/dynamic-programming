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
public class Fibonacci {

  private final boolean isBruteForce;

  public Fibonacci() {
    this.isBruteForce = true;
  }

  public Fibonacci(boolean isBruteForce) {
    this.isBruteForce = isBruteForce;
  }

  public static void main(String[] args) {
    System.out.println("############### Brute Force");
    Fibonacci f1 = new Fibonacci();
    f1.perform(1);
    f1.perform(10);
    f1.perform(42);

    System.out.println("############### Optimized");
    Fibonacci f2 = new Fibonacci(false);
    f2.perform(1);
    f2.perform(10);
    f2.perform(42);
  }

  public void perform(int n) {
    Instant start = Instant.now();
    Long fib = isBruteForce ? bruteForce(n) : memoized(n, new HashMap<>());
    Instant end = Instant.now();
    System.out.println("Fibonacci at " + n + " is = " + fib + ", took " + Duration
        .between(start, end).toMillis() + " msecs.");
  }

  public Long bruteForce(int n) {
    if(n <= 1) return 1L;
    return bruteForce(n-1) + bruteForce(n-2);
  }

  public Long memoized(int n, Map<Integer, Long> memo) {
    Long value = memo.get(n);
    if(value != null) return value;

    if(n <= 1) return 1L;
    Long fib = memoized(n-1, memo) + memoized(n-2, memo);
    memo.put(n, fib);
    return fib;
  }
}
