package main.sprint7.contest.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Objects;

public class B {

  public static void main(String[] args) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tokenizer.nextToken();
    int n = (int) tokenizer.nval;
    Lesson[] lessons = new Lesson[n];

    for (int i = 0; i < n; i++) {
      tokenizer.nextToken();
      double start = tokenizer.nval;
      tokenizer.nextToken();
      double end = tokenizer.nval;

      lessons[i] = new Lesson(start, end);
    }


    Arrays.sort(lessons);

    int count = 1;
    Lesson lesson = lessons[0];
    StringBuilder result = new StringBuilder();

    appendResult(lesson, result);

    for (int i = 1; i < lessons.length; i++) {
      if (lessons[i].getStart() >= lesson.getEnd() && lessons[i].getEnd() >= lesson.getEnd()) {
        count++;
        lesson = lessons[i];

        appendResult(lesson, result);
      }
    }

    System.out.println(count);
    System.out.println(result);
  }

  private static void appendResult(Lesson lesson, StringBuilder result) {
    if (isDouble(lesson.getStart())) {
      result.append(lesson.getStart()).append(" ");
    } else {
      result.append(lesson.getStart().intValue()).append(" ");
    }

    if (isDouble(lesson.getEnd())) {
      result.append(lesson.getEnd()).append(" ");
    } else {
      result.append(lesson.getEnd().intValue()).append(" ");
    }

    result.append("\n");
  }

  private static boolean isDouble(Double num) {
    String[] split = num.toString().split("\\.");

    return Integer.parseInt(split[1]) > 0;
  }

  private static class Lesson implements Comparable<Lesson> {
    Double start;
    Double end;

    public Lesson(double start, double end) {
      this.start = start;
      this.end = end;
    }

    public Double getStart() {
      return start;
    }

    public Double getEnd() {
      return end;
    }

    @Override
    public int compareTo(Lesson o) {
      if (!Objects.equals(this.end, o.getEnd())) {
        return this.end.compareTo(o.getEnd());
      } else {
        return this.start.compareTo(o.getStart());
      }
    }

    @Override
    public String toString() {
      return "Lesson{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

}
