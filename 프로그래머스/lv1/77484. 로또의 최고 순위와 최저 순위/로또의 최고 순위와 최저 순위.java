import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Set<Integer> set = new HashSet<>();
        for(int num : lottos) {
            if(num > 0) {
                set.add(num);
            }
        }
        
        int cnt = 0;
        for(int num : win_nums) {
            if(set.contains(num)) {
                cnt++;
            }
        }
        
        answer[1] = (cnt > 1) ? (7 - cnt) : 6;
        
        for(int num : win_nums) {
            set.remove(num);
        }
        
        answer[0] = (set.size() >= 5) ? 6 : (set.size() + 1);
        
        return answer;
    }
}

// lottos를 0을 제외한 set을 만든다.
// win_nums를 돌면서 set에 win_num이 있으면 remove한다.
// set이 0이면 최고 순위 1, 1이면 순위 2 ... 5이상이면 최고 순위 6

// set에 포함된 win_nums를 찾는다. 0이면 6, 1이면 6, 2이면 5...