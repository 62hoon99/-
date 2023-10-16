import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        boolean type1 = true;
        boolean type2 = true;
        
        int arrayLength = arrayA.length < arrayB.length ? arrayB.length : arrayA.length;
        
        for (int i = 2; i < 100_000_001; i++) {
            type1 = true;
            type2 = true;
            
            for (int k = 0; k < arrayLength; k++) {
                if (!type1 && !type2) {
                    break;
                }
                
                if (type1) {
                    if (arrayA.length > k && arrayA[k] % i != 0) {
                        type1 = false;
                    }
                    if (arrayB.length > k && arrayB[k] % i == 0) {
                        type1 = false;
                    }
                    //System.out.println("type1:" + type1 + "/type2:" + type2 + "/k:" + k + "/i:" + i);
                }
                
                if (type2) {
                    if (arrayB.length > k && arrayB[k] % i != 0) {
                        type2 = false;
                    }
                    if (arrayA.length > k && arrayA[k] % i == 0) {
                        type2 = false;
                    }
                    //System.out.println("type1:" + type1 + "/type2:" + type2 + "/k:" + k + "/i:" + i);
                }
            }
            
            if (type1 || type2) {
                answer = Math.max(answer, i);
            }
        }
        
        return answer;
    }
}