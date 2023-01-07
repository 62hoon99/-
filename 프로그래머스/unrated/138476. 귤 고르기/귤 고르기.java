import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
        for(int value : list) {
            k -= value;
            answer++;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}