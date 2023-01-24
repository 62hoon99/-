class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //남은 시간동안 가격이 떨어지지만 않으면 남은 초가 정답이 된다.
        //최소값을 들고 있는다.
        
        for(int i = 0; i < prices.length-1; i++) {
            for(int k = i+1; k < prices.length; k++) {
                if(prices[k] < prices[i]) {
                    answer[i] = k-i;
                    break;
                }
                if(k == prices.length-1) {
                    answer[i] = k-i;
                }
            }
        }
        
        return answer;
    }
}