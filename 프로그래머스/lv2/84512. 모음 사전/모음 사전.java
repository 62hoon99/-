class Solution {
    private boolean find = false;
    private int answer = 0;
    
    public int solution(String word) {
        String[] aeiou = {"A", "E", "I", "O", "U"};
        dfs(word, aeiou, "");
        return answer - 1;
    }
    
    private void dfs(String word, String[] aeiou, String str) {
        answer++;
        if (str.equals(word)) {
            find = true;
            return;
        }
        if (str.length() == aeiou.length) {
            return;
        } 
        
        for (int i = 0; i < aeiou.length; i++) {
            dfs(word, aeiou, str + aeiou[i]);
            if (find) {
                return;
            }
        }
    }
}