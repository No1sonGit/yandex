package main.sprint3.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class L {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;
    int[] nums = new int[size];

    for (int i = 0; i < size; i++) {
      streamTokenizer.nextToken();
      nums[i] = (int) streamTokenizer.nval;
    }

    streamTokenizer.nextToken();
    int x = (int) streamTokenizer.nval;

    int first = binarySearch(nums, x, 0, size - 1);
    int second = nums[size - 1] > x ? binarySearch(nums, x * 2, first - 1, size - 1) : -1;

    System.out.println(first + " " + second);


  }

  static int binarySearch(int[] nums, int x, int left, int right) {
    if (nums[left] >= x)
      return left + 1;

    if (right <= left)
      return -1;

    int mid = (left + right) / 2;

    if (nums[mid] >= x && nums[mid - 1] < x)
      return mid + 1;

    if (nums[mid] >= x) {
      if (binarySearch(nums, x, left, mid) == -1)
        return mid + 1;
      else
        return binarySearch(nums, x, left, mid);
    } else {
      return binarySearch(nums, x, mid + 1, right);
    }

  }

}

