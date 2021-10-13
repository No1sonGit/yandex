package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    reader.close();

  }

  public static void genBraces(int n, String prefix) {
    if (n == 0) {
      System.out.println(prefix);
    } else {
      genBraces(n - 1, prefix + "(");
      genBraces(n - 1, prefix + ")");
    }
  }

}
