import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // section에서 현재 값에서 m - 1한 값이 있는 곳까지 idx를 움직인다.
        int tmp = 0;
        for (int i = 0; i < section.length; i++) {
            if (tmp < section[i]) {
                tmp = section[i] + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}