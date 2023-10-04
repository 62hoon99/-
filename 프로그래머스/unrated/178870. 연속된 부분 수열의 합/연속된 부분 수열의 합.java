import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        // 왼쪽 포인터 lp , 오른쪽 포인터 rp
        // 총 합이 k보다 크거나 같으면 lp가 +1 이동
        // 총 합이 k보다 작으면 rp가 +1 이동
        
        // 총 합이 k와 같을 때 answer[1] - answer[0] 보다 작으면 answer 교체
        
        int lp = 0;
        int rp = 0;
        int sum = sequence[0];
        
        while (lp < sequence.length && rp < sequence.length) {
            if (sum == k && answer[1] - answer[0] > rp - lp) {
                answer[0] = lp;
                answer[1] = rp;
            }
            
            if (sum >= k) {
                sum -= sequence[lp++];
            } else {
                if (rp == sequence.length - 1) {
                    break;
                }
                sum += sequence[++rp];
            }
        }
        
        return answer;
    }
}