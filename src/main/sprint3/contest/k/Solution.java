package main.sprint3.contest.k;

import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {
		int[] result = new int[right - left];
		int i = left;
		int j = mid;

		int counter = 0;

		while (i < mid && j < right) {
			if (arr[i] < arr[j]) {
				result[counter++] = arr[i];
				i++;
			} else {
				result[counter++] = arr[j];
				j++;
			}
		}

		while (i < mid) {
			result[counter++] = arr[i];
			i++;
		}

		while (j < right) {
			result[counter++] = arr[j];
			j++;
		}

		return result;
	}

	public static void merge_sort(int[] arr, int left, int right) {
		if (right - left <= 1)
			return;

		int mid = (left + right) / 2;
		merge_sort(arr, left, mid);
		merge_sort(arr, mid, right);
		int[] res = merge(arr, left, mid, right);
		if (right - left >= 0)
			System.arraycopy(res, 0, arr, left, right - left);
	}

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 2, 10, 11};
		int[] b = merge(a, 0, 3, 6);
		int[] expected = {1, 2, 4, 9, 10, 11};
		assert Arrays.equals(b, expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert Arrays.equals(c, expected2);
//		System.out.println(Arrays.equals(c, expected2));
	}
}