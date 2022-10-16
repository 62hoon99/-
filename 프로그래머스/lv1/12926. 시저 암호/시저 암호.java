import java.util.*;

class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if('a' <= chars[i] && chars[i] <= 'z'){
                if(chars[i] + n > 'z'){
                    chars[i] += n - 'z' + 'a' - 1;
                } else{
                    chars[i] += n;
                }
            } else if('A' <= chars[i] && chars[i] <= 'Z'){
                if(chars[i] + n > 'Z'){
                    chars[i] += n - 'Z' + 'A' - 1;
                } else{
                    chars[i] += n;
                }
            }
        }
        return new String(chars);
    }
}