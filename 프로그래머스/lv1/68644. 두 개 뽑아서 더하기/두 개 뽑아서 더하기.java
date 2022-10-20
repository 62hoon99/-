import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
            for(int k=i+1; k<numbers.length; k++) {
                Integer sum = numbers[i] + numbers[k];
                if(!result.contains(sum)) result.add(sum);
            }
        }
        // System.out.println(result.toString());
        
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}