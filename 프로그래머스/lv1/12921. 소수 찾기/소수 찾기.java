class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        for(int i=2; i<=n; i++) {
            count = 0;
            for(int k=1; k<=Math.sqrt(i); k++) {
                if(i%k == 0) count++;
                if(count > 1) break;
            }
            if(count == 1) answer++;
        }
        return answer;
    }
}