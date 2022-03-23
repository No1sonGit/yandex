package main.sprint6.contest.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class K {

  private static Map<Integer, Map<Integer, Integer>> graph;
  private static int[] dist;
  private static int[] prev;
  private static boolean[] visited;
  private static int[][] result;

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    tokenizer.nextToken();
    int vertices = (int) tokenizer.nval;
    tokenizer.nextToken();
    int edges = (int) tokenizer.nval;

    graph = new HashMap<>(vertices);

    for (int i = 0; i < vertices; i++) {
      graph.put(i + 1, new HashMap<>());
    }

    for (int i = 0; i < edges; i++) {
      tokenizer.nextToken();
      int u = (int) tokenizer.nval;
      tokenizer.nextToken();
      int v = (int) tokenizer.nval;
      tokenizer.nextToken();
      int w = (int) tokenizer.nval;

      graph.get(u).put(v, w);
    }

    result = new int[graph.size()][graph.size()];


    for (Integer vertex : graph.keySet()) {
      dijkstra(vertex);
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        stringBuilder.append(result[i][j]).append(" ");
      }

      stringBuilder.append("\n");
    }

    System.out.println(stringBuilder);

  }

  private static void dijkstra(int s) {
    visited = new boolean[graph.size() + 1];
    dist = new int[graph.size() + 1];
    prev = new int[graph.size() + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[s] = 0;

    for (Integer vertex : graph.keySet()) {
      if (!visited[vertex] && dist[vertex] != Integer.MAX_VALUE) {
        int u = getMinDistNotVisitedVertex();

        visited[u] = true;

        Map<Integer, Integer> neighbours = graph.get(u);

        for (Entry<Integer, Integer> neighbour : neighbours.entrySet()) {
          relax(u, neighbour);
        }
      }
    }

  }

  private static int getMinDistNotVisitedVertex() {
    int currMin = Integer.MAX_VALUE;
    int currMinVertex = 0;

    for (Integer vertex : graph.keySet()) {
      if (!visited[vertex] && dist[vertex] < currMin) {
        currMin = dist[vertex];
        currMinVertex = vertex;
      }
    }

    return currMinVertex;
  }

  private static void relax(int u, Entry<Integer, Integer> v) {
    if (dist[v.getKey()] > dist[u] + v.getValue()) {
      dist[v.getKey()] = dist[u] + v.getValue();
      prev[v.getKey()] = u;

      result[v.getKey() - 1][u - 1] = dist[v.getKey()];
      result[u - 1][v.getKey() - 1] = dist[v.getKey()];
    }
  }

}
