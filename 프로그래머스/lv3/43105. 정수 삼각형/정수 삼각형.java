import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] answer = new int[triangle.length][];
        answer[0] = new int[1];
        answer[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++) {
            answer[i+1] = new int[triangle[i+1].length];
            for(int k=0; k<triangle[i].length; k++) {
                int left = triangle[i+1][k] + answer[i][k];
                int right = triangle[i+1][k+1] + answer[i][k];
                if(left > answer[i+1][k]) answer[i+1][k] = left;
                if(right > answer[i+1][k+1]) answer[i+1][k+1] = right;
            }
        }
        
        // for(int i=0; i<triangle.length; i++) {
        //     System.out.println(Arrays.toString(answer[i]));
        // }
        
        Arrays.sort(answer[triangle.length-1]);
        return answer[triangle.length-1][triangle[triangle.length-1].length - 1];
    }
}