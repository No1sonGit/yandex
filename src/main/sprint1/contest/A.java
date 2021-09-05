package main.sprint1.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Вася делает тест по математике: вычисляет значение функций в различных точках.
 * Стоит отличная погода, и друзья зовут Васю гулять.
 * Но мальчик решил сначала закончить тест и только после этого идти к друзьям.
 * К сожалению, Вася пока не умеет программировать. Зато вы умеете.
 * Помогите Васе написать код функции, вычисляющей y = ax2 + bx + c.
 * Напишите программу, которая будет по коэффициентам a, b, c и числу x выводить значение функции в точке x.
 */
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(a * (x * x) + b * x + c);
    }

}
