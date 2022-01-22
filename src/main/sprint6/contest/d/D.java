package main.sprint6.contest.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class D {

  private static Map<Integer, List<Integer>> graph;
  private static String[] colors;
  private static Integer[] prev;
  private static Integer[] distance;

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
      graph.get(v).add(u);
    }

    colors = new String[graph.size() + 1];
    prev = new Integer[graph.size() + 1];
    distance = new Integer[graph.size() + 1];

    Arrays.fill(colors, WHITE);

    tokenizer.nextToken();
    int startVertex = (int) tokenizer.nval;

    bfs(startVertex);

  }

  private static void bfs(int startVertex) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startVertex);
    colors[startVertex] = GRAY;
    distance[startVertex] = 0;
    StringBuilder result = new StringBuilder();

    while (!queue.isEmpty()) {
      int vertex = queue.poll();

      result.append(vertex).append(" ");

      Collections.sort(graph.get(vertex));

      for (Integer edge : graph.get(vertex)) {
        if (colors[edge].equals(WHITE)) {
          distance[edge] = distance[vertex] + 1;
          prev[edge] = vertex;
          colors[edge] = GRAY;
          queue.add(edge);
        }
      }

      colors[vertex] = BLACK;
    }

    System.out.print(result);
  }

}
