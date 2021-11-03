package main.sprint4.contest.с;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class С {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    long base = (long) streamTokenizer.nval;
    streamTokenizer.nextToken();
    long mod = (long) streamTokenizer.nval;
    streamTokenizer.nextToken();
    String str = streamTokenizer.sval;

    if (str.length() == 0) {
      System.out.println(0);
      return;
    }

    long[] prefixHashes = new long[str.length() + 1];
    for (int i = 1; i <= str.length(); ++i) {
      prefixHashes[i] = (prefixHashes[i - 1] * base % mod + str.charAt(i - 1)) % mod;
    }

    long[] powers = new long[str.length() + 1];
    powers[0] = 1;
    for (int i = 1; i <= str.length(); ++i) {
      powers[i] = (powers[i - 1] * base) % mod;
    }

    streamTokenizer.nextToken();
    int n = (int) streamTokenizer.nval;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      streamTokenizer.nextToken();
      int start = (int) streamTokenizer.nval;
      streamTokenizer.nextToken();
      int end = (int) streamTokenizer.nval;

      long result = (prefixHashes[end] + mod - (prefixHashes[start] * powers[end - start]) % mod) % mod;
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }

}
