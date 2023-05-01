import java.util.*;

class Solution {
    
    private String[] alphabets;
    
    {
        alphabets = new String[26];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = String.valueOf((char) (i + 'a'));
        }
    }
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (String target : s.split("")) {
            answer += getOverIndexAlphabet(target, skip, index);
        }
        
        return answer;
    }
    
    private String getOverIndexAlphabet(String target, String skip, int index) {
        int targetIndex = 0;
        
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i].equals(target)) {
                targetIndex = i + 1;
                break;
            }
        }
        
        int cnt = 0;
        String overIndexAlphabet = "";
        List<String> skipAlps = Arrays.asList(skip.split(""));
        
        while(true) {
            if (targetIndex > alphabets.length - 1) {
                targetIndex = 0;
                continue;
            }
            
            if (!skipAlps.contains(alphabets[targetIndex++])) {
                cnt++;
            }
            
            if (cnt == index) {
                overIndexAlphabet = alphabets[targetIndex - 1];
                break;
            }
        }
        
        return overIndexAlphabet;
    }
}