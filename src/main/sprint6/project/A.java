package main.sprint6.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class A {

  static int vertices;

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    tokenizer.nextToken();
    vertices = (int) tokenizer.nval;
    tokenizer.nextToken();
    int edges = (int) tokenizer.nval;

    int[][] graph = new int[vertices][vertices];

    for (int i = 0; i < edges; i++) {
      tokenizer.nextToken();
      int v = (int) tokenizer.nval - 1;
      tokenizer.nextToken();
      int e = (int) tokenizer.nval - 1;
      tokenizer.nextToken();
      int u = (int) tokenizer.nval;

      graph[v][e] = u;
    }

    MST(graph);
  }

  private static void MST(int[][] graph) {
    boolean[] visited = new boolean[vertices];
    int[] weights = new int[vertices];
    int[] parent = new int[vertices];

    Arrays.fill(weights, Integer.MIN_VALUE);

    weights[0] = Integer.MAX_VALUE;
    parent[0] = -1;

    for (int i = 0; i < vertices - 1; i++) {
      int maxVertexIndex = findMaxVertex(visited, weights);
      visited[maxVertexIndex] = true;

      for (int j = 0; j < vertices; j++) {
        if (graph[j][maxVertexIndex] != 0 && !visited[j] && graph[j][maxVertexIndex] > weights[j]) {
            weights[j] = graph[j][maxVertexIndex];
            parent[j] = maxVertexIndex;
        }
      }

    }
  }

  static int findMaxVertex(boolean[] visited, int[] weights) {
    int index = -1;

    int maxW = Integer.MIN_VALUE;

    for (int i = 0; i < vertices; i++) {
      if (!visited[i] && weights[i] > maxW) {
        maxW = weights[i];
        index = i;
      }
    }

    return index;
  }

  private static void printMST(int graph[][], int parent[]) {
    int mst = 0;

    for (int i = 0; i < vertices; i++) {
      mst += graph[i][parent[i]];
    }

    System.out.println(mst);
  }

}
