package main.sprint1.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] nums = new int[Integer.parseInt(reader.readLine())];
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
    reader.close();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int num = Integer.parseInt(stringTokenizer.nextToken());
      if (num == 0)
        list.add(i);
      nums[i] = num;
    }

    StringBuilder stringBuilder = new StringBuilder();
    Integer prevNull = null;

    for (int i = 0; i < list.size(); i++) {

      if (list.size() == 1) {
        int currNull = list.get(i);
        for (int j = 0; j < nums.length; j++) {
          if (j < currNull)
            stringBuilder.append(currNull - j).append(" ");
          else {
            stringBuilder.append(j - currNull).append(" ");
          }
        }
        break;
      }

      int leftNull;
      if (prevNull == null) {
        leftNull = list.get(i);
        for (int j = 0; j < leftNull; j++) {
          stringBuilder.append(leftNull - j).append(" ");
        }
      } else {
        leftNull = prevNull;
      }
      int rightNull = i + 1 < list.size() ? list.get(i + 1) : list.get(i);
      prevNull = rightNull;

      for (int j = leftNull; j < rightNull; j++) {
        if (j - leftNull < rightNull - j)
          stringBuilder.append(j - leftNull).append(" ");
        else
          stringBuilder.append(rightNull - j).append(" ");
      }

      if (i == list.size() - 1 && rightNull < nums.length) {
        for (int j = rightNull; j < nums.length; j++) {
          stringBuilder.append(j - rightNull).append(" ");
        }
      }

    }
    System.out.println(stringBuilder);
  }
}
