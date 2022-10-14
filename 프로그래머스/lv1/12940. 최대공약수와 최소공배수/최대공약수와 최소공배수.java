class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(n > m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        if(m % n == 0) {
            answer[0] = n;
        } else {
            answer[0] = 1;
            
            for(int i = m-1; i > 0; i--) {
                if(m % i == 0 && n % i == 0) {
                    answer[0] = i;
                    break;
                }
            }
        }
        
        if(m % n == 0) {
            answer[1] = m;
        } else {
            answer[1] = n*m;
            
            for(int i=2; i<= n; i++) {
                int num = i*m;
                if(num % n == 0 && num % m == 0){
                    answer[1] = num;
                    break;
                }
            }
        }
        
        return answer;
    }
}