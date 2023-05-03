import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> touchMap = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char alp = key.charAt(i);
                if (touchMap.containsKey(alp)) {
                    if (touchMap.get(alp) > i + 1) {
                        touchMap.put(alp, i + 1);   
                    }
                } else {
                    touchMap.put(alp, i + 1);
                }
            }
        }
        
        
        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String target = targets[i];
            for (int k = 0; k < target.length(); k++) {
                if (touchMap.containsKey(target.charAt(k))) {
                    cnt += touchMap.get(target.charAt(k));
                } else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        
        
        return answer;
    }
}