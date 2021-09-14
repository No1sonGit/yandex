package main.sprint1.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

  //52731318

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(reader.readLine()) * 2;
    int[] buffer = new int[10];

    for (int i = 0; i < 4; i++) {
      String line = reader.readLine();
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) != '.')
          buffer[line.charAt(j) - '0'] += 1;
      }
    }

    int result = 0;
    for (Integer num : buffer) {
      if (num <= k && num != 0) {
        result++;
      }
    }

    System.out.println(result);
  }

}
