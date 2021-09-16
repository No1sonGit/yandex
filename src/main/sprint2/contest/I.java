package main.sprint2.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {

  int maxSize;
  int currSize;
  int head;
  int tail;
  String[] queue;

  I(int maxSize) {
    this.maxSize = maxSize;
    currSize = 0;
    head = 0;
    tail = 0;
    queue = new String[maxSize];
  }

  boolean isEmpty() {
    return currSize == 0;
  }

  String push(String value) {
    if (currSize != maxSize) {
      queue[tail] = value;
      tail = (tail + 1) % maxSize;
      currSize++;
      return value;
    }
    return "error";
  }

  String pop() {
    if (isEmpty())
      return "None";
    String result = queue[head];
    queue[head] = null;
    head = (head + 1) % maxSize;
    currSize--;
    return result;
  }

  String peek() {
    if (isEmpty())
      return "None";
    return queue[head];
  }

  int size() {
    return currSize;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int cycle = Integer.parseInt(bufferedReader.readLine());
    int size = Integer.parseInt(bufferedReader.readLine());
    I queue = new I(size);

    for (int i = 0; i < cycle; i++) {
      String line = bufferedReader.readLine();
      int separator = line.indexOf(" ");
      String substringed = line.substring(0, separator != -1 ? separator : line.length());

      switch (substringed) {
        case "push": {
          if (queue.push(line.substring(line.indexOf(" ") + 1)).equals("error")) {
            System.out.println("error");
          }
          break;
        }
        case "pop": {
          System.out.println(queue.pop());
          break;
        }
        case "peek": {
          System.out.println(queue.peek());
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
