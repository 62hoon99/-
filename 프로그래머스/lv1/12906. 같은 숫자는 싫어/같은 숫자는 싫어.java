import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> st = new Stack<>();
        for(int num : arr) {
            if(st.isEmpty() || num != st.peek()) {
                st.push(num);
            }
        }
        
        int[] answer = new int[st.size()];
        int index = answer.length - 1;
        while(!st.isEmpty()) {
            answer[index--] = st.pop();
        }

        return answer;
    }
}