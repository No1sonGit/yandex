package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    int m = Integer.parseInt(bufferedReader.readLine());
    int[][] matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }
    int x = Integer.parseInt(bufferedReader.readLine());
    int y = Integer.parseInt(bufferedReader.readLine());
    bufferedReader.close();
    ArrayList<Integer> result = new ArrayList<>();
    if (x + 1 <= n - 1)
      result.add(matrix[x + 1][y]);
    if (x - 1 >= 0)
      result.add(matrix[x - 1][y]);
    if (y + 1 <= m - 1)
      result.add(matrix[x][y + 1]);
    if (y - 1 >= 0)
      result.add(matrix[x][y - 1]);
    Collections.sort(result);
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer num : result) {
      stringBuilder.append(num).append(" ");
    }
    System.out.println(stringBuilder.toString().trim());
  }

}
