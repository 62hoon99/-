

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars1 = br.readLine().toCharArray();
        char[] chars2 = br.readLine().toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 0; i < chars1.length; i++) {
            for (int k = 0; k < chars2.length; k++) {
                if (chars1[i] == chars2[k]) {
                    dp[i + 1][k + 1] = dp[i][k] + 1;
                } else {
                    dp[i + 1][k + 1] = Math.max(dp[i][k + 1], dp[i + 1][k]);
                }
            }
        }

        System.out.println(dp[chars1.length][chars2.length]);

        br.close();
    }

}