package main.sprint6.contest.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J {

  private static Map<Integer, List<Integer>> graph;

  private static final String WHITE = "white";
  private static final String GRAY = "gray";
  private static final String BLACK = "black";

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

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
    }

    mainTopSort();
  }

  private static void mainTopSort() {
    Deque<Integer> ordered = new ArrayDeque<>();
    boolean[] visited = new boolean[graph.size() + 1];

    for (Integer vertex : graph.keySet()) {
      if (!visited[vertex]) {
        topSort(vertex, ordered, visited);
      }
    }

    StringBuilder result = new StringBuilder();

    while (!ordered.isEmpty()) {
      result.append(ordered.pop()).append(" ");
    }

    System.out.print(result);
  }

  private static void topSort(int vertex, Deque<Integer> ordered, boolean[] visited) {
    visited[vertex] = true;

    List<Integer> edges = graph.get(vertex);

    for (Integer edge : edges) {
      if (!visited[edge])
        topSort(edge, ordered, visited);
    }

    ordered.push(vertex);
  }

}

