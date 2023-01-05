import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int index = i;
            while(true) {
                
                if(stack.empty()) {
                    stack.push(s.charAt(index));
                } else {
                    if(s.charAt(index) == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if(s.charAt(index) == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if(s.charAt(index) == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if(s.charAt(index) == '[' || s.charAt(index) == '{' || s.charAt(index) == '(') {
                        stack.push(s.charAt(index));
                    } else {
                        stack.clear();
                        break;
                    }
                }
                index++;
                
                if(index == i) {
                    if(stack.empty()) {
                        answer++;
                    }
                    
                    stack.clear();
                    break;
                }
                
                if(index == s.length() && i == 0) {
                    if(stack.empty()) {
                        answer++;
                    }
                    
                    stack.clear();
                    break;
                }
                
                if(index == s.length()) {
                    index = 0;
                }
            }
        }
        
        return answer;
    }
}