import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // map을 사용하여 계산하자
        // (개수 + 1) * (개수 + 1) ... - 1 하면 정답
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] clo : clothes) {
            map.put(clo[1], map.getOrDefault(clo[1], 0) + 1);
        }
        
        for(Integer value : map.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}