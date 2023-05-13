import java.util.*;

class Solution {
    
    private int[] check;
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        check = new int[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int depth) {
        answer = Math.max(answer, depth);
        
        if (depth == dungeons.length) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (check[i] == 0 && k >= dungeons[i][0]) {
                check[i] = 1;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                check[i] = 0;
            }   
        }
    }
}