class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i=0; i < seoul.length; i++) {
            answer = (seoul[i].equals("Kim")) ? "김서방은 " + i + "에 있다" : answer;
        }

        return answer;
    }
}