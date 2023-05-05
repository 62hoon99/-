class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] arr = new int[n + 1][m + 1];
        arr[1][1] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            for (int k = 1; k < m + 1; k++) {
                boolean flag = true;
                for (int j = 0; j < puddles.length; j++) {
                    if (puddles[j][1] == i && puddles[j][0] == k) {
                        flag = false;
                        break;
                    }
                }
                
                if (!(i == 1 && k == 1) && flag) {
                    arr[i][k] = (arr[i - 1][k] + arr[i][k - 1]) % 1000000007;   
                }
            }
        }
        
        return arr[n][m];
    }
}