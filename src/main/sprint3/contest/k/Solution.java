package main.sprint3.contest.k;

import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {
		int[] result = new int[arr.length];



		return new int[0];
	}

	public static void merge_sort(int[] arr, int left, int right) {


	}

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 2, 10, 11};
		int[] b = merge(a, 0, 3, 6);
		int[] expected = {1, 2, 4, 9, 10, 11};
		assert Arrays.equals(b, expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert c.equals(expected2);
	}
}