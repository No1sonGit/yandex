package main.sprint7.contest.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class A {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
      tokenizer.nextToken();
      nums[i] = (int) tokenizer.nval;
    }

    int result = 0;

    for (int i = 1; i < nums.length; i++) {
      result = nums[i] > nums[i - 1] ? result + nums[i] - nums[i - 1] : result;
    }

    System.out.println(result);

  }

}
