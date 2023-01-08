class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long num = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++) {
            if(num >= Long.parseLong(t.substring(i, i + p.length()))) {
                answer++;
            }
        }
        
        return answer;
    }
}