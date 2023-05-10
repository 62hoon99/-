import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < discount.length; i++) {
            String disName = discount[i];
            map.put(disName, map.getOrDefault(disName, 0) + 1);
            if (i < 9) {
                continue;
            }
            
            if (i > 9) {
                map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
            }
            
            if (checkMap(want, number, map)) {
                answer++;    
            }
        }
        
        return answer;
    }
    
    private boolean checkMap(String[] want, int[] number, Map<String, Integer> map) {
        int cnt = 0;
        
        for (int i = 0; i < want.length; i++) {
            // System.out.println(want[i] + "" + map.getOrDefault(want[i], 0));
            if (map.getOrDefault(want[i], 0) == number[i]) {
                cnt++;        
            }
        }
        
        // System.out.println(cnt);
        
        return cnt == want.length;
    }
}