import java.util.*;

class Solution {
    public int solution(int n) {
        Stack<Integer> st = new Stack<>();
        int num = n;
        
        while(num > 0) {
            st.push(num % 3);
            num /= 3;
        }
        
        int answer = 0;
        int size = st.size();
        for(int i=0; i<size; i++) {
            answer += Math.pow(3, i) * st.pop();
        }
        
        return answer;
    }
}