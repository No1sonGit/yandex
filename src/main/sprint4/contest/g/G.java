package main.sprint4.contest.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class G {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;

    if (size == 0) {
      System.out.println(0);
      return;
    }

    Map<Integer, Integer> progress = new HashMap<>();

    int[] scores = new int[size + 1];

    int sum = 0;

    for (int i = 1; i < scores.length; i++) {
      streamTokenizer.nextToken();
      if ((int) streamTokenizer.nval == 0)
        sum++;
      else
        sum--;
      progress.put(sum, i);
      scores[i] = sum;
    }

    int max = 0;

    if (scores.length == 2 && scores[1] == 0) {
      System.out.println(2);
      return;
    }

    for (int i = 0; i < scores.length; i++) {
      if (!progress.containsKey(scores[i]))
        continue;
      max = Math.max(progress.get(scores[i]) - i, max);
    }

    System.out.println(max);

  }

}
