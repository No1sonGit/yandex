package main.sprint4.contest.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(reader.readLine());
    Set<String> set = new HashSet<>();

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < size; i++) {
      String line = reader.readLine();
      if (!set.contains(line)) {
        set.add(line);
        result.append(line).append("\n");

      }
    }
    reader.close();
    System.out.println(result);

  }

}
