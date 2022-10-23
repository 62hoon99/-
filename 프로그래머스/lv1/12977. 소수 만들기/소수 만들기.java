import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> set = new ArrayList();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    set.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        
        for(int num : set) {
            int count = 0;
            for(int j=2; j<=Math.sqrt(num); j++) {
                if(num % j == 0) count++;
            }
            if(count == 0) answer++;
        }

        return answer;
    }
}