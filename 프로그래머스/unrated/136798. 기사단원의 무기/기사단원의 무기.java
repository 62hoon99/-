class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] arr = new int[number];
        for(int i = 1; i <= number; i++) {
            for(int k = 1; k < Math.sqrt(i); k++) {
                if(i % k == 0) {
                    arr[i - 1] += 2;
                }
            }
            if((double)i % Math.sqrt(i) == 0) {
                arr[i - 1]++;
            }
        }
        
        for(int i = 0; i < number; i++) {
            if(arr[i] > limit) {
                arr[i] = power;
            }
        }
        
        for(int num : arr) {
            answer += num;
        }
        
        return answer;
    }
}