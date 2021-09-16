package main.sprint2.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class G {

  private final LinkedList<Integer> linkedList = new LinkedList<>();
  private Integer max;
  private final List<Integer> listOfMax = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(bufferedReader.readLine());

    G f = new G();

    for (int i = 0; i < size; i++) {
      String line = bufferedReader.readLine();
      int separator = line.indexOf(" ");
      String substringed = line.substring(0, separator != -1 ? separator : line.length());

      switch (substringed) {
        case "push": {
          f.push(Integer.parseInt(line.substring(line.indexOf(" ") + 1)));
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
    if (max == null) {
      max = value;
      listOfMax.add(max);
    } else {
      if (max <= value) {
        max = value;
        listOfMax.add(max);
      }
    }

    linkedList.push(value);
  }

  public String pop() {
    try {
      Integer element = linkedList.pop();
      if (Objects.equals(element, max)) {
        if (!listOfMax.isEmpty())
          listOfMax.remove(listOfMax.size() - 1);
        recalculateMax();
      }
      return String.valueOf(element);
    } catch (NoSuchElementException ex) {
      return "error";
    }
  }

  private void recalculateMax() {
    max = !listOfMax.isEmpty() ? listOfMax.get(listOfMax.size() - 1) : null;
  }

}
