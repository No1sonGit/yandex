package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class J {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;
    int[] nums = new int[size];

    for (int i = 0; i < nums.length; i++) {
      streamTokenizer.nextToken();
      nums[i] = (int) streamTokenizer.nval;
    }

    StringBuilder stringBuilder = new StringBuilder();

    boolean needIteration = true;
    for (int i = 0; i < size -1; i++) {
      needIteration = false;
      for (int j = 0; j < size - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
          needIteration = true;
        }
      }
      if (!needIteration)
        break;

      for (int num : nums) {
        stringBuilder.append(num).append(" ");
      }
      stringBuilder.append("\n");
    }

    if (stringBuilder.length() > 0) {
      System.out.println(stringBuilder);
    } else {
      for (int num : nums) {
        stringBuilder.append(num).append(" ");
      }
      System.out.println(stringBuilder);
    }

  }

  private static void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

}
