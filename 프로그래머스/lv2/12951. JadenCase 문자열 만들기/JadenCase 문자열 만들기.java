import java.util.*;

class Solution {
    public String solution(String s) {        
        char[] chars = s.toLowerCase().toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(i == 0) {
                chars[i] = returnWord(chars[i]);
            } else {
                if(chars[i - 1] == ' ') {
                    chars[i] = returnWord(chars[i]);
                }   
            }
        }
        
        StringBuilder sb = new StringBuilder();
        return sb.append(chars).toString();
    }
    
    private static char returnWord(char word){
        return Character.isAlphabetic(word) ? Character.toUpperCase(word) : word;
    }
}