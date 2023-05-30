import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";
        
        Arrays.sort(participants);
        Arrays.sort(completions);
        
        for (int i = 0; i < completions.length; i++) {
            if (!participants[i].equals(completions[i])) {
                answer = participants[i];
                break;
            }
        }
        
        if (answer.equals("")) {
            answer = participants[participants.length - 1];
        }
        
        return answer;
    }
}