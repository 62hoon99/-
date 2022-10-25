import java.util.*;

class Solution {
    public int solution(int n) {
        int[] num = new int[n+1];
        // Arrays.fill(num, 0);
        return pibonacci(num, n);
    }
    
    public static int pibonacci(int[] num, int index) {
        if(num[index] != 0) return num[index];
        if(index <= 1) return index;
        
        num[index] = (pibonacci(num, index - 1) + pibonacci(num, index - 2)) % 1234567;
        return num[index];
    }
}