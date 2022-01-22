package main.sprint6.contest.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class A {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    tokenizer.nextToken();
    int vertices = (int) tokenizer.nval;
    tokenizer.nextToken();
    int edges = (int) tokenizer.nval;

    Map<Integer, List<Integer>> graph = new HashMap<>(vertices);

    for (int i = 0; i < vertices; i++) {
      graph.put(i + 1, new ArrayList<>());
    }

    for (int i = 0; i < edges; i++) {
      tokenizer.nextToken();
      int u = (int) tokenizer.nval;
      tokenizer.nextToken();
      int v = (int) tokenizer.nval;

      if (graph.containsKey(u)) {
        graph.get(u).add(v);
      }
    }

    for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      StringBuilder result = new StringBuilder();
      result.append(entry.getValue().size()).append(" ");

      for (Integer integer : entry.getValue()) {
        result.append(integer).append(" ");
      }

      System.out.println(result);
    }
  }

}
