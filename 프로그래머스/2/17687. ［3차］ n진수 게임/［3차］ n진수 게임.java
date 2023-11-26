import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        // a 미리 구할 숫자의 갯수를 순회하면서 n진수로 바꾼 문자열을 만든다
        
        // a 문자열을 한자리씩 나눈다
        
        // (i + 1) % m == (p % m)
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        //System.out.println(sb.toString());
        
        String[] arr = sb.toString().split("");
        
        for (int i = 0; i < arr.length; i++) {
            if (i % m == p - 1) {
                answer.append(arr[i].toUpperCase());
            }
            if (answer.length() == t) {
                break;
            }
        }
        
        return answer.toString();
    }
}