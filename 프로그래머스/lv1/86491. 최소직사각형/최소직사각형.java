import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        int width=0;
        int height=0;
        for(int i=0; i<sizes.length; i++) {
            width = Math.max(sizes[i][0], width);
            height = Math.max(sizes[i][1], height);
        }
        return width*height;
    }
    
}