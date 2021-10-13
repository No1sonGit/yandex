package main.sprint3.contest.с;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class С {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] a = reader.readLine().toCharArray();
    char[] b = reader.readLine().toCharArray();
    reader.close();

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < b.length; i++) {

      if (i <= a.length - 1) {
        if (map.containsKey(a[i])) {
          map.put(a[i], map.get(a[i]) + 1);
        } else {
          map.put(a[i], 0);
        }
      }

      if (map.containsKey(b[i])) {
        map.put(b[i], map.get(b[i]) - 1);
      }
    }

    System.out.println(map);

  }
}
