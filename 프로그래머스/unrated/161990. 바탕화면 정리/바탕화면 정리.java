import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {-1, -1, -1, -1};
        
        // colloum
        for (int i = 0; i < wallpaper[0].length(); i++) {
            for (int k = 0; k < wallpaper.length; k++) {
                // luy
                if (answer[1] == -1 && wallpaper[k].charAt(i) == '#') {
                    answer[1] = i;
                }
                
                // rdx
                if (wallpaper[k].charAt(i) == '#') {
                    answer[3] = i + 1;
                }
            }
        }
        
        // row
        for (int i = 0; i < wallpaper.length; i++) {
            for (int k = 0; k < wallpaper[i].length(); k++) {
                // lux
                if (answer[0] == -1 && wallpaper[i].charAt(k) == '#') {
                    answer[0] = i;
                }
                
                // rdx
                if (wallpaper[i].charAt(k) == '#') {
                    answer[2] = i + 1;
                }
            }
        }
        
        
        return answer;
    }
}