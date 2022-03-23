package main.sprint7.contest.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class H {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    tokenizer.nextToken();
    int m = (int) tokenizer.nval;

    int[][] points = new int[n][m];

    for (int i = 0; i < n; i++) {
      tokenizer.nextToken();
      String[] line = String.valueOf((int) tokenizer.nval).split("");

      for (int j = 0; j < line.length; j++) {
        points[i][j] = Integer.parseInt(line[j]);
      }
    }

    int[][] dp = new int[n][m];

    dp[0][0] = points[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        dp[n - i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + points[i][j];
      }
    }

    System.out.println(dp[n - 1][m - 1]);

  }

}

