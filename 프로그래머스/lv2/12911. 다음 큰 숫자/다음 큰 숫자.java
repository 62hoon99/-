import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binary_n = Integer.toBinaryString(n);
        int cnt_n = getCount_1(binary_n);
        
        int tmp = n;
        while(true) {
            if(getCount_1(Integer.toBinaryString(++tmp)) == cnt_n) {
                answer = tmp;
                break;
            }
        }
        
        return answer;
    }
    
    public int getCount_1(String binaryNumber) {
        int cnt = 0;
        
        for(int i = 0; i < binaryNumber.length(); i++) {
            if(binaryNumber.charAt(i) == '1') cnt++;
        }
        
        return cnt;
    }
}