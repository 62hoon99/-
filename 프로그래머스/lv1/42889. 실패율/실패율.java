import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] user = new int[N + 1];
        for(int stage : stages) {
            if(stage > N) continue;
            user[stage]++;
        }
        
        int[] users = new int[N + 1];
        users[0] = stages.length;
        for(int i = 1; i < N + 1; i++) {
            users[i] = users[i - 1] - user[i - 1];
        }
        
        double[] per = new double[N + 1];
        for(int i = 1; i < N + 1; i++) {
            if(users[i] == 0) continue;
            
            per[i] = (double) user[i] / users[i];
        }
        
        double[] per2 = per.clone();
        Arrays.sort(per2);
        
        for(int i = N; i > 0; i--) {
            for(int k = 1; k < N + 1; k++) {
                if(per2[i] == per[k]) {
                    per[k] = -1;
                    answer[N - i] = k;
                    break;
                }
            }
        }
    
        return answer;
    }
}