import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        
        for (int k = 0; k < photos.length; k++) {
            for (String n : photos[k]) {
                for (int i = 0; i < name.length; i++) {
                    if (n.equals(name[i])) {
                        answer[k] += yearning[i];
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}