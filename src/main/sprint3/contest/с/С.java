package main.sprint3.contest.с;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class С {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String a = reader.readLine();
    String b = reader.readLine();
    reader.close();

    System.out.println(isSubstring(a, b) ? "True" : "False");

  }

  static boolean isSubstring(String template, String str) {
    int i = 0;

    for (int j = 0; j < str.length(); j++) {
      if (i == template.length())
        return true;
      if (str.charAt(j) == template.charAt(i))
        i++;
    }

    return i == template.length();
  }
}
