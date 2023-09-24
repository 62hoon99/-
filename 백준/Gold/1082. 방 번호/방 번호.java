

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[M + 1]; // dp[i] stores the maximum room number for budget i

        for (int i = 0; i <= M; i++) {
            dp[i] = BigInteger.ZERO;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= P[j]) {
                    dp[i] = dp[i].max(dp[i - P[j]].multiply(BigInteger.TEN).add(BigInteger.valueOf(j)));
                }
            }
        }

        System.out.println(dp[M]);
    }
}