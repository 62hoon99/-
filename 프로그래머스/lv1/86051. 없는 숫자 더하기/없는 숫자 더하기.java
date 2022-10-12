class Solution {
    public int solution(int[] numbers) {
        int[] check = new int[10];
        for(int num : numbers) {
            check[num] = 1;
        }
        int answer = 0;
        for(int i=0; i<10; i++) {
            if(check[i] != 1) answer += i;
        }
        return answer;
    }
}