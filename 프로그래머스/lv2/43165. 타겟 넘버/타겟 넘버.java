import java.util.*;

class Solution {
    private int height;

    private int dfs(int[] numbers, int depth, int sum, int target) {
        if(depth == height) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        
        return dfs(numbers, depth + 1, sum + numbers[depth], target)
            + dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        height = numbers.length;
        answer = dfs(numbers, 0, 0, target);
        
        return answer;
    }
}