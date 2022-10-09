class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int upper, lower;
        if(a > b){
            upper = a;
            lower = b;
        } else {
            upper = b;
            lower = a;
        }
        
        for(int i=lower; i<=upper; i++) {
            answer+=i;
        }
        
        return answer;
    }
}