import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int num : priorities) {
            queue.add(num);
        }
        
        Arrays.sort(priorities);
        Stack<Integer> stack = new Stack<>();
        for(int num : priorities) {
            stack.push(num);
        }
        
        while(!queue.isEmpty()) {
            int priority = queue.poll();
            if(priority == stack.peek()) {
                answer++;
                stack.pop();
                if(location == 0) {
                    break;
                }
            } else {
                if(location == 0) {
                    location = queue.size() + 1;
                }
                queue.add(priority);
            }
            
            location--;
        }
        
        return answer;
    }
}