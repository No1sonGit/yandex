package main.sprint2.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//53506290
public class B {

  /**
   -- ПРИНЦИП РАБОТЫ --
   Для вычисления значения выражения, записанного в обратной польской нотации, нужно считывать
   выражение слева направо и придерживаться следующих шагов:

   Обработка входного символа:
   Если на вход подан операнд, он помещается на вершину стека.
   Если на вход подан знак операции, то эта операция выполняется над требуемым количеством значений,
   взятых из стека в порядке добавления. Результат выполненной операции помещается на вершину стека.
   Если входной набор символов обработан не полностью, перейти к шагу 1.
   После полной обработки входного набора символов результат вычисления выражения находится в вершине стека.
   Если в стеке осталось несколько чисел, то надо вывести только верхний элемент.

   Такая же логика и для хвостового стека, в случае, если там нет элементов, но есть в головном

   -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
   Использования стека в данном случае дает нам возможность добавление операндов в нужном нам
   естественном порядке, чтобы в будущем проводить над ними операции вычисления и добавлять полученный
   результат на вершину стека.

   По итогу, после прохода всех элементов в массиве, мы получаем готовый результат вычисления всего
   выражения на вершине стека (это и будет наш ответ)

   -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
   Добавление в стек стоит O(1).
   Извлечение из стека также стоит О(1)
   Операции вычисления между операндами - также стоит О(1)
   При получении строки, мы разбиваем ее на массив символов
   Нам необходимо обойти весь массив целиком и провести операции с каждым элементом (поместить операнд
   в стек, либо же произвести некие вычисления, извлекая элементы из стека)
   В таком случае, сложность составит О(n)

   -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
   При обходе в цикле массива - по мере необходимости мы дополнительно помещаем элементы в стек.
   Знаки операции в стек не помещается - пусть они будут k
   В итоге, пространственная сложность составит О(n - k)

   **/

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] values = bufferedReader.readLine().split(" ");
    bufferedReader.close();

    Stack<Integer> stack = new Stack<>();

    for (String value : values) {
      switch (value) {
        case "+": {
          int first = stack.pop();
          int second = stack.pop();
          stack.push(second + first);
          break;
        }
        case "-": {
          int first = stack.pop();
          int second = stack.pop();
          stack.push(second - first);
          break;
        }
        case "*": {
          int first = stack.pop();
          int second = stack.pop();
          stack.push(second * first);
          break;
        }
        case "/": {
          int first = stack.pop();
          int second = stack.pop();
          int result = Math.floorDiv(second, first);
          stack.push(result);
          break;
        }
        default:
          stack.push(Integer.parseInt(value));
      }
    }

    System.out.println(stack.pop());

  }

}
