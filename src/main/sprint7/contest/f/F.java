package main.sprint7.contest.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class F {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    tokenizer.nextToken();
    int k = (int) tokenizer.nval;

    System.out.println(countWays(n, k));

  }

  static long countWays(int n, int k) {
    long[] dp = new long[n];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < n; i++) {
      for (int j = 1; j <= k && j <= i; j++)
        dp[i] = (dp[i] % 1000000007) + (dp[i - j] % 1000000007);
    }

    return dp[n - 1] % 1000000007;
  }

}
