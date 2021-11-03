package main.sprint5.contest.e;

import java.util.Stack;

public class Solution {

  public static boolean treeSolution(Node head) {
    return isBstRecursive(head, null, null);
  }

  private static boolean isBstIterative(Node head) {
    Stack<Node> stack = new Stack<>();

    Node prev = null;

    while (!stack.empty() || head != null) {

      while (head != null) {
        stack.add(head);
        head = head.left;
      }

      head = stack.peek();
      stack.pop();

      if (prev != null && head.value <= prev.value)
        return false;

      prev = head;
      head = head.right;
    }

    return true;
  }

  private static boolean isBstRecursive(Node root, Node left, Node right) {
    if (root == null)
      return true;

    if (left != null && root.value <= left.value)
      return false;

    if (right != null && root.value >= right.value)
      return false;

    return isBstRecursive(root.left, left, root) && isBstRecursive(root.right, root, right);
  }


  private static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }


  private static void test() {
    Node node1 = new Node(1, null, null);
    Node node2 = new Node(4, null, null);
    Node node3 = new Node(3, node1, node2);
    Node node4 = new Node(8, null, null);
    Node node5 = new Node(5, node3, node4);
    assert treeSolution(node5);
    System.out.println(treeSolution(node5));
    node2.value = 5;
    assert !treeSolution(node5);
    System.out.println(!treeSolution(node5));
  }

  public static void main(String[] args) {
    test();
  }
}

