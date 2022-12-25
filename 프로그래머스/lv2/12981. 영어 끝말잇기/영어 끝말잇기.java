import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < words.length; i++) {
            if(!set.add(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            if(i == 0) {
                if(words[i].length() == 1) {
                    answer[0] = 1;
                    answer[1] = 1;
                    break;
                }
                continue;
            }

            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            if(words[i].length() == 1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }

        return answer;
    }
}