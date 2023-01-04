import java.util.*;
import java.math.BigInteger;

class Solution {
    public long solution(int n) {
        long[] arr = new long[n + 1];
        return ss(n, arr) % 1234567;
    }
    
    public long ss(int n, long[] arr) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(arr[n] > 0) return arr[n];
        
        arr[n] = ss(n - 1, arr) + ss(n - 2, arr);
        return arr[n] % 1234567;
    }
}