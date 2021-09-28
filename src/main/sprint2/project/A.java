package main.sprint2.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

//53573758
public class A {

  /**
   -- ПРИНЦИП РАБОТЫ --
   Для реализации дека с фиксированным размером будем использовать кольцевой буфер.

   Кольцевой буфер - это массив фиксированного размера, но при этом его логика в том, что как будто бы
   после последнего элемента сразу же снова идет первый.

   Для реализации дека с использованием кольцевого буфера нам нужно завести 2 указателя, указывающие
   на головную и хвостовую часть массива, а также заведем счетчик текущего кол-ва элементов в массиве
   Все операции будут производиться с использованием двух указателей.

   Создаем массив фиксированного размера, инициализируем указатели в позициях 0

   При добавлении элемента в начало, либо в конец - делаем проверку на заполненность массива

   При вставке в начало - сначала двигаем указатель с помощью модульной арифметики
   Вставляем элемент в текущую позицию указателя

   При вставке в конец - сначала добавляем элемент в текущую позицию, затем сдвигаем указатель с
   помощью модульной арифметики
   Также увеличиваем счетчик

   При извлечении из головы дека - делаем проверку на пустоту, затем извлекаем элемент и двигаем
   указатель, уменьшаем счетчик и возвращаем элемент

   При извлечемии из хвоста дека - делаем проверку на пустоту, но в этот раз сначала двигаем указатель
   назад (потому что текущий указатель указывает на пустую ячейка в массиве), затем извлекаем
   элемент и уменьшаем счетчик

   Модульная арифметика как раз таки нужна для обеспечания закольцованности буфера, чтобы не выйти
   за пределы массива

   -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
   Использование кольцевого буфера фиксированного размера дает нам возможность как добавлять, так
   и извлекать элементы с начала и с конца, а неиспользуемые более элементы - перезаписываются новыми.
   Единственный недостаток - фиксированный размер буфера, соответственно и дека.

   -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
   Временная сложность данного алгоритма - О(1), т.к. все проводимые операции
   при добавление и извлечении элементов выполняются за О(1)


   -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
   Пространственная сложность - О(1), т.к. у нас имеется один массив фиксированный длины,
   в который добавляются элементы.
   Дополнительную память мы не используем.

  */

  static final String ERROR = "error";

  public static class Deq {
    private int size;
    private int head;
    private int tail;
    private final Integer[] elements;

    Deq(final int maxSize) {
      this.size = 0;
      this.head = 0;
      this.tail = 0;
      this.elements = new Integer[maxSize];
    }

    public boolean pushBack(final Integer value) {
      if (isFull())
        return false;
      elements[tail] = value;
      tail = (tail + 1) % elements.length;
      size++;
      return true;
    }

    public boolean pushFront(final Integer value) {
      if (isFull())
        return false;
      head = (head - 1 + elements.length) % elements.length;
      elements[head] = value;
      size++;
      return true;
    }

    public Optional<Integer> popFront() {
      if (isEmpty())
        return Optional.empty();
      int result = elements[head];
      head = (head + 1) % elements.length;
      size--;
      return Optional.of(result);
    }

    public Optional<Integer> popBack() {
      if (isEmpty())
        return Optional.empty();
      tail = (tail - 1 + elements.length) % elements.length;
      size--;
      return Optional.of(elements[tail]);
    }

    private boolean isEmpty() {
      return size == 0;
    }

    private boolean isFull() {
      return size == elements.length;
    }

  }


  public static void main(String[] args) throws IOException {
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final int lines = Integer.parseInt(bufferedReader.readLine());
    final int size = Integer.parseInt(bufferedReader.readLine());

    final Deq deq = new Deq(size);

    for (int i = 0; i < lines; i++) {
      final String line = bufferedReader.readLine();
      final int separator = line.indexOf(" ");
      final String substring = line.substring(0, separator != -1 ? separator : line.length());

      switch (substring) {
        case "push_back": {
          final boolean isPushed = deq.pushBack(Integer.parseInt(line.substring(line.indexOf(" ")).trim()));
          if (!isPushed)
            System.out.println(ERROR);
          break;
        }
        case "push_front": {
          final boolean isPushed = deq.pushFront(Integer.parseInt(line.substring(line.indexOf(" ")).trim()));
          if (!isPushed)
            System.out.println(ERROR);
          break;
        }
        case "pop_back": {
          final Optional<Integer> result = deq.popBack();
          if (result.isPresent())
            System.out.println(result.get());
          else
            System.out.println(ERROR);
          break;
        }
        case "pop_front": {
          final Optional<Integer> result = deq.popFront();
          if (result.isPresent())
            System.out.println(result.get());
          else
            System.out.println(ERROR);
          break;
        }
      }
    }

    bufferedReader.close();
  }

}
