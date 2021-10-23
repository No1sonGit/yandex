package main.sprint4.contest.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class E {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String word = reader.readLine();
    reader.close();

    Set<Character> set = new HashSet<>();
    int counter = 0;
    int max = 0;

    for (int i = 0; i < word.length(); i++) {
      if (set.contains(word.charAt(i))) {
        max = Math.max(max, counter);
        counter = 0;
        set.clear();
      } else {
        set.add(word.charAt(i));
        counter++;
      }
    }

    max = Math.max(max, counter);

    System.out.println(max);
  }

}
