import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0L;
        long sum2 = 0L;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        for (int i = 0; i <= queue1.length * 3; i++) {
            if (sum1 == sum2) {
                break;
            } else if (sum1 < sum2) {
                int pollNum = q2.poll();
                sum2 -= pollNum;
                sum1 += pollNum;
                q1.add(pollNum);
                
            } else {
                int pollNum = q1.poll();
                sum1 -= pollNum;
                sum2 += pollNum;
                q2.add(pollNum);
            }
            answer++;
        }
        
        return answer >= queue1.length * 3 ? -1 : answer;
    }
}