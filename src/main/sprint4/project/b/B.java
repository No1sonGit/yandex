package main.sprint4.project.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class B {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int size = (int) tokenizer.nval;

    MyIntMap map = new MyIntMap();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < size; i++) {
      tokenizer.nextToken();
      String param = tokenizer.sval;

      switch (param) {
        case "put": {
          tokenizer.nextToken();
          int key = (int) tokenizer.nval;
          tokenizer.nextToken();
          int value = (int) tokenizer.nval;
          map.put(key, value);
          break;
        }
        case "get": {
          tokenizer.nextToken();
          int key = (int) tokenizer.nval;
          int result = map.get(key);
          output.append(result == -1 ? "None" : result).append("\n");
          break;
        }
        case "delete": {
          tokenizer.nextToken();
          int key = (int) tokenizer.nval;
          int result = map.delete(key);
          output.append(result == -1 ? "None" : result).append("\n");
          break;
        }
        default:
          System.out.println("Hmmm... something went wrong here =/");
      }
    }

    System.out.println(output);
  }

  static class MyIntMap {
    Node[] values = new Node[100001];

    void put(int key, int value) {
      int bucket = getBucket(key);
      if (values[bucket] == null) {
        values[bucket] = new Node(key, value);
      } else {
        Node curr = values[bucket];

        if (curr.next == null && curr.key == key) {
          curr.value = value;
          return;
        }

        while(curr.next != null) {
          if (curr.key == key) {
            curr.value = value;
            return;
          }
          curr = curr.next;
        }

        if (curr.key == key) {
          curr.value = value;
          return;
        }
        curr.next = new Node(key, value);
      }
    }

    int get(int key) {
      int bucket = getBucket(key);
      Node head = values[bucket];

      if (head == null)
        return -1;
      if (head.next == null) {
        return head.key == key ? head.value : -1;
      }

      Node curr = head;

      while (curr.next != null) {
        if (curr.key == key)
          return curr.value;
        curr = curr.next;
      }

      return curr.key == key ? curr.value : -1;
    }

    int delete(int key) {
      int bucket = getBucket(key);
      Node head = values[bucket];

      if (head == null)
        return -1;
      if (head.key == key && head.next == null) {
        int result = head.value;
        values[bucket] = null;
        return result;
      } else if (head.key != key && head.next == null) {
        return -1;
      } else if (head.key == key) {
        int result = head.value;
        values[bucket] = head.next;
        return result;
      }

      Node prev = head;
      Node curr = head.next;

      do {
        if (curr.key == key) {
          int result = curr.value;
          prev.next = curr.next;
          return result;
        }
        prev = curr;
        curr = curr.next;
      } while (curr.next != null);

      return -1;
    }

    int getBucket(int hash) {
      return hash % values.length;
    }
  }

  static class Node {
    final int key;
    int value;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

}


