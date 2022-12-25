import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 0 1 2 3 4 5 ( n = 3 ) n으로 나눈 나머지가 0이면 1번사람 1이면 2번사람...
        // 1.마지막 문자인지 확인 2. 이전에 등장했던 단어인지 확인 3. 한 글자인 단어인지 확인
        for(int i = 0; i < words.length; i++) {
            if(i == 0) {
                if(words[i].length() == 1) {
                    answer[0] = 1;
                    answer[1] = 1;
                    break;
                }
                continue;
            }

            if(isDuplicate(words[i], Arrays.copyOf(words, i))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
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
    
        private boolean isDuplicate(String word, String[] words) {
        for (String s : words) {
            if(s.equals(word)) {
                return true;
            }
        }
        return false;
    }
}