package main.sprint6.contest.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class C {

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
      graph.get(v).add(u);
    }

    colors = new String[graph.size() + 1];

    Arrays.fill(colors, WHITE);

    tokenizer.nextToken();
    int startVertex = (int) tokenizer.nval;

    dfs(startVertex);

  }

  private static void dfs(int startVertex) {
    Stack<Integer> stack = new Stack<>();
    stack.push(startVertex);

    StringBuilder result = new StringBuilder();

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      if (colors[vertex].equals(WHITE)) {
        colors[vertex] = GRAY;
        stack.push(vertex);

        result.append(vertex).append(" ");

        List<Integer> edges = graph.get(vertex);
        edges.sort(Collections.reverseOrder());

        for (Integer edge : edges) {
          if (colors[edge].equals(WHITE)) {
            stack.push(edge);
          }
        }
      } else if (colors[vertex].equals(GRAY)) {
        colors[vertex] = BLACK;
      }

    }

    System.out.print(result);
  }

}


