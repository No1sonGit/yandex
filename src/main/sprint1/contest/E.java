package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line = bufferedReader.readLine().replaceAll("\\W", "").toLowerCase();
    bufferedReader.close();
    char[] chars = line.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      stringBuilder.append(chars[i]);
    }
    if (stringBuilder.toString().equals(line))
      System.out.println("True");
    else
      System.out.println("False");
  }

}
