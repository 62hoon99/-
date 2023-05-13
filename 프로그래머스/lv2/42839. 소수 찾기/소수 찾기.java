import java.util.*;

class Solution {
    
    private int[] check;
    private int answer = 0;
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        check = new int[numbers.length()];
        String strs[] = numbers.split("");
        dfs(strs, "");
        
        for (Integer num : set) {
            if (isPrimeNumber(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(String strs[], String str) {
        if (str.length() == strs.length) {
            return;
        }
        
        for (int i = 0; i < strs.length; i++) {
            if (check[i] == 0) {
                String number = str + strs[i];
                set.add(Integer.parseInt(number));
                check[i] = 1;
                dfs(strs, number);
                check[i] = 0;
            }
        }
    }
    
    private boolean isPrimeNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        
        int ab = (int) Math.sqrt(num);
        
        for (int i = 2; i <= ab; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}