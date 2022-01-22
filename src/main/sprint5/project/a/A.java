package main.sprint5.project.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 -- ПРИНЦИП РАБОТЫ --

 Принцип работы данного алгоритма заключается в использовании свойств такой структуры данных, как
 куча (приоритетная очереди)

 Т.к. на вершине кучи всегда находится наибольший (max heap), либо наименьший (min heap) по приоритету
 элемент, то мы можем использовать это свойство для сортировки практически любых данных.

 Нам нужно будет всего лишь добавить все элементы в кучу, а затем извлечь их
 В итоге мы получим все элементы в отсортированном порядке

 Общий алгоритм такой:
 1. Создадим пустую бинарную неубывающую кучу (min-heap).
 2. Вставим в неё по одному все элементы массива, сохраняя свойства кучи.
    Так как нам нужна сортировка от меньшего к большему, на вершине пирамиды должен оказаться самый
    маленький элемент. Если бы мы захотели реализовать сортировку по убыванию — на вершине был бы
    самый большой элемент.
 3. Будем извлекать из неё наиболее приоритетные элементы (с самым маленьким значением), удаляя их из кучи.

 -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 Данный алгоритм корректно работает, т.к. мы используем свойства кучи в качестве гаранитии, что
 мы получаем из нее самый приоритетный элемент

 Для восстановление свойств кучи, при вставке, используется алгоритм просеивания вверх, а при удалении
 выполняется алгоритм просеивания вниз

 -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 Временная сложность данного алгоритма составляет O(nlogN)

 -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 Пространственная сложность данного алгоритма составляет O(1)
 */

//63754814
public class A {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;

    Heap heap = new Heap(n);

    for (int i = 0; i < n; i++) {
      Participant participant = new Participant();
      tokenizer.nextToken();
      participant.setName(tokenizer.sval);
      tokenizer.nextToken();
      participant.setSolvedTasks((int) tokenizer.nval);
      tokenizer.nextToken();
      participant.setPenalty((int) tokenizer.nval);

      heap.add(participant);
    }

    for (int i = 0; i < n; i++) {
      Participant result = heap.pop();
      if (result != null)
        System.out.println(result.name);
    }

  }

  public static class Heap {

    private final Participant[] participants;
    private int size;

    public Heap(int size) {
      this.participants = new Participant[size + 1];
      this.size = 0;
    }

    public void add(Participant participant) {
      participants[size + 1] = participant;
      size++;
      siftUp(size);
    }

    public void siftUp(int idx) {
      if (idx == 1)
        return;

      int curr = idx;
      int parentIndex = curr / 2;

      while (parentIndex != 0) {
        if (participants[parentIndex] == null || participants[parentIndex].isLess(participants[curr])) {
          swap(curr, parentIndex);
        }

        curr = parentIndex;
        parentIndex = parentIndex / 2;
      }

    }

    public Participant pop() {
      Participant result = participants[1];
      participants[1] = participants[size];
      participants[size] = null;
      size--;
      siftDown();
      return result;
    }

    private void siftDown() {
      int left = 2;
      int right = left + 1;

      int curr = 1;
      int largestIndex;

      while (size >= left) {
        if (right <= size && participants[left].isLess(participants[right]))
          largestIndex = right;
        else
          largestIndex = left;

        if (participants[curr].isLess(participants[largestIndex])) {
          swap(curr, largestIndex);
        }

        curr = largestIndex;
        left = curr * 2;
        right = left + 1;
      }

    }

    private void swap(int idx, int parentIndex) {
      Participant temp = participants[idx];
      participants[idx] = participants[parentIndex];
      participants[parentIndex] = temp;
    }

  }

  public static class Participant implements Comparable<Participant> {

    private String name;
    private int solvedTasks;
    private int penalty;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getSolvedTasks() {
      return solvedTasks;
    }

    public void setSolvedTasks(int solvedTasks) {
      this.solvedTasks = solvedTasks;
    }

    public int getPenalty() {
      return penalty;
    }

    public void setPenalty(int penalty) {
      this.penalty = penalty;
    }

    public boolean isLess(Participant participant) {
      return this.compareTo(participant) < 0;
    }

    @Override
    public int compareTo(Participant o) {
      if (this.getSolvedTasks() != o.getSolvedTasks())
        return this.getSolvedTasks() - o.getSolvedTasks();
      else if (this.getPenalty() != o.getPenalty())
        return o.getPenalty() - this.getPenalty();
      else
        return o.getName().compareTo(this.getName());
    }

  }

}


