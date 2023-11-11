

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        br.close();

        StringBuilder sb = new StringBuilder();

        String[] split = input.split("-");
//        System.out.println(Arrays.toString(split));

        for (int i = 0 ; i < split.length; i++) {
            int sum = 0;
            for (char c : split[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(Integer.parseInt(c + ""));
                }
                if (!Character.isDigit(c)) {
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0) {
                sum += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
            split[i] = sum + "";
        }

        int answer = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            answer -= Integer.parseInt(split[i]);
        }

        System.out.println(answer);
    }

}