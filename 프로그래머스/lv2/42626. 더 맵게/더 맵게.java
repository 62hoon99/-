import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int s : scoville) {
            queue.add(s);
        }
        
        while(true) {
            Integer first = queue.poll();
            
            if (first >= K) {
                break;
            }
            
            Integer second = queue.poll();
            
            if (second == null) {
                answer = -1;
                break;
            }
            
            queue.add(first + second * 2);
            
            answer++;
        }
        
        
        return answer;
    }
}