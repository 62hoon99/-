import java.util.*;

class Solution {
    private int[] checkArr;
    private int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        checkArr = new int[words.length];
        
        dfs(begin, target, words, 0, 0);
        
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int depth, int idx) {
        if (depth == words.length) {
            return;
        }
        
        if (begin.equals(target)) {
            if (answer == 0) {
                answer = depth;
            } else {
                if (answer > depth) {
                    answer = depth;
                }
            }
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            char[] chars = words[i].toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (begin.charAt(k) == chars[k]) {
                    cnt++;
                }
            }
            
            if (cnt == begin.length() - 1 && checkArr[i] == 0) {
                checkArr[i] = 1;
                dfs(words[i], target, words, depth + 1, i);
                checkArr[i] = 0;
            }
        }
    }
}