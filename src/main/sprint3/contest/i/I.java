package main.sprint3.contest.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class I {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      tokenizer.nextToken();
      int num = (int) tokenizer.nval;
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    tokenizer.nextToken();
    int k = (int) tokenizer.nval;

    List<Entry<Integer, Integer>> pair = new ArrayList<>(map.entrySet());

    pair.sort((x, y) -> {
      if (Objects.equals(x.getValue(), y.getValue())) {
        return x.getKey().compareTo(y.getKey());
      } else {
        return y.getValue().compareTo(x.getValue());
      }
    });

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < k; i++) {
      stringBuilder.append(pair.get(i).getKey()).append(" ");
    }

    System.out.println(stringBuilder);
  }

}
