package main.sprint5.contest.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class I {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int n = (int) streamTokenizer.nval;
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    
    System.out.println(permute(nums).size());
  }

  private static Set<String> permute(int[] nums) {
    Set<String> ret = new HashSet<>();
    dfs(ret, new LinkedHashSet<>(), nums);
    return ret;
  }

  private static void dfs(Set<String> ret, Set<Integer> path, int[] nums) {
    if (path.size() == nums.length) {
      StringBuilder sb = new StringBuilder();
      for (Integer integer : path) {
        
      }
      return;
    }
    for (int num : nums) {
      if (path.add(num)) {
        dfs(ret, path, nums);
        path.remove(num);
      }
    }
  }
}
