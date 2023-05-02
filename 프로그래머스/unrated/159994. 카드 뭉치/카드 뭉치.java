import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goals) {
        String answer = "Yes";
        Stack<String> stack1 = getStack(cards1);
        Stack<String> stack2 = getStack(cards2);
        
        for (String goal : goals) {
            if (!stack1.isEmpty() && stack1.peek().equals(goal)) {
                stack1.pop();
                continue;
            }
            if (!stack2.isEmpty() && stack2.peek().equals(goal)) {
                stack2.pop();
                continue;
            }
            answer = "No";
            break;
        }
        
        return answer;
    }
    
    private Stack<String> getStack(String[] cards) {
        Stack<String> stack = new Stack<>();
        for (int i = cards.length - 1; i >= 0; i--) {
            stack.push(cards[i]);
        }
        return stack;
    }
}