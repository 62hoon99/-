import java.util.*;

class Solution {
    private int bfs(int[][] maps) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0,0,1));
        maps[0][0] = 0;
        
        while(!queue.isEmpty()) {
            List<Integer> tmp = queue.poll();
            int a = tmp.get(0);
            int b = tmp.get(1);
            int depth = tmp.get(2);
            
            if(a == maps.length - 1 && b == maps[0].length - 1) {
                return depth;
            }
            
            if(a + 1 < maps.length && maps[a + 1][b] == 1) {
                queue.add(List.of(a+1, b, depth+1));
                maps[a + 1][b] = 0;
            }
            
            if(b + 1 < maps[0].length && maps[a][b + 1] == 1) {
                queue.add(List.of(a, b+1, depth+1));
                maps[a][b + 1] = 0;
            }
            
            if(a > 0 && maps[a - 1][b] == 1) {
                queue.add(List.of(a-1, b, depth+1));
                maps[a - 1][b] = 0;
            }
            
            if(b > 0 && maps[a][b - 1] == 1) {
                queue.add(List.of(a, b-1, depth+1));
                maps[a][b - 1] = 0;
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
}