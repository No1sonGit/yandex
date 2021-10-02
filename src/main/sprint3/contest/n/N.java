package main.sprint3.contest.n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Objects;

public class N {

  public static void main(String[] args) throws IOException {
    StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    streamTokenizer.nextToken();
    int size = (int) streamTokenizer.nval;
    Coordinates[] clumbs = new Coordinates[size];
    for (int i = 0; i < size; i++) {
      streamTokenizer.nextToken();
      int x = (int) streamTokenizer.nval;
      streamTokenizer.nextToken();
      int y = (int) streamTokenizer.nval;
      clumbs[i] = new Coordinates(x, y);
    }

    Arrays.sort(clumbs);

    System.out.println(Arrays.toString(clumbs));

    StringBuilder stringBuilder = new StringBuilder();

    int oldBegin = clumbs[0].getX();
    int oldEnd = clumbs[0].getY();

    stringBuilder.append("\n").append(oldBegin).append(" ");

    for (int i = 1; i < clumbs.length; i++) {
      int newBegin = clumbs[i - 1].getX();
      int newEnd = clumbs[i].getY();

      if (newBegin >= oldEnd) {
        stringBuilder.append(oldEnd).append("\n").append(newBegin).append(" ");
      }

    }

    System.out.println(stringBuilder);

  }

  private static class Coordinates implements Comparable<Coordinates> {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public int compareTo(Coordinates o) {
      return Integer.compare(this.x + this.y, o.x + o.y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Coordinates that = (Coordinates) o;
      return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "Coordinates{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }

}
