package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    reader.close();

    StringBuilder result = new StringBuilder();

    genBrackets(result, "", n, 0);

    System.out.println(result);

  }

  static void genBrackets(StringBuilder result, String current, int open, int close) {
    if (open == 0 && close == 0) {
      result.append(current).append("\n");
    }

    if (open > 0)
      genBrackets(result, current + "(", open - 1, close + 1);
    if (close > 0)
      genBrackets(result, current + ")", open, close - 1);
  }

}
