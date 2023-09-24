
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] WV = br.readLine().split(" ");
            objects.add(new Object(Integer.parseInt(WV[0]), Integer.parseInt(WV[1])));
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < dp.length; i++) {
            Object object = objects.get(i - 1);
            for (int k = 0; k < dp[0].length; k++) {
                if (k - object.weight >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], (dp[i - 1][k - object.weight] + object.value));
                } else {
                    dp[i][k] = dp[i - 1][k];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    private static class Object {
        private int weight;
        private int value;

        public Object(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}