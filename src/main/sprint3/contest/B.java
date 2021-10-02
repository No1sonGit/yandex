package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {

  static final Map<Character, String[]> map;

  static {
    map = new HashMap<>();
    map.put('2', new String[]{"a", "b", "c"});
    map.put('3', new String[]{"d", "e", "f"});
    map.put('4', new String[]{"g", "h", "i"});
    map.put('5', new String[]{"j", "k", "l"});
    map.put('6', new String[]{"m", "n", "o"});
    map.put('7', new String[]{"p", "q", "r", "s"});
    map.put('8', new String[]{"t", "u", "v"});
    map.put('9', new String[]{"w", "x", "y", "z"});
  }

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] input = reader.readLine().toCharArray();
    reader.close();


  }

  static void genComb(char[] input, String prefix, int counter) {

  }

}
