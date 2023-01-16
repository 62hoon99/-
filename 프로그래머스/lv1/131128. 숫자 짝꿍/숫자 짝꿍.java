import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        // 내림차순으로 정렬한다.
        // x_index y_index를 만들어서 X가 더 크
        
        int x_index = X.length() -1, y_index = Y.length() - 1;
        char[] chars = X.toCharArray();
        Arrays.sort(chars);
        X = new String(chars);
        
        chars = Y.toCharArray();
        Arrays.sort(chars);
        Y = new String(chars);
        
        while(x_index >= 0 && y_index >= 0) {
            if(X.charAt(x_index) == Y.charAt(y_index)) {
                answer.append(X.charAt(x_index));
                x_index--;
                y_index--;
            } else if(X.charAt(x_index) > Y.charAt(y_index)) {
                x_index--;
            } else {
                y_index--;
            }
        }
        
        if(answer.length() == 0) {
            return "-1";
        }
        if(answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}