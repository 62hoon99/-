import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int l_a = 3, l_b = 0, r_a = 3, r_b = 2;
        for(int number : numbers) {
            if(number != 0 && number % 3 == 0) {
                answer.append('R');
                r_a = number / 3 - 1;
                r_b = 2;
                continue;
            }
            
            if(number != 0 && number % 3 == 1) {
                answer.append('L');
                l_a = number / 3;
                l_b = 0;
                continue;
            }
            
            int a = number / 3, b = 1;
            if(number == 0) {
                a = 3;
            }
            
            int dis_l = Math.abs(l_a - a) + Math.abs(l_b - b);
            int dis_r = Math.abs(r_a - a) + Math.abs(r_b - b);
            if(dis_l > dis_r) {
                answer.append('R');
                r_a = a;
                r_b = b;
            } else if(dis_l < dis_r) {
                answer.append('L');
                l_a = a;
                l_b = b;
            } else {
                if(hand.equals("right")) {
                    answer.append('R');
                    r_a = a;
                    r_b = b;
                } else {
                    answer.append('L');
                    l_a = a;
                    l_b = b;
                }
            }
        }
        
        return answer.toString();
    }
}