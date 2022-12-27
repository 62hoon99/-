class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(true) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            
            if(a == b) {
                break;
            }
            
            answer++;
        }

        return answer;
    }
}