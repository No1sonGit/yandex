package main.sprint5.contest.l;

public class Solution {

    public static int siftDown(int[] heap, int idx) {
        int left = idx * 2;
        int right = idx * 2 + 1;

        if (heap.length <= left)
            return idx;

        int largestIndex;

        if (right < heap.length && heap[left] < heap[right])
            largestIndex = right;
        else
            largestIndex = left;

        if (heap[idx] < heap[largestIndex]) {
            int temp = heap[idx];
            heap[idx] = heap[largestIndex];
            heap[largestIndex] = temp;
            return siftDown(heap, largestIndex);
        }

        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}