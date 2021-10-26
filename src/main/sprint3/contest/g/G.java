package main.sprint3.contest.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class G {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int n = (int) streamTokenizer.nval;
    Integer[] counter = new Integer[3];

    for (int i = 0; i < n; i++) {
      streamTokenizer.nextToken();
      int result = (int) streamTokenizer.nval;
      if (counter[result] == null)
        counter[result] = 1;
      else
        counter[result]++;
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < counter.length; i++) {
      if (counter[i] != null) {
        for (int j = 0; j < counter[i]; j++) {
          stringBuilder.append(i).append(" ");
        }
      }
    }

    System.out.println(stringBuilder);
  }
}
