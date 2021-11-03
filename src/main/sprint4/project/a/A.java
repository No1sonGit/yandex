package main.sprint4.project.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/**
 -- ПРИНЦИП РАБОТЫ --

 Принцип работы данного алгоритма заключается в использовании поискового индекса, который позволяет
 нам запоминать слова, в каких документах они встречались и в каком кол-ве.

 Структура поискового индекса следующая - Слово : <Номер документа : Число вхождений в этот документ>

 Далее, по этому поисковому индексу мы уже производим поиск слов из запроса, можем подсчитать их
 релевантность в каждом документе и вывести в необходимом нам порядке.

 Поиск производится по следующему принципу:
 1. Создаем уникальное множество поискового запроса (для исключения дублей)
 2. Создаем результирующий ассоциативный массив (где ключ - номер документа, значение - общее кол-во
    вхождений всех слов из текущего поискового запроса в поисковом индексе по текущему документу)
 3. Итерируемся по данному множеству
 4. Для каждого слова из множества производим поиск в поисковом индексе и результат складываем в
    результирующий массив
 5. По завершении 3 шага производим поиск максимума по результирующему массиву не более 5 раз
    и выводим результат

 -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 Данный алгоритм корректно работает, т.к. для поиска слов из запроса используется заранее построенный
 поисковый индекс по всем словам из всех документов

 -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 Временная сложность данного алгоритма составляет O(n * m)

 -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 Пространственная сложность данного алгоритма составляет O(n)
 n - кол-во уникальных слов в документах и кол-во вхождений в каждый документ

 */

//55659520
public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    Map<String, Map<Integer, Integer>> docs = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      while (st.hasMoreTokens()) {
        String word = st.nextToken();
        if (docs.containsKey(word)) {
          if (docs.get(word).containsKey(i)) {
            docs.get(word).put(i, docs.get(word).get(i) + 1);
          } else {
            docs.get(word).put(i, 1);
          }
        } else {
          Map<Integer, Integer> doc = new HashMap<>();
          doc.put(i, 1);
          docs.put(word, doc);
        }
      }
    }

    int m = Integer.parseInt(reader.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      Set<String> request = new HashSet<>();
      StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
      while (stringTokenizer.hasMoreTokens()) {
        request.add(stringTokenizer.nextToken());
      }
      int[] result = new int[n];

      for (String word : request) {
        if (docs.containsKey(word)) {
          for (Entry<Integer, Integer> entry : docs.get(word).entrySet()) {
            result[entry.getKey()] += entry.getValue();
          }
        }
      }

      for (int j = 0; j < (Math.min(result.length, 5)); j++) {
        int max = 0;
        int index = 0;

        for (int k = 0; k < result.length; k++) {
          if (result[k] > max) {
            max = result[k];
            index = k + 1;
          }
        }

        if (index == 0)
          break;

        result[index - 1] = 0;

        sb.append(index).append(" ");
      }

      sb.append("\n");
    }

    reader.close();
    System.out.println(sb);
  }

}
