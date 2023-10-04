

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            for (int k = 0; k < strings.length; k++) {
                arr[i][k] = Integer.parseInt(strings[k]);
            }
        }

        br.close();

        System.out.println(solution(arr));
    }

    private static int solution(int[][] arr) {
        return recursion(arr, 0, arr.length);
    }

    private static int recursion(int[][] arr, int depth, int N) {
        if (depth == 5) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    max = Math.max(max, anInt);
                }
            }

            return max;
        }

        // 왼쪽
        int[][] newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for (int k = 0; k < N; k++) {
                if (arr[i][k] == 0) {
                    continue;
                }
                if (!stack.isEmpty() && flag && stack.peek().equals(arr[i][k])) {
                    stack.pop();
                    stack.push(arr[i][k] * 2);
                    flag = false;
                } else {
                    stack.push(arr[i][k]);
                    flag = true;
                }
            }
            while (!stack.isEmpty()) {
                newArr[i][stack.size() - 1] = stack.peek();
                stack.pop();
            }
        }

        int left = recursion(newArr, depth + 1, N);
        for (int[] ints : newArr) {
            Arrays.fill(ints, 0);
        }

        // 오른쪽
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for (int k = N - 1; k >= 0; k--) {
                if (arr[i][k] == 0) {
                    continue;
                }
                if (!stack.isEmpty() && flag && stack.peek().equals(arr[i][k])) {
                    stack.pop();
                    stack.push(arr[i][k] * 2);
                    flag = false;
                } else {
                    stack.push(arr[i][k]);
                    flag = true;
                }
            }
            while (!stack.isEmpty()) {
                newArr[i][N - stack.size()] = stack.peek();
                stack.pop();
            }
        }

        int right = recursion(newArr, depth + 1, N);
        for (int[] ints : newArr) {
            Arrays.fill(ints, 0);
        }

        // 위쪽
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for (int k = 0; k < N; k++) {
                if (arr[k][i] == 0) {
                    continue;
                }
                if (!stack.isEmpty() && flag && stack.peek().equals(arr[k][i])) {
                    stack.pop();
                    stack.push(arr[k][i] * 2);
                    flag = false;
                } else {
                    stack.push(arr[k][i]);
                    flag = true;
                }
            }
            while (!stack.isEmpty()) {
                newArr[stack.size() - 1][i] = stack.peek();
                stack.pop();
            }
        }

        int up = recursion(newArr, depth + 1, N);
        for (int[] ints : newArr) {
            Arrays.fill(ints, 0);
        }

        // 아래쪽
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for (int k = N - 1; k >= 0; k--) {
                if (arr[k][i] == 0) {
                    continue;
                }
                if (!stack.isEmpty() && flag && stack.peek().equals(arr[k][i])) {
                    stack.pop();
                    stack.push(arr[k][i] * 2);
                    flag = false;
                } else {
                    stack.push(arr[k][i]);
                    flag = true;
                }
            }
            while (!stack.isEmpty()) {
                newArr[N - stack.size()][i] = stack.peek();
                stack.pop();
            }
        }

        int down = recursion(newArr, depth + 1, N);
        for (int[] ints : newArr) {
            Arrays.fill(ints, 0);
        }

        return Math.max(Math.max(right, left), Math.max(up, down));
    }

}