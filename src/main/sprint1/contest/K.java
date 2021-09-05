package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      stringBuilder.append(stringTokenizer.nextToken());
    }
    int x = Integer.parseInt(stringBuilder.toString());
    int k = Integer.parseInt(reader.readLine());
    reader.close();
    char[] chars = String.valueOf(x + k).toCharArray();
    stringBuilder = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      stringBuilder.append(chars[i]).append(" ");
    }
    System.out.println(stringBuilder.toString().trim());
  }

}
