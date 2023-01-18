import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int num : ingredient) {
            if(num == 1 && stack.size() >= 3) {
                int a = stack.pop(), b = stack.pop(), c = stack.pop();
                if(a == 3 && b == 2 && c == 1) {
                    answer++;
                } else {
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                    stack.push(num);
                }
                continue;
            }
            stack.push(num);
        }
        
        return answer;
    }
}