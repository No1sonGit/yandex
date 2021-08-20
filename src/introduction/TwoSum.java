package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt(bufferedReader.readLine());
        List<Integer> nums = Arrays.stream(bufferedReader.readLine().split(" ")).
                map(Integer::parseInt)
                .collect(Collectors.toList());
        int expected = Integer.parseInt(bufferedReader.readLine());
        System.out.println(dynamicSearch(nums, expected));
    }

    public static String naive(List<Integer> nums, int expected) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size() - 1; j++) {
                if (nums.get(i) + nums.get(j) == expected)
                    return nums.get(i) + " " + nums.get(j);
            }
        }
        return "None";
    }

    public static String twoPointers(List<Integer> nums, int expected) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int currentSum = nums.get(left) + nums.get(right);
            if (currentSum == expected)
                return nums.get(left) + " " + nums.get(right);
            if (currentSum < expected) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return "None";
    }

    public static String dynamicSearch(List<Integer> nums, int expected) {
        Set<Integer> buffer = new HashSet<>(nums);
        for (int i = 0; i < nums.size() - 1; i++) {
            int target = expected - nums.get(i);
            if (buffer.contains(target)) {
                for (int secondNum : buffer) {
                    if (secondNum == target)
                        return nums.get(i) + " " + secondNum;
                }
            }
        }
        return "None";
    }

}
