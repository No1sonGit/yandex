package main.sprint6.contest.h;

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
import java.util.Stack;

public class H {

  private static Map<Integer, List<Integer>> graph;
  private static String[] colors;

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

    colors = new String[graph.size() + 1];

    Arrays.fill(colors, WHITE);

    dfs(1);

  }

  private static void dfs(int startVertex) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(startVertex);
    int[] entry = new int[graph.size() + 1];
    int[] leave = new int[graph.size() + 1];
    int time = 0;

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      if (colors[vertex].equals(WHITE)) {
        time++;
        entry[vertex] = time;
        colors[vertex] = GRAY;
        stack.push(vertex);

        List<Integer> edges = graph.get(vertex);
        edges.sort(Collections.reverseOrder());

        for (Integer edge : edges) {
          if (colors[edge].equals(WHITE)) {
            stack.push(edge);
          }
        }
      } else if (colors[vertex].equals(GRAY)) {
        time++;
        leave[vertex] = time;
        colors[vertex] = BLACK;
      }
    }

    StringBuilder result = new StringBuilder();

    for (int i = 1; i < entry.length; i++) {
      result.append(entry[i] - 1).append(" ").append(leave[i] - 1).append("\n");
    }

    System.out.println(result);
  }

}

