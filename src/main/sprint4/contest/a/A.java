package main.sprint4.contest.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(reader.readLine());
    int mod = Integer.parseInt(reader.readLine());
    String input = reader.readLine();

    if (input.length() == 0) {
      System.out.println(0);
      return;
    }

    char[] chars = input.toCharArray();

    if (chars.length == 1) {
      System.out.println((int) chars[0]);
      return;
    }

    long result = (long) chars[0] * q + chars[1];

    for (int i = 2; i < chars.length; i++) {
      result = gornerMethod(result, q, chars[i]) % mod;
    }

    System.out.println(result % mod);

  }

  private static long gornerMethod(long sum, int q, int num) {
    return sum * q + num;
  }

}
