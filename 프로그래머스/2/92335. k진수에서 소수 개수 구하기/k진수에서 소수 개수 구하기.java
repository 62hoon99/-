import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] arr = Integer.toString(n, k).split("");
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : arr) {
            if (s.equals("0")) {
                if (sb.length() > 0) {
                    long num = Long.parseLong(sb.toString());
                    if (isPrimeNumber(num)) {
                        // System.out.println(num);
                        answer++;
                    }
                }
                sb = new StringBuilder();
                continue;
            }
            
            sb.append(s);
        }
        
        if (sb.length() > 0) {
            long num = Long.parseLong(sb.toString());
                    if (isPrimeNumber(num)) {
                        // System.out.println(num);
                        answer++;
                    }
        }
        
        return answer;
    }
    
    private boolean isPrimeNumber(long num) {
        if (num == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}