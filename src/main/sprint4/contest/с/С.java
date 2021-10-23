package main.sprint4.contest.с;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class С {

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

    Map<Integer, Long> map = new HashMap<>();
    long result = 0;

    int n = chars.length;

    for (int i = 0; i < chars.length; i++) {
      n = n - 1;
      result += BigInteger.valueOf(chars[i])
          .multiply(BigInteger.valueOf((long) Math.pow(q, n))).mod(BigInteger.valueOf(mod)).longValueExact();
      map.put(i + 1, result);
    }

    System.out.println(map);

  }

}
