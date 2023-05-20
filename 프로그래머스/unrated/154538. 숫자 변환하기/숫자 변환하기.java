class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] arr = new int[y + 1];
        
        if (x == y) {
            return 0;
        }
        
        for (int i = x; i < y + 1; i++) {
            int num = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                if (arr[i / 2] > 0 && num > arr[i / 2] + 1) {
                    num = arr[i / 2] + 1;
                }
                if (i / 2 == x) {
                    num = 1;
                }
            }
            if (i % 3 == 0) {
                if (num > arr[i / 3] + 1 && arr[i / 3] > 0) {
                    num = arr[i / 3] + 1;
                }
                if (i / 3 == x) {
                    num = 1;
                }
            }
            if (i - n >= 0) {
                if (num > arr[i - n] + 1 && arr[i - n] > 0) {
                    num = arr[i - n] + 1;
                }
                if (i - n == x) {
                    num = 1;
                }
            }
            arr[i] = (num == Integer.MAX_VALUE) ? 0 : num;
        }
        
        return arr[y] == 0 ? -1 : arr[y];
    }
}