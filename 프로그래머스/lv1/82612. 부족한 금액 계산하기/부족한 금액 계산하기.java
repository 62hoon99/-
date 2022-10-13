class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        
        for(int i=1; i<=count; i++) {
            totalPrice += i * price;
        }

        return (totalPrice < money) ? 0 : totalPrice - money;
    }
}