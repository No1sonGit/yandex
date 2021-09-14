package main.sprint2.contest.c;

class Node<V> {  
    public V value;  
    public Node<V> next;  
 
    public Node(V value, Node<V> next) {  
        this.value = value;  
        this.next = next;  
    }  
}


public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            head = head.next;
            return head;
        }
        Node<String> prevNode = getNodeByIndex(head, idx - 1);
        prevNode.next = getNodeByIndex(head, idx + 1);
        return head;
    }

    private static <V> Node<V> getNodeByIndex(Node<V> node, int idx) {
        int counter = 0;
        while (counter != idx) {
            counter++;
            if (node.next == null)
                return null;
            node = node.next;
        }
        return node;
    }

    public static void print(Node<String> head) {
        System.out.println(head.value);
        if (head.next != null)
            print(head.next);
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 0);
        print(newHead);
        // result is : node0 -> node2 -> node3
    }
}
