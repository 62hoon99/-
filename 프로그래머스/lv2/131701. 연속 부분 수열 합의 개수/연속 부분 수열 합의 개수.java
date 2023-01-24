import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] arr = new int[elements.length * 2];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        System.arraycopy(elements, 0, arr, elements.length, elements.length);
        
        Set<Integer> set = new HashSet<>();
        
        for(int len = 1; len <= elements.length; len++) {
            for(int i = 0; i < elements.length; i++) {
                int sum = 0;
                for(int k = i; k < i+len; k++) {
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}