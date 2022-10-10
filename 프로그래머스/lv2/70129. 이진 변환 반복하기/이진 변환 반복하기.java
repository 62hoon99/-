class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero_count = 0;
        int count = 0;
        String str = s;
        
        
        while(!str.equals("1")) {
            String new_str = str.replace("0", "");
            zero_count += str.length() - new_str.length();
            str = Integer.toBinaryString(new_str.length());
            count++;
        }
        answer[0] = count;
        answer[1] = zero_count;
        
        return answer;
    }
}