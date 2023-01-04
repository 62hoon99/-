import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬시킨다. 한 바퀴 돌면서 검사한다.
        
        if(citations.length == 1) {
            return (citations[0] == 1) ? 1 : 0;
        }
        
        Arrays.sort(citations);
        
        for(int i = 1; i <= citations.length; i++) {
            if(citations[citations.length - i] >= i) {
                answer = i;
            }
        }
        
        return answer;
    }
}