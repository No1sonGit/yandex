package main.sprint6.contest.g;

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

public class G {

  private static Map<Integer, List<Integer>> graph;
  private static String[] colors;
  private static int[] prev;
  private static int[] distance;

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
    prev = new int[graph.size() + 1];
    distance = new int[graph.size() + 1];

    Arrays.fill(colors, WHITE);

    tokenizer.nextToken();
    int startVertex = (int) tokenizer.nval;

    bfs(startVertex);
    findLongestPath();

  }

  private static void bfs(int startVertex) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startVertex);
    colors[startVertex] = GRAY;
    distance[startVertex] = 0;

    while (!queue.isEmpty()) {
      int vertex = queue.poll();

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

  }

  private static void findLongestPath() {
    int result = 0;
    Arrays.fill(colors, WHITE);

    for (Integer vertex : graph.keySet()) {
      if (colors[vertex].equals(WHITE)) {
        result = Math.max(result, longestPath(vertex));
      }
    }

    System.out.println(result - 1);
  }


  private static int longestPath(int vertex) {
    int currentVertex = vertex;
    int counter = 0;

    while (currentVertex != 0) {
      colors[currentVertex] = BLACK;
      currentVertex = prev[currentVertex];
      counter++;
    }

    return counter;
  }

}

