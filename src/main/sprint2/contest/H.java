package main.sprint2.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class H {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] brackets = reader.readLine().toCharArray();
    reader.close();

    System.out.println(isCorrectBracketSeq(brackets) ? "True" : "False");
  }

  static boolean isCorrectBracketSeq(char[] brackets) {
    Deque<Character> stack = new LinkedList<>();

    for (char bracket : brackets) {
      switch (bracket) {
        case '{':
          stack.push('}');
          break;
        case '[':
          stack.push(']');
          break;
        case '(':
          stack.push(')');
          break;
        case '}':
        case ']':
        case ')':
          if (stack.isEmpty())
            return false;
          if (bracket != stack.pop())
            return false;
      }
    }

    return stack.isEmpty();
  }

}
