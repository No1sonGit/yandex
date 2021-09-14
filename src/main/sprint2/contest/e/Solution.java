package main.sprint2.contest.e;

import java.util.LinkedList;
import main.sprint1.contest.L;

class Node<V> {
    public V value;  
    public Node<V> next;  
    public Node<V> prev;  
 
    public Node(V value, Node<V> next, Node<V> prev) {  
        this.value = value;  
        this.next = next;  
        this.prev = prev;  
    }  
}


public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static Node<String> solution(Node<String> head) {
        Node<String> prevNode = head;
        Node<String> nextNode = head.next;

        head.next = null;
        head.prev = nextNode;
        head = nextNode;

        while (head.next != null) {
            head.prev = head.next;
            head.next = prevNode;
            prevNode = head;
            head = head.prev;
        }

        head.next = prevNode;

        return head;
    }

    public static void print(Node<String> head) {
        String next = head.next != null ? head.next.value : "null";
        String prev = head.prev != null ? head.prev.value : "null";
        System.out.println(head.value + ".next == " + next);
        System.out.println(head.value + ".prev == " + prev);
        if (head.next.prev != null)
            print(head.next);
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        Node<String> newNode = solution(node0);
        print(newNode);
        /*
        result is : newNode == node3
        node3.next == node2
        node2.next == node1
        node2.prev == node3
        node1.next == node0
        node1.prev == node2
        node0.prev == node1
        */
    }
}
