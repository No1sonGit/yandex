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

    int begin = clumbs[0].getX();
    int end = 0;

    for (int i = 1; i < clumbs.length; i++) {
      begin = Math.min(begin, clumbs[i - 1].getX());
      end = Math.max(end, clumbs[i - 1].getY());
      if (clumbs[i].getX() > end) {
        System.out.println(begin + " " + end);
        if (i != clumbs.length - 1) {
          begin = clumbs[i].getY();
        } else {
          begin = clumbs[i].getX();
          end = clumbs[i].getY();
        }
      }
    }

    end = Math.max(end, clumbs[clumbs.length - 1].getY());
    System.out.println(begin + " " + end);

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
      if (x != o.x)
        return x - o.x;
      if (y != o.y)
        return o.y - y;
      return 0;
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
