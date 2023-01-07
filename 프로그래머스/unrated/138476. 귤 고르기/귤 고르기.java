import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
    
        List<Integer> valueList = new ArrayList(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        for(int value : valueList) {
            k -= value;
            answer++;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}