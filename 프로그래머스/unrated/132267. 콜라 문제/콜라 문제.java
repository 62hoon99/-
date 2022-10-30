class Solution {
    public int solution(int a, int b, int n) {          
        int total = n;
        int received = 0;
        while(total >= a) {
            total -= a;
            total += b;
            received += b;
        }
        return received;
    }
}