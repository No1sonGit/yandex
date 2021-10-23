package main.sprint3.contest.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

  static final String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String digits = reader.readLine();
    reader.close();

    StringBuilder result = new StringBuilder();

    dfs(digits, alphabet, result, "");

    System.out.println(result);

  }

  static void dfs(String digits, String[] alphabet, StringBuilder result, String buffer) {
    if (buffer.length() == digits.length()) {
      result.append(buffer).append(" ");
      return;
    }

    for (char letter : alphabet[digits.toCharArray()[buffer.length()] - '0'].toCharArray()) {
      dfs(digits, alphabet, result, buffer + letter);
    }

  }

}
