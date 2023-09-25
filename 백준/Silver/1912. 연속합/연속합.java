

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(N);
        List<Integer> numbers = Arrays.stream(str).map(Integer::parseInt).collect(Collectors.toList());

        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
            answer = Math.max(answer, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(answer);
    }

}