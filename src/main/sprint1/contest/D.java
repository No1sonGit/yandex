package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.parseInt(bufferedReader.readLine());
    String[] words = bufferedReader.readLine().split(" ");
    bufferedReader.close();
    int maxLength = 0;
    int wordIndex = 0;
    int wordsL = words.length;
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() > maxLength) {
        maxLength = words[i].length();
        wordIndex = i;
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(words[wordIndex]).append("\n").append(maxLength);
    System.out.println(stringBuilder);
  }

}
