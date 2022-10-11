import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++) {
            if(st.empty()){
                if(arr[i] == ')'){
                    System.out.println("hh");
                    return answer;
                } else {
                    st.push(arr[i]);
                }
            } else {
                if(arr[i] == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(arr[i]);
                }
            }
        }
        
        answer = (st.size() > 0) ? false : true;

        return answer;
    }
}