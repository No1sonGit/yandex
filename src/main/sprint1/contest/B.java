package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Алла придумала такую онлайн-игру: игрок нажимает на кнопку, и на экране появляются три случайных числа.
 * Если все три числа оказываются одной чётности, игрок выигрывает.
 * Напишите программу, которая по трём числам определяет, выиграл игрок или нет.
 */
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        int a = Math.abs(Integer.parseInt(stringTokenizer.nextToken()) % 2);
        int b = Math.abs(Integer.parseInt(stringTokenizer.nextToken()) % 2);
        int c = Math.abs(Integer.parseInt(stringTokenizer.nextToken()) % 2);
        if (a == b && a == c)
            System.out.println("WIN");
        else
            System.out.println("FAIL");
    }

}
