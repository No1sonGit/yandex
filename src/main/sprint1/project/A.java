package main.sprint1.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class A {

  //52726141

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter printWriter = new PrintWriter(System.out);
    streamTokenizer.nextToken();
    int[] nums = new int[(int) streamTokenizer.nval];
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      streamTokenizer.nextToken();
      int num = (int) streamTokenizer.nval;
      if (num == 0)
        list.add(i);
      nums[i] = num;
    }

    Integer prevNull = null;

    for (int i = 0; i < list.size(); i++) {
      if (list.size() == 1) {
        int currNull = list.get(i);
        for (int j = 0; j < nums.length; j++) {
          if (j < currNull) {
            printWriter.print(currNull - j + " ");
          } else {
            printWriter.print(j - currNull + " ");
          }
        }
        break;
      }

      int leftNull;

      if (prevNull == null) {
        leftNull = list.get(i);
        for (int j = 0; j < leftNull; j++) {
          printWriter.print(leftNull - j + " ");
        }
      } else {
        leftNull = prevNull;
      }

      int rightNull = i + 1 < list.size() ? list.get(i + 1) : list.get(i);
      prevNull = rightNull;

      for (int j = leftNull; j < rightNull; j++) {
        printWriter.print(Math.min(j - leftNull, rightNull - j) + " ");
      }

      if (i == list.size() - 1 && rightNull < nums.length) {
        for (int j = rightNull; j < nums.length; j++) {
          printWriter.print(j - rightNull + " ");
        }
      }
    }

    printWriter.flush();
  }
}
