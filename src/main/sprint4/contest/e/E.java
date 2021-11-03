package main.sprint4.contest.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String word = reader.readLine();
    reader.close();

    int[] positions = new int[256];
    int result = 0;
    int prev = 0;

    for (int i = 0; i < word.length(); i++) {
      prev = Math.max(prev, positions[word.charAt(i)]);
      positions[word.charAt(i)] = i + 1;
      result = Math.max(result, i + 1 - prev);
    }

    System.out.println(result);
  }

}
