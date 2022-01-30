package main.sprint6.contest.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class C {

  private static Map<Integer, List<Integer>> graph;

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
      graph.get(v).add(u);
    }

    tokenizer.nextToken();
    int startVertex = (int) tokenizer.nval;

    dfsMain(startVertex);
  }

  private static void dfsMain(int vertex) {
    boolean[] visited = new boolean[graph.size() + 1];

    StringBuilder result = new StringBuilder();

    dfs(vertex, visited, result);

    System.out.println(result);
  }

  private static void dfs(int vertex, boolean[] visited, StringBuilder result) {
    visited[vertex] = true;

    List<Integer> edges = graph.get(vertex);
    Collections.sort(edges);

    result.append(vertex).append(" ");

    for (Integer edge : edges) {
        if (!visited[edge])
          dfs(edge, visited, result);
    }

  }

}


