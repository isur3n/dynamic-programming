package me.suren.dp.memoization;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseSolution<X, Y> {

  protected final boolean IS_BRUTE_FORCE;

  protected BaseSolution(boolean isBruteForce) {
    IS_BRUTE_FORCE = isBruteForce;
  }

  protected void perform(X n) {
    Instant start = Instant.now();
    X fib = IS_BRUTE_FORCE ? bruteForce(n) : memoized(n, new HashMap<>());
    Instant end = Instant.now();
    System.out.println("Fibonacci at " + n + " is = " + fib + ", took " + Duration
        .between(start, end).toMillis() + " msecs.");
  }

  protected abstract X bruteForce(X n);

  protected abstract X memoized(X n, Map<X, Y> memo);
}
