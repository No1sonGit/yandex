package main.sprint2.contest.d;

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

    public static int solution(Node<String> head, String elem) {
        int counter = 0;

        if (head.value.equals(elem))
            return counter;

        while (true) {
            if (head.next == null)
                return -1;
            head = head.next;
            if (head.value.equals(elem))
                return ++counter;
            counter++;
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        System.out.println(idx);
        // result is : idx == 2
    }
}
