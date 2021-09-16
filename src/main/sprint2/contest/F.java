package main.sprint2.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class F {

  private final LinkedList<Integer> linkedList = new LinkedList<>();
  private Integer max;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(bufferedReader.readLine());

    F f = new F();

    for (int i = 0; i < size; i++) {
      String line = bufferedReader.readLine();
      int separator = line.indexOf(" ");
      String substringed = line.substring(0, separator != -1 ? separator : line.length());

      switch (substringed) {
        case "push": {
          f.push(Integer.parseInt(line.substring(line.indexOf(" ")).trim()));
          break;
        }
        case "pop": {
          String poped = f.pop();
          if (poped.equals("error")) {
            System.out.println(poped);
          }
          break;
        }
        case "get_max": {
          System.out.println(f.getMax());
          break;
        }
      }
    }

    bufferedReader.close();

  }

  public String getMax() {
    return max != null ? String.valueOf(max) : "None";
  }

  public void push(int value) {
    if (max == null)
      max = value;
    else
      max = max < value ? value : max;

    linkedList.push(value);
  }

  public String pop() {
    try {
      int element = linkedList.pop();
      if (element == max) {
        max = null;
        recalculateMax();
      }
      return String.valueOf(element);
    } catch (NoSuchElementException ex) {
      return "error";
    }
  }

  private void recalculateMax() {
    for (Integer value : linkedList) {
      if (max == null) {
        max = value;
        continue;
      }
      max = max < value ? value : max;
    }
  }

}

