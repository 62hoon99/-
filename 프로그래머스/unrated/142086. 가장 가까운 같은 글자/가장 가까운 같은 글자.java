import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        
        for(int i = 1; i < answer.length; i++) {
            for(int k = i - 1; k >= 0; k--) {
                if(s.charAt(i) == s.charAt(k)) {
                    answer[i] = i - k;
                    break;
                }
            }
        }
        
        return answer;
    }
}