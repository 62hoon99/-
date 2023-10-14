import java.util.*;
import java.math.*;

class Solution {
    public int solution(int storey) {
        return find(storey, 0);
    }
    
    private int find(int storey, int num) {
        if (storey == 0) {
            return num;
        }
        
        int a = storey % 10;
        int plusResult = find((storey + a) / 10, num + 10 - a);
        int minusResult = find((storey - a) / 10, num + a);
        
        return Math.min(plusResult, minusResult);
    }
}