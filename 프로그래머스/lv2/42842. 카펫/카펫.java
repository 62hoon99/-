import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int col = 3, row = 3;
        
        // row * 2 + { (col - 2) * 2 } == brown
        // row * col - brown == yellow
        // 1. col을 늘려가면서 찾는다. brown 개수보다 커지면 row개수를 + 1 하고 col은 row와 같은 숫자로 바꾼다.
        // 2. brown개수와 일치하는 경우 yellow 개수와도 일치하는지 확인한다.
        
        while(true) {
            if((row * 2 + ((col - 2) * 2)) > brown) {
                row++;
                col = row;
            } else if ((row * 2 + ((col - 2) * 2)) < brown) {
                col++;
            } else {
                if(row * col - brown == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
                col++;
            }
        }
        
        return answer;
    }
}