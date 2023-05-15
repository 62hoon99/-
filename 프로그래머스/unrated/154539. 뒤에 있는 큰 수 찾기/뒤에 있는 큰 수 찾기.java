import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        answer[answer.length - 1] = -1;
        int tmp = numbers.length - 1;
        
        for (int i = answer.length - 2; i >= 0; i--) {
            if (numbers[i] >= numbers[tmp]) {
                answer[i] = -1;
                tmp = i;
                continue;
            }
            
            for (int k = i + 1; k < tmp; k++) {
                if (numbers[i] < numbers[k]) {
                    if (numbers[k] > numbers[tmp]) {
                        tmp = k;
                    }
                    answer[i] = numbers[k];
                    break;
                } else {
                    if (answer[k] == numbers[tmp]) {
                        answer[k] = numbers[tmp];
                        break;
                    }
                }
            }
            if (answer[i] == 0) {
                if (numbers[i] < numbers[tmp]) {
                    answer[i] = numbers[tmp];
                } else {
                    answer[i] = -1;
                }
            }
        }
        
        return answer;
    }
}