package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(reader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    while (x != 0) {
      stringBuilder.append(x % 2);
      x /= 2;
    }

    System.out.println(stringBuilder.reverse());
  }

}
