package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class J {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long x = Long.parseLong(reader.readLine());
    PrintWriter printWriter = new PrintWriter(System.out);
    reader.close();

    for (int i = 2; i <= Math.sqrt(x); i++) {
      while (x % i == 0) {
        printWriter.print(i + " ");
        x /= i;
      }
    }

    if (x != 1)
      printWriter.print(x);

    printWriter.flush();
  }

}
