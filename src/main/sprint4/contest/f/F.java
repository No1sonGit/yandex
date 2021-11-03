package main.sprint4.contest.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    String[] words = new String[n];

    for (int i = 0; i < words.length; i++) {
      tokenizer.nextToken();
      words[i] = tokenizer.sval;
    }

    Map<String, List<Integer>> data = new HashMap<>();
    List<String> order = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      char[] chars = words[i].toCharArray();
      Arrays.sort(chars);
      words[i] = new String(chars);

      if (!data.containsKey(words[i]))
        order.add(words[i]);

      if (data.get(words[i]) == null) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        data.put(words[i], list);
      } else {
        data.get(words[i]).add(i);
      }
    }

    List<List<Integer>> positions = new ArrayList<>(order.size());
    for (int i = 0; i < order.size(); i++) {
      positions.add(new ArrayList<>());
    }

    for (int i = 0; i < order.size(); i++) {
      for (Integer pos : data.get(order.get(i))) {
        positions.get(i).add(pos);
      }

    }

    StringBuilder sb = new StringBuilder();

    for (List<Integer> position : positions) {
      for (Integer integer : position) {
        sb.append(integer).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

}
