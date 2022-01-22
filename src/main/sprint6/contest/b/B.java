package main.sprint6.contest.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class B {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    tokenizer.nextToken();
    int vertices = (int) tokenizer.nval;
    tokenizer.nextToken();
    int edges = (int) tokenizer.nval;

    int[][] graph = new int[vertices][vertices];

    for (int i = 0; i < edges; i++) {
      tokenizer.nextToken();
      int u = (int) tokenizer.nval - 1;
      tokenizer.nextToken();
      int v = (int) tokenizer.nval - 1;

      graph[u][v] = 1;
    }

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        result.append(graph[i][j]).append(" ");
      }

      result.append("\n");
    }

    System.out.println(result);
  }

}
