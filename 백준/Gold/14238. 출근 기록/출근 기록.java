

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        br.close();

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);

        for (String s : input.split("")) {
            map.put(s, map.get(s) + 1);
        }

        solution("", map.get("A"), map.get("B"), map.get("C"), 0, 0);
        if (!flag) {
            System.out.println(-1);
        }
    }

    private static boolean flag = false;
    private static int[][][][][] dp = new int[51][51][51][3][3];

    private static void solution(String s, int a, int b, int c, int prev1, int prev2) {
        if (flag){
            return;
        }

        if (a == 0 && b == 0 && c == 0) {
            System.out.println(s);
            flag = true;
            return;
        }

        if (dp[a][b][c][prev1][prev2] == 1) {
            return;
        }

        dp[a][b][c][prev1][prev2] = 1;

        if (a > 0) {
            solution(s + "A",  a - 1, b, c , 0, prev1);
        }
        if (b > 0 && prev1 != 1) {
            solution(s + "B",  a, b - 1, c , 1, prev1);
        }
        if (c > 0 && prev1 != 2 && prev2 != 2) {
            solution(s + "C", a, b, c - 1, 2, prev1);
        }
    }

}