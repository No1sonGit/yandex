package main.sprint3.contest.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class H {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;
    int[] values = new int[size];

    for (int i = 0; i < values.length; i++) {
      streamTokenizer.nextToken();
      values[i] = (int) streamTokenizer.nval;
    }

    insertionSortByComparator(values);

    for (int value : values) {
      System.out.print(value);
    }
  }

  public static void insertionSortByComparator(int[] values) {
    for (int i = 1; i < values.length; i++) {
      int itemToInsert = values[i];
      int j = i;
      while (j > 0 && less(itemToInsert, values[j - 1])) {
        values[j] = values[j - 1];
        j--;
        values[j] = itemToInsert;
      }
    }
  }

  private static boolean less(Integer value1, Integer value2) {
    String first = value1.toString() + value2;
    String second = value2 + value1.toString();
    return Integer.parseInt(second) < Integer.parseInt(first);
  }

}
