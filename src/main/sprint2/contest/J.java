package main.sprint2.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
  Node next;
  String value;

  public Node(Node next, String value) {
    this.next = next;
    this.value = value;
  }
}

public class J {

  private Node first;
  private int size = 0;

  int size() {
    return size;
  }

  void put(String value) {
    if (first == null) {
      first = new Node(null, value);
      size++;
      return;
    }
    Node next = first.next;
    if (next != null) {
      while (next.next != null) {
        next = next.next;
      }
      next.next = new Node(null, value);
    } else {
      first.next = new Node(null, value);
    }
    size++;
  }

  String get() {
    if (size == 0)
      return "error";
    String val = first.value;
    first = first.next;
    size--;
    return val;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(bufferedReader.readLine());

    J queue = new J();

    for (int i = 0; i < size; i++) {
      String line = bufferedReader.readLine();
      int separator = line.indexOf(" ");
      String substringed = line.substring(0, separator != -1 ? separator : line.length());

      switch (substringed) {
        case "put": {
          queue.put(line.substring(line.indexOf(" ")).trim());
          break;
        }
        case "get": {
            System.out.println(queue.get());
          break;
        }
        case "size": {
          System.out.println(queue.size());
          break;
        }
      }
    }

    bufferedReader.close();

  }

}
