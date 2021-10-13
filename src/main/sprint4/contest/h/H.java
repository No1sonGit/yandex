package main.sprint4.contest.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class H {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] a = reader.readLine().toCharArray();
    char[] b = reader.readLine().toCharArray();
    reader.close();

    if (a.length != b.length) {
      System.out.println("NO");
      return;
    }

    Map<Character, Integer> aa = new HashMap<>();
    Map<Character, Integer> bb = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      if (aa.containsKey(a[i])) {
        aa.put(a[i], aa.get(a[i]) + 1);
      } else {
        aa.put(a[i], 0);
      }
      if (bb.containsKey(b[i])) {
        bb.put(b[i], bb.get(b[i]) + 1);
      } else {
        bb.put(b[i], 0);
      }
    }

    for (int i = 0; i < a.length; i++) {
      int aRes = aa.get(a[i]);
      int bRes = bb.get(b[i]);
      if (aRes != bRes) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");

  }

}
