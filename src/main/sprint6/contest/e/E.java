package main.sprint6.contest.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class E {

  private static Map<Integer, List<Integer>> graph;

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(
        new BufferedReader(new InputStreamReader(System.in)));

    tokenizer.nextToken();
    int vertices = (int) tokenizer.nval;
    tokenizer.nextToken();
    int edges = (int) tokenizer.nval;

    graph = new HashMap<>(vertices);

    for (int i = 0; i < vertices; i++) {
      graph.put(i + 1, new ArrayList<>());
    }

    for (int i = 0; i < edges; i++) {
      tokenizer.nextToken();
      int u = (int) tokenizer.nval;
      tokenizer.nextToken();
      int v = (int) tokenizer.nval;

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    mainDfs();
  }

  private static void mainDfs() {
    int[] colors = new int[graph.size() + 1];
    Arrays.fill(colors, -1);

    int componentCount = 1;

    List<List<Integer>> results = new LinkedList<>();

    for (int i = 1; i < colors.length; i++) {
      if (colors[i] == -1) {
        List<Integer> result = new LinkedList<>();

        dfs(i, colors, componentCount, result);

        results.add(result);

        componentCount++;
      }
    }

    System.out.println(results.size());

    for (List<Integer> result : results) {
      StringBuilder stringBuilder = new StringBuilder();

      Collections.sort(result);

      for (Integer vertex : result) {
        stringBuilder.append(vertex).append(" ");
      }

      System.out.println(stringBuilder);
    }
  }

  private static void dfs(int vertex, int[] colors, int componentCount, List<Integer> result) {
    if (colors[vertex] == -1) {
      colors[vertex] = componentCount;
      result.add(vertex);

      List<Integer> edges = graph.get(vertex);

      for (Integer edge : edges) {
        if (colors[edge] == -1) {
          dfs(edge, colors, componentCount, result);
        }
      }
    }
  }

}
