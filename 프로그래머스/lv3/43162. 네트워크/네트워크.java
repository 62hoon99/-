import java.util.*;

class Solution {
    
    private int answer = 0;
    private Set<Integer> nodes = new HashSet<>();
    
    public int solution(int n, int[][] computers) {
        
        for (int i = 0; i < computers.length; i++) {
            dfs(i, computers, 0);
        }
        
        return answer;
    }
    
    private void dfs(int idx, int[][] computers, int depth) {
        // 이미 갔다온 노드일 경우
        if (!nodes.add(idx)) {
            return;
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (i != idx && computers[idx][i] == 1) {
                computers[idx][i] = 0;
                computers[i][idx] = 0;
                dfs(i, computers, depth + 1);
            }
        }
        
        if (depth == 0) {
            answer++;
        }
    }
}