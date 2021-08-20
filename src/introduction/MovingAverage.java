package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovingAverage {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int seconds = Integer.parseInt(bufferedReader.readLine());
        List<Integer> timeSeries = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //окно сглаживания
        int k = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += timeSeries.get(i);
        }
        result.append(currentSum / (float) k).append(" ");
        for (int i = 0; i < seconds - k; i++) {
            currentSum -= timeSeries.get(i);
            currentSum += timeSeries.get(i + k);
            result.append(currentSum / (float) k).append(" ");
        }
        System.out.println(result);
    }
}
