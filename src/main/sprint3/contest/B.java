package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

  static final Map<Character, List<String>> map;

  static {
    map = new HashMap<>();
    map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
    map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
    map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
    map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
    map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
    map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
    map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
    map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
  }

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] input = reader.readLine().toCharArray();
    reader.close();

    List<List<String>> list = new ArrayList<>();

    for (char c : input) {
      list.add(map.get(c));
    }


  }

  static String genComb(List<List<String>> input, String prefix, int i) {
    if (i == input.size())
      return prefix;

    for (int j = 0; j < input.size(); j++) {

    }
    return prefix;
  }

}
