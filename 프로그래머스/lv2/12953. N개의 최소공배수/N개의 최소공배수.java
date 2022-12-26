class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        while(true) {
            int flag = 0;
            for(int num : arr) {
                if(answer % num != 0) {
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}