package main.sprint3.project.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

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

  private static void quickSort(Participant[] arr, int leftBorder, int  rightBorder) {
    int leftMarker = leftBorder;
    int rightMarker = rightBorder;
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

    if (leftMarker < rightBorder)
      quickSort(arr, leftMarker, rightBorder);
    if (leftBorder < rightMarker)
      quickSort(arr, leftBorder, rightMarker);

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
      if (this.tasks > o.tasks)
        return -1;
      if (this.tasks < o.tasks)
        return 1;
      if (this.penalty < o.penalty)
        return -1;
      if (this.penalty > o.penalty)
        return 1;
      return Integer.compare(this.login.compareTo(o.login), 0);
    }
  }

}
