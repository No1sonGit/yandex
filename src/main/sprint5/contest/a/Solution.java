package main.sprint5.contest.a;

public class Solution {

  public static int treeSolution(Node head) {
    return findMax(head);
  }

  static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
      right = null;
      left = null;
    }
  }

  private static int findMax(Node root) {
    if (root == null)
      return Integer.MIN_VALUE;

    int result = root.value;
    int leftResult = treeSolution(root.left);
    int rightResult = treeSolution(root.right);

    if (leftResult > result)
      result = leftResult;
    if (rightResult > result)
      result = rightResult;

    return result;
  }

  private static void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(-5);
    Node node3 = new Node(3);
    node3.left = node1;
    node3.right = node2;
    Node node4 = new Node(2);
    node4.left = node3;
    assert treeSolution(node4) == 3;

  }

}
