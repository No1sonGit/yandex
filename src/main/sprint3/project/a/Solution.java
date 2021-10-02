package main.sprint3.project.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {

    public static int brokenSearch(int[] arr, int k) {
        if (arr.length == 1)
            return arr[0] == k ? 0 : -1;

        if (arr.length == 2) {
            if (arr[0] == k)
                return 0;
            if (arr[arr.length - 1] == k)
                return arr.length - 1;
            return  -1;
        } else {
            if (arr[0] == k)
                return 0;
            if (arr[arr.length - 1] == k)
                return arr.length - 1;
        }

        int pivot = findPivot(arr, 0, arr.length - 1);

        if (pivot == -1)
            return binarySearch(arr, k, 0, arr.length - 1);
        if (arr[pivot] == k)
            return pivot;
        if (arr[0] <= k)
            return binarySearch(arr, k, 0, pivot - 1);
        return binarySearch(arr, k, pivot + 1, arr.length - 1);
    }

    private static void test() {
        int[] arr = {1, 5};
        int result = brokenSearch(arr, 2);
        System.out.println(result);
    }

    static int findPivot(int[] arr, int left, int right) {
        if (right < left)
            return -1;
        if (right == left)
            return left;

        int mid = (left + right) / 2;

        if (arr[mid] > arr[mid + 1])
            return mid;
        if (arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[left] >= arr[mid])
            return findPivot(arr, left, mid - 1);

        return findPivot(arr, mid + 1, right);
    }

    private static int binarySearch(int[] arr, int k, int left, int right) {
        if (right <= left)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == k)
            return mid;

        if (k < arr[mid])
            return binarySearch(arr, k, left, mid);
        else
            return binarySearch(arr, k, mid + 1, right);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        streamTokenizer.nextToken();
        int size = (int) streamTokenizer.nval;
        streamTokenizer.nextToken();
        int k = (int) streamTokenizer.nval;

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            streamTokenizer.nextToken();
            nums[i] = (int) streamTokenizer.nval;
        }

        System.out.println(brokenSearch(nums, k));

    }
}
