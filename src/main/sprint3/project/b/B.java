package main.sprint3.project.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 -- ПРИНЦИП РАБОТЫ --

 Принцип работы данного алгоритма заключается в использовании in-place быстрой сортировки, не
 требующей использования дополнительной памяти.

 Для сортировки массива будем использовать метод двух указателей

 Для входного массива выставляем два маркера, левый и правый. При первом вызове они
 соответствуют началу и концу массива.

 Далее определяется опорный элемент, он же pivot. После этого наша задача — переместить значения,
 меньшие чем pivot, в левую от pivot часть, а большие — в правую.

 Для этого сначала двигаем указатель L, пока не найдём значение, большее чем pivot.
 Если меньше значения не нашли, то L совпадёт с pivot.
 Потом двигаем указатель R пока не найдём меньшее, чем pivot значение.
 Если меньшее значение не нашли, то R совпадёт с pivot.

 Далее, если указатель L находится до указателя R или совпадает с ним, то пытаемся
 выполнить обмен элементов, если элемент L меньше, чем R.

 Далее L сдвигаем вправо на 1 позицию, R сдвигаем влево на одну позицию.
 Когда левый маркер L окажется за правым маркером R это будет означать, что обмен закончен,
 слева от pivot меньшие значения, справа от pivot — большие значения.

 После этого рекурсивно вызываем такую же сортировку для участков массива от начала сортируемого
 участка до правого маркера и от левого маркера до конца сортируемого участка.

 Также, для элементов (в нашем случае - это участники) определяем компаратор, по которому будет
 идти сравнение участников

 -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

 Алгорим корректен, потому что в каждом рекурсивном вызове в подмассивах выполняется обмен между
 элементами, сравниваемые с опорным, и по итогу мы получаем отсортированный массив.

 -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 Амортизированная временная сложность данного алгоритма составляет O(nlogn)
 В худшем случае - O(n^2)

 -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 Пространственная сложность данного алгоритма составляет O(logn)
 Дополнительная память использовуется только для рекурсивных вызовов (память стека)
 */

//53911113
public class B {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;
    Participant[] participants = new Participant[size];

    for (int i = 0; i < participants.length; i++) {
      streamTokenizer.nextToken();
      String login = streamTokenizer.sval;

      streamTokenizer.nextToken();
      int tasks = (int) streamTokenizer.nval;

      streamTokenizer.nextToken();
      int penalty = (int) streamTokenizer.nval;

      participants[i] = new Participant(login, tasks, penalty);
    }

    quickSort(participants, 0, participants.length - 1);

    for (Participant participant : participants) {
      System.out.println(participant.login);
    }

  }

  private static void quickSort(Participant[] arr, int left, int  right) {
    int leftMarker = left;
    int rightMarker = right;
    Participant pivot = arr[(leftMarker + rightMarker) / 2];

    while(leftMarker <= rightMarker) {

      while (arr[leftMarker].compareTo(pivot) < 0)
        leftMarker++;
      while (arr[rightMarker].compareTo(pivot) > 0)
        rightMarker--;

      if (leftMarker <= rightMarker) {
        if (leftMarker < rightMarker)
          swap(arr, leftMarker, rightMarker);
        leftMarker++;
        rightMarker--;
      }

    }

    if (leftMarker < right)
      quickSort(arr, leftMarker, right);
    if (left < rightMarker)
      quickSort(arr, left, rightMarker);

  }

  private static void swap(Participant[] arr, int left, int right) {
    Participant tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;

  }

  static class Participant implements Comparable<Participant> {
    private final String login;
    private final int tasks;
    private final int penalty;

    public Participant(String login, int tasks, int penalty) {
      this.login = login;
      this.tasks = tasks;
      this.penalty = penalty;
    }

    @Override
    public int compareTo(Participant o) {
      if (this.tasks != o.tasks)
        return o.tasks - this.tasks;
      if (this.penalty != o.penalty)
        return this.penalty - o.penalty;
      return this.login.compareTo(o.login);
    }
  }

}
