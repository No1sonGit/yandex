package main.sprint4.project.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Optional;

/**
 -- ПРИНЦИП РАБОТЫ --

 Принцип работы данного алгоритма заключается в реализации хеш таблицы с фиксированным размером
 массива под капотом (ибо по условию число хранимых в таблице ключей не превосходит 10^5 и не
 требуется реализация рехеширования и масштабирования таблицы)

 Разрешение коллизий происходит методом цепочек

 Вычисление номера корзины производится вычислением остатка от деления хеша (в нашем случае это
 сам числовой ключ) на длинну массива

 Принцип работы методов в хеш таблице:

 1. put key value —– добавление пары ключ-значение. Если заданный ключ уже есть в таблице, то
 соответствующее ему значение обновляется. Если в корзине возникает коллизия, то методом цепочек
 ищем подходящий ключ и обновляем его значение, иначе в конец цепочки добавляем новый узел

 get key –— получение значения по ключу. Если ключа нет в таблице, то выводим «None». Иначе вывести
 найденное значение. Если в корзине возникает коллизия, то методом цепочек ищем ключ по всем узлам,
 если не находим - выводим «None»

 delete key –— удаление ключа из таблицы. Если такого ключа нет, то вывести «None», иначе вывести
 хранимое по данному ключу значение и удалить ключ. Если в корзине возникает коллизия, то методом
 цепочек ищем узел по ключу, удаляем его, переставляем указатели (для этого нужно помнить предыдущий
 узел) и возврашаем значение, если нужного узла не находим - выводим «None»

 -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 Данный алгоритм работает корректно только в случае, если кол-во хранимых в таблице ключей не
 превосходит 10^5 и хранимые ключи являются числами

 -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 Временная сложность данного алгоритма составляет в среднем O(1) для всех операций
 В худшем случае - O(n)


 -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 Пространственная сложность данного алгоритма составляет O(n)

 */

//55626760
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
          Optional<Integer> result = map.get(key);
          output.append(result.isPresent() ? result.get() : "None").append("\n");
          break;
        }
        case "delete": {
          tokenizer.nextToken();
          int key = (int) tokenizer.nval;
          Optional<Integer> result = map.delete(key);
          output.append(result.isPresent() ? result.get() : "None").append("\n");
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

    Optional<Integer> get(int key) {
      int bucket = getBucket(key);
      Node head = values[bucket];

      if (head == null)
        return Optional.empty();
      if (head.next == null) {
        return head.key == key ? Optional.of(head.value) : Optional.empty();
      }

      Node curr = head;

      while (curr.next != null) {
        if (curr.key == key)
          return Optional.of(curr.value);
        curr = curr.next;
      }

      return curr.key == key ? Optional.of(curr.value) : Optional.empty();
    }

    Optional<Integer> delete(int key) {
      int bucket = getBucket(key);
      Node head = values[bucket];

      if (head == null)
        return Optional.empty();
      if (head.key == key && head.next == null) {
        int result = head.value;
        values[bucket] = null;
        return Optional.of(result);
      } else if (head.key != key && head.next == null) {
        return Optional.empty();
      } else if (head.key == key) {
        int result = head.value;
        values[bucket] = head.next;
        return Optional.of(result);
      }

      Node prev = head;
      Node curr = head.next;

      do {
        if (curr.key == key) {
          int result = curr.value;
          prev.next = curr.next;
          return Optional.of(result);
        }
        prev = curr;
        curr = curr.next;
      } while (curr.next != null);

      return Optional.empty();
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


