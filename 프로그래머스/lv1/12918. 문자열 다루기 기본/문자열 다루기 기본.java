class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] chars = s.toCharArray();
        if(s.length() == 4 || s.length() == 6){
            for(char ch : chars) {
                if(!Character.isDigit(ch)){
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
}