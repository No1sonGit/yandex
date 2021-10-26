package main.sprint3.contest.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class D {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int childrenSize = (int) streamTokenizer.nval;
    int[] children = new int[childrenSize];

    for (int i = 0; i < childrenSize; i++) {
      streamTokenizer.nextToken();
      children[i] = (int) streamTokenizer.nval;
    }

    streamTokenizer.nextToken();
    int cookiesSize = (int) streamTokenizer.nval;
    int[] cookies = new int[cookiesSize];

    for (int i = 0; i < cookiesSize; i++) {
      streamTokenizer.nextToken();
      cookies[i] = (int) streamTokenizer.nval;
    }

    Arrays.sort(children);
    Arrays.sort(cookies);

    int result = 0;
    int counter = cookiesSize - 1;


    for (int i = childrenSize - 1; i >= 0; i--) {
      if (children[i] <= cookies[counter]) {
        result++;
        counter--;
      }
      if (counter == -1)
        break;
    }

    System.out.println(result);
  }

}
