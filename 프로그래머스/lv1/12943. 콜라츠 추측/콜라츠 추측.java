class Solution {
    public int solution(int num) {
        long answer = (long)num;
        int count = 0;
        
        while(count < 500) {
            if(answer == 1) return count;
            
            if(answer % 2 == 0){
                answer /= 2;
            } else {
                answer = answer*3 + 1;
            }
            count++;
        }
        System.out.println(count);
        return -1;
    }
}